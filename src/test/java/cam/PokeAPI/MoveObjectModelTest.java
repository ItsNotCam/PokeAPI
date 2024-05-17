package cam.PokeAPI;

import cam.PokeAPI.db.models.AbilityModel;
import cam.PokeAPI.db.models.MoveModel;
import cam.PokeAPI.db.models.PokemonModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class MoveObjectModelTest {
  @Test
  public void MoveTest() {
    final String DB_URL = "jdbc:postgresql://localhost:5432/pokemon?user=cam&password=ok";
    final String EXPECTED_OUTPUT = "Aerial Ace Flying Physical 60 0 20 Ignores Accuracy and Evasiveness. 0";

    Connection connection = null;
    Statement st = null;
    ResultSet rs = null;
    try {
      connection = DriverManager.getConnection(DB_URL);
      st = connection.createStatement();
      rs = st.executeQuery("SELECT * FROM move WHERE name='Aerial Ace'");
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
