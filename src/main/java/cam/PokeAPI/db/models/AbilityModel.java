package cam.PokeAPI.db.models;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

import static cam.PokeAPI.util.Util.instantiateGenerically;

public class AbilityModel {
  String name;
  String description;
  Integer generation;

  public AbilityModel(ResultSet rs) throws SQLException, IllegalAccessException {
    instantiateGenerically(this, rs);
  }

  public AbilityModel(String name, String description, Integer generation) {
    this.name = name;
    this.description = description;
    this.generation = generation;
  }

  @Override
  public String toString() {
    return this.name + " " + this.description + " " + this.generation;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getGeneration() {
    return generation;
  }

  public void setGeneration(Integer generation) {
    this.generation = generation;
  }
}
