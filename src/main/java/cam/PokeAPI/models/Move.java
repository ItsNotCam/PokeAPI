package cam.PokeAPI.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Move {
  String name;
  String element_name;
  String dmg_category;
  Integer power;
  Integer accuracy;
  Integer pp;
  String description;
  Integer probability;

  public Move(String name, String element_name, String dmg_category, Integer power, Integer accuracy,
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

  public Move(ResultSet rs) throws SQLException  {
    while(rs.next()) {
      this.name = rs.getString(1);
      this.element_name = rs.getString(2);
      this.dmg_category = rs.getString(3);
      this.power = rs.getInt(4);
      this.accuracy = rs.getInt(5);
      this.pp = rs.getInt(6);
      this.description = rs.getString(7);
      this.probability = rs.getInt(8);
    }
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
