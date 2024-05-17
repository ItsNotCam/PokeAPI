package cam.PokeAPI.db.models;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.sql.ResultSet;
import java.sql.SQLException;

import static cam.PokeAPI.util.Util.instantiateModelGenerically;

@JsonRootName(value = "pokemon_ability")
public class PokemonAbilityModel implements Model {
  String ability_name;
  Integer pokemon_number;
  String pokemon_name;
  String pokemon_sub_name;

  public PokemonAbilityModel(ResultSet rs) throws SQLException {
    instantiateModelGenerically(this, rs);
  }

  public String getAbilityName() {
    return ability_name;
  }

  public void setAbilityName(String ability_name) {
    this.ability_name = ability_name;
  }

  public Integer getPokemonNumber() {
    return pokemon_number;
  }

  public void setPokemonNumber(Integer pokemon_number) {
    this.pokemon_number = pokemon_number;
  }

  public String getPokemonName() {
    return pokemon_name;
  }

  public void setPokemonName(String pokemon_name) {
    this.pokemon_name = pokemon_name;
  }

  public String getPokemonSubName() {
    return pokemon_sub_name;
  }

  public void setPokemonSubName(String pokemon_sub_name) {
    this.pokemon_sub_name = pokemon_sub_name;
  }
}
