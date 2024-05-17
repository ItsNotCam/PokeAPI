package cam.PokeAPI.db.models;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.sql.ResultSet;
import java.sql.SQLException;

import static cam.PokeAPI.util.Util.instantiateModelGenerically;

@JsonRootName(value = "move_haha")
public class MoveModel implements Model {
  String name;
  String element_name;
  String dmg_category;
  Integer power;
  Integer accuracy;
  Integer pp;
  String description;
  Integer probability;

  public MoveModel(String name, String element_name, String dmg_category, Integer power, Integer accuracy,
                   Integer pp, String description, Integer probability)
  {
    this.name = name;
    this.element_name = element_name;
    this.dmg_category = dmg_category;
    this.power = power;
    this.accuracy = accuracy;
    this.pp = pp;
    this.description = description;
    this.probability = probability;
  }

  public MoveModel(ResultSet rs) throws SQLException {
    instantiateModelGenerically(this, rs);
  }

  @Override
  public String toString() {
    return name + " " + element_name + " " + dmg_category + " " + power + " " + accuracy
      + " " + pp + " " + description + " " + probability;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getElement_name() {
    return element_name;
  }

  public void setElement_name(String element_name) {
    this.element_name = element_name;
  }

  public String getDmg_category() {
    return dmg_category;
  }

  public void setDmg_category(String dmg_category) {
    this.dmg_category = dmg_category;
  }

  public Integer getPower() {
    return power;
  }

  public void setPower(Integer power) {
    this.power = power;
  }

  public Integer getAccuracy() {
    return accuracy;
  }

  public void setAccuracy(Integer accuracy) {
    this.accuracy = accuracy;
  }

  public Integer getPp() {
    return pp;
  }

  public void setPp(Integer pp) {
    this.pp = pp;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getProbability() {
    return probability;
  }

  public void setProbability(Integer probability) {
    this.probability = probability;
  }
}
