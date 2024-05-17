package cam.PokeAPI.db;

import cam.PokeAPI.api.objects.Move;
import cam.PokeAPI.api.objects.PokemonEVObject;
import cam.PokeAPI.api.objects.PokemonObject;
import cam.PokeAPI.db.models.MoveModel;
import cam.PokeAPI.db.models.PokemonEVModel;
import cam.PokeAPI.db.models.PokemonModel;
import cam.PokeAPI.db.queries.EVQueries;
import cam.PokeAPI.db.queries.PokemonQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonDB {
  static Connection connection;

  static {
    try {
      final String DB_URL = String.format(
          "jdbc:postgresql://%s:%s/%s?user=%s&password=%s",
          env("DB_HOST"), env("DB_PORT"),
          env("DB_NAME"), env("DB_USER"),
          env("DB_PASS")
      );
      connection = DriverManager.getConnection(DB_URL);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static String env(String txt) {
    return System.getenv(txt);
  }

  public static PokemonObject getPokemonObject(String name) throws SQLException {
    String sql = PokemonQueries.getPokemon(true);
    PreparedStatement st = connection.prepareStatement(sql);
    st.setString(1, name);
    ResultSet rs = st.executeQuery();

    if(rs == null) {
      st.close();
    } else {
      try {
        while(rs.next()) {
          String[] elements = rs.getString("elements").split(",");
          String[] moves = rs.getString("moves").split(",");
          String[] abilities = rs.getString("abilities").split(",");
          String[] evNames = rs.getString("evs").split(",");

          int pokemonNumber = rs.getInt("number");
          String pokemonName = rs.getString("name");
          String pokemonSubName = rs.getString("sub_name");

          PokemonModel model = new PokemonModel(
              pokemonNumber, pokemonName, pokemonSubName,
              rs.getString("icon_path"), rs.getInt("total"), rs.getInt("hp"),
              rs.getInt("attack"), rs.getInt("defense"), rs.getInt("special_attack"),
              rs.getInt("special_defense"), rs.getInt("speed"), rs.getString("species"),
              rs.getFloat("height"), rs.getFloat("weight"), rs.getInt("catch_rate_num"),
              rs.getFloat("catch_rate_percent"), rs.getInt("friendship_num"),
              rs.getString("friendship_extremity"), rs.getInt("base_exp"), rs.getString("growth_rate"),
              rs.getFloat("gender_male_percent"), rs.getFloat("gender_female_percent"),
              rs.getInt("egg_cycles_num"), rs.getInt("egg_cycles_steps_min"),
              rs.getInt("egg_cycles_steps_max")
          );

          rs.close();
          st.close();

          //TODO: get evs
          PokemonEVObject[] evs = new PokemonEVObject[evNames.length];

          for(int i = 0; i < evNames.length; i++) {
            String evName = evNames[i];
            String evSQL = EVQueries.getEV();
            st = connection.prepareStatement(evSQL);
            {
              st.setInt(1, pokemonNumber);
              st.setString(2, pokemonName);
              st.setString(3, pokemonSubName);
              st.setString(4, evName);
            }
            rs = st.executeQuery();
            PokemonEVModel evModel = new PokemonEVModel(rs);
            evs[i] = new PokemonEVObject(evModel.getEv_name(), evModel.getEv_amount());

            st.close();
            rs.close();
          }

          return new PokemonObject(elements, moves, abilities, evs, model);
        }
      } finally {
        rs.close();
        st.close();
      }
    }

    return null;
  }

  public static PokemonModel getPokemon(String name, boolean includeElements) throws SQLException {
    String moveDataSQL = PokemonQueries.getPokemon(includeElements);
    PreparedStatement st = connection.prepareStatement(moveDataSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    st.setString(1, name);
    ResultSet rs = st.executeQuery();

    if(rs == null) {
      st.close();
      return null;
    } else {
      PokemonModel model = new PokemonModel(rs);
      st.close();
      rs.close();
      return model;
    }
  }
}
