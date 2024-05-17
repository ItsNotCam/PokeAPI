package cam.PokeAPI.api.objects;

import cam.PokeAPI.db.models.MoveModel;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.sql.ResultSet;
import java.sql.SQLException;

@JsonRootName(value = "move")
public class Move {
  MoveModel move;
  Effectiveness effectiveness;

  public Move(MoveModel move, ResultSet effectivenessRS) throws SQLException {
    this.move = move;
    this.effectiveness = new Effectiveness(effectivenessRS);
  }

  public MoveModel getMove() {
    return move;
  }

  public void setMove(MoveModel move) {
    this.move = move;
  }

  public Effectiveness getEffectiveness() {
    return effectiveness;
  }

  public void setEffectiveness(Effectiveness effectiveness) {
    this.effectiveness = effectiveness;
  }
}
