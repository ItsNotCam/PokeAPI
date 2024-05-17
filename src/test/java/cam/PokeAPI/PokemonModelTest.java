package cam.PokeAPI;

import cam.PokeAPI.db.models.MoveModel;
import cam.PokeAPI.db.models.PokemonModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class PokemonModelTest {
  @Test
  public void PokemonTest() {
    final String DB_URL = "jdbc:postgresql://localhost:5432/pokemon?user=cam&password=ok";
    final String EXPECTED_OUTPUT = "4 Charmander  charmander.png 309 39 52 43 60 50 65 Lizard Pokémon null null 45 null 5 normal 62 Medium Slow null null 20 4884 5140";

    Connection connection = null;
    Statement st = null;
    ResultSet rs = null;
    try {
      connection = DriverManager.getConnection(DB_URL);
      st = connection.createStatement();
      rs = st.executeQuery("SELECT * FROM pokemon WHERE name='Charmander'");
      PokemonModel pokemonModel = new PokemonModel(rs);
      Assertions.assertEquals(EXPECTED_OUTPUT, pokemonModel.toString());
      return;
    } catch (SQLException e) {
      System.out.println("SQL Exception");
      System.out.println(e.getMessage());
      e.printStackTrace();
    } finally {
      try {
        if(connection != null) {
          connection.close();
        }
        if(st != null) {
          st.close();
        }
        if(rs != null) {
          rs.close();
        }
      } catch (SQLException e) {
        System.out.println("SQL Exception");
        System.out.println(e.getMessage());
        e.printStackTrace();
      }
    }
    Assertions.fail();
  }
}
