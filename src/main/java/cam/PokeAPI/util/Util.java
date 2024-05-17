package cam.PokeAPI.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {
  // uses reflection to instantiate the class procedurally
  // the result set returns several columns in the same order that they are in the table schema
  // therefore I iterate over every field in the inputted object and get its cooresponding
  // value in the resultset
  public static void instantiateModelGenerically(Object obj, ResultSet rs) throws SQLException {
    while(rs.next()) {
      Field[] fields = obj.getClass().getDeclaredFields();
      for(int i = 0; i < fields.length; i++) {
        Field field = fields[i];
        field.setAccessible(true);

        Class<?> fieldClass = field.getType();
        try {
          if (fieldClass.equals(String.class)) {
            String val = rs.wasNull() ? "" : rs.getString(field.getName());
            field.set(obj, val);
          } else if (fieldClass.equals(Integer.class)) {
            Integer val = rs.wasNull() ? -1 : rs.getInt(field.getName());
            field.set(obj, val);
          } else if(fieldClass.equals(Float.class)) {
            Float val = rs.wasNull() ? -1f : rs.getFloat(field.getName());
            field.set(obj, val);
          }
        } catch (IllegalAccessException e) {
          System.out.println("Cannot access field " + field.getName());
        }
      }
      return;
    }
  }
}
