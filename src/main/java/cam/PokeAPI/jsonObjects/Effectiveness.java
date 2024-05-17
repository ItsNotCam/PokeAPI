package cam.PokeAPI.jsonObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Effectiveness {
  List<String> super_effectiveness;
  List<String> normal_effectiveness;
  List<String> minimal_effectiveness;
  List<String> no_effectiveness;

  public Effectiveness(ResultSet rs) throws SQLException {
    this.super_effectiveness = new ArrayList<>();
    this.normal_effectiveness = new ArrayList<>();
    this.minimal_effectiveness = new ArrayList<>();
    this.no_effectiveness = new ArrayList<>();
    while(rs.next()) {
      float effectiveness = rs.getFloat(3);
      String damageDestination = rs.getString(2);
      if(effectiveness == 0f) {
        no_effectiveness.add(damageDestination);
      } else if(effectiveness == 0.5f) {
        minimal_effectiveness.add(damageDestination);
      } else if(effectiveness == 1f) {
        normal_effectiveness.add(damageDestination);
      } else if(effectiveness == 2f) {
        super_effectiveness.add(damageDestination);
      }
    }
  }

  public List<String> getSuper_effectiveness() {
    return super_effectiveness;
  }

  public void setSuper_effectiveness(List<String> super_effectiveness) {
    this.super_effectiveness = super_effectiveness;
  }

  public List<String> getNormal_effectiveness() {
    return normal_effectiveness;
  }

  public void setNormal_effectiveness(List<String> normal_effectiveness) {
    this.normal_effectiveness = normal_effectiveness;
  }

  public List<String> getMinimal_effectiveness() {
    return minimal_effectiveness;
  }

  public void setMinimal_effectiveness(List<String> minimal_effectiveness) {
    this.minimal_effectiveness = minimal_effectiveness;
  }

  public List<String> getNo_effectiveness() {
    return no_effectiveness;
  }

  public void setNo_effectiveness(List<String> no_effectiveness) {
    this.no_effectiveness = no_effectiveness;
  }
}
