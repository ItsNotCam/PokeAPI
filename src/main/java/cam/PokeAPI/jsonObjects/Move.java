package cam.PokeAPI.jsonObjects;

import cam.PokeAPI.models.PokemonModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Move {
  cam.PokeAPI.models.Move move;
  Effectiveness effectiveness;

  public Move(cam.PokeAPI.models.Move move, ResultSet effectivenessRS) throws SQLException {
    this.move = move;
  }

  public cam.PokeAPI.models.Move getMoveModel() {
    return move;
  }

  public cam.PokeAPI.models.Move getMove() {
    return move;
  }

  public void setMove(cam.PokeAPI.models.Move move) {
    this.move = move;
  }

  public Effectiveness getEffectiveness() {
    return effectiveness;
  }

  public void setEffectiveness(Effectiveness effectiveness) {
    this.effectiveness = effectiveness;
  }
}
