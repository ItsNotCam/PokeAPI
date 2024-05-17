package cam.PokeAPI.db.models;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.sql.ResultSet;
import java.sql.SQLException;

import static cam.PokeAPI.util.Util.instantiateModelGenerically;

@JsonRootName(value = "element")
public class ElementModel {
  String name;

  public ElementModel(ResultSet rs) throws SQLException {
    instantiateModelGenerically(this, rs);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
