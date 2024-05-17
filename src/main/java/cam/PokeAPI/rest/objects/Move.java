package cam.PokeAPI.rest.objects;

import cam.PokeAPI.db.models.MoveModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Move {
  MoveModel move;
  Effectiveness effectiveness;

  public Move(MoveModel move, ResultSet effectivenessRS) throws SQLException {
    this.move = move;
  }

  public MoveModel getMoveModel() {
    return move;
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
