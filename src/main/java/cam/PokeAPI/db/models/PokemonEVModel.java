package cam.PokeAPI.db.models;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.sql.ResultSet;
import java.sql.SQLException;

import static cam.PokeAPI.util.Util.instantiateModelGenerically;

@JsonRootName(value = "pokemon_ev")
public class PokemonEVModel implements Model {
  String ev_name;
  Integer ev_amount;
  Integer pokemon_number;
  String pokemon_name;
  String pokemon_sub_name;

  public PokemonEVModel(ResultSet rs) throws SQLException {
    instantiateModelGenerically(this, rs);
  }

  public String getEv_name() {
    return ev_name;
  }

  public void setEvName(String evName) {
    this.ev_name = evName;
  }

  public Integer getEv_amount() {
    return ev_amount;
  }

  public void setEvAmount(Integer evAmount) {
    this.ev_amount = evAmount;
  }

  public Integer getPokemon_number() {
    return pokemon_number;
  }

  public void setPokemonNumber(Integer pokemon_number) {
    this.pokemon_number = pokemon_number;
  }

  public String getPokemon_name() {
    return pokemon_name;
  }

  public void setPokemon_name(String pokemon_name) {
    this.pokemon_name = pokemon_name;
  }

  public String getPokemon_sub_name() {
    return pokemon_sub_name;
  }

  public void setPokemon_sub_name(String pokemon_sub_name) {
    this.pokemon_sub_name = pokemon_sub_name;
  }
}
