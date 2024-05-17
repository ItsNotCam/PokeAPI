package cam.PokeAPI.api.objects;

public class MoveEffectiveness {
  String name;
  String damage_source;
  String defender;
  String[] defender_elements;
  String effectiveness;

  public MoveEffectiveness(String[] data) {
    this.name = data[0];
    this.damage_source = data[1];
    this.defender = data[2];
    this.defender_elements = data[3].split(",");
    this.effectiveness = data[4];
  }

  public MoveEffectiveness(String name, String damage_source, String defender, String defender_elements, String effectiveness) {
    this.name = name;
    this.damage_source = damage_source;
    this.defender = defender;
    this.defender_elements = defender_elements.split(",");
    this.effectiveness = effectiveness;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDamage_source() {
    return damage_source;
  }

  public void setDamage_source(String damage_source) {
    this.damage_source = damage_source;
  }

  public String getDefender() {
    return defender;
  }

  public void setDefender(String defender) {
    this.defender = defender;
  }

  public String[] getDefender_elements() {
    return defender_elements;
  }

  public void setDefender_elements(String[] defender_elements) {
    this.defender_elements = defender_elements;
  }

  public String getEffectiveness() {
    return effectiveness;
  }

  public void setEffectiveness(String effectiveness) {
    this.effectiveness = effectiveness;
  }

}
