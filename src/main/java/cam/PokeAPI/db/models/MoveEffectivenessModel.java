package cam.PokeAPI.db.models;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.sql.ResultSet;
import java.sql.SQLException;

import static cam.PokeAPI.util.Util.instantiateModelGenerically;

@JsonRootName(value = "move_effectiveness")
public class MoveEffectivenessModel {
  String dmg_source;
  String dmg_dest;
  Integer effectiveness;

  public MoveEffectivenessModel(ResultSet rs) throws SQLException {
    instantiateModelGenerically(this, rs);
  }

  public String getDmg_source() {
    return dmg_source;
  }

  public void setDmg_source(String dmg_source) {
    this.dmg_source = dmg_source;
  }

  public String getDmg_dest() {
    return dmg_dest;
  }

  public void setDmg_dest(String dmg_dest) {
    this.dmg_dest = dmg_dest;
  }

  public Integer getEffectiveness() {
    return effectiveness;
  }

  public void setEffectiveness(Integer effectiveness) {
    this.effectiveness = effectiveness;
  }
}
