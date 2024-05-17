package cam.PokeAPI.api.objects;

import cam.PokeAPI.db.models.MoveModel;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.sql.ResultSet;
import java.sql.SQLException;

@JsonRootName(value = "move")
public class MoveObject {
  MoveModel move;
  EffectivenessObject effectivenessObject;

  public MoveObject(MoveModel move, ResultSet effectivenessRS) throws SQLException {
    this.move = move;
    this.effectivenessObject = new EffectivenessObject(effectivenessRS);
  }

  public MoveModel getMove() {
    return move;
  }

  public void setMove(MoveModel move) {
    this.move = move;
  }

  public EffectivenessObject getEffectiveness() {
    return effectivenessObject;
  }

  public void setEffectiveness(EffectivenessObject effectivenessObject) {
    this.effectivenessObject = effectivenessObject;
  }
}
