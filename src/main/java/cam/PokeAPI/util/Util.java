package cam.PokeAPI.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {
  public static void instantiateModelGenerically(Object obj, ResultSet rs) throws SQLException {
    while(rs.next()) {
      Field[] fields = obj.getClass().getDeclaredFields();
      for(int i = 0; i < fields.length; i++) {
        Field field = fields[i];
        field.setAccessible(true);

        Class<?> fieldClass = field.getType();
        try {
          if (fieldClass.equals(String.class)) {
            field.set(obj, rs.getString(i + 1));
          } else if (fieldClass.equals(Integer.class)) {
            field.set(obj, rs.getInt(i + 1));
          } else if(fieldClass.equals(Float.class)) {
            field.set(obj, rs.getFloat(i + 1));
          }
        } catch (IllegalAccessException e) {
          System.out.println("Cannot access field " + field.getName());
        }
      }
    }
  }
}
