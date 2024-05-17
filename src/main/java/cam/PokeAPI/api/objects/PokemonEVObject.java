package cam.PokeAPI.api.objects;

import java.sql.ResultSet;
import java.sql.SQLException;

import static cam.PokeAPI.util.Util.instantiateModelGenerically;

public class PokemonEVObject {
  String ev_name;
  Integer ev_amount;

  public PokemonEVObject(String ev_name, Integer ev_amount) {
    this.ev_name = ev_name;
    this.ev_amount = ev_amount;
  }

  public PokemonEVObject(ResultSet rs) throws SQLException {
    instantiateModelGenerically(this, rs);
  }

  public String getEv_name() {
    return ev_name;
  }

  public void setEv_name(String ev_name) {
    this.ev_name = ev_name;
  }

  public Integer getEv_amount() {
    return ev_amount;
  }

  public void setEv_amount(Integer ev_amount) {
    this.ev_amount = ev_amount;
  }
}
