package cam.PokeAPI.util;

import cam.PokeAPI.db.models.AbilityModel;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {
  public static void instantiateGenerically(Object obj, ResultSet rs) throws SQLException, IllegalAccessException {
    while(rs.next()) {
      Field[] fields = obj.getClass().getDeclaredFields();
      for(int i = 0; i < fields.length; i++) {
        Field field = fields[i];
        field.setAccessible(true);

        Class<?> fieldClass = field.getType();
        if (fieldClass.equals(String.class)) {
          field.set(obj, rs.getString(i + 1));
        } else if (fieldClass.equals(Integer.class)) {
          field.set(obj, rs.getInt(i + 1));
        }
      }
    }
  }
}
