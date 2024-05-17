package cam.PokeAPI;

import cam.PokeAPI.db.models.AbilityModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.mockito.internal.creation.SuspendMethod;
import org.springframework.util.Assert;

import java.sql.*;

public class AbilityModelTest {
  @Test
  public void AbilityTest() throws SQLException {
    final String DB_URL = "jdbc:postgresql://localhost:5432/pokemon?user=cam&password=ok";
    final String expectedOutput = "Adaptability Powers up moves of the same type. 4";

    Connection connection = null;
    Statement st = null;
    ResultSet rs = null;
    try {
      connection = DriverManager.getConnection(DB_URL);

      st = connection.createStatement();
      rs = st.executeQuery("SELECT * FROM ability WHERE name='Adaptability'");
      AbilityModel am = new AbilityModel(rs);

      Assertions.assertEquals(expectedOutput, am.toString());

      return;
    } catch (SQLException | IllegalAccessException e) {
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
