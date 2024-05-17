package cam.PokeAPI.db.models;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.sql.ResultSet;
import java.sql.SQLException;

import static cam.PokeAPI.util.Util.instantiateModelGenerically;

@JsonRootName(value = "pokemon_move")
public class PokemonMoveModel {
  Integer id;
  String source;
  Integer pokemon_number;
  String move_name;
  String pokemon_name;
  String pokemon_sub_name;
  Integer level;

  public PokemonMoveModel(ResultSet rs) throws SQLException {
    instantiateModelGenerically(this, rs);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public Integer getPokemonNumber() {
    return pokemon_number;
  }

  public void setPokemonNumber(Integer pokemon_number) {
    this.pokemon_number = pokemon_number;
  }

  public String getMoveName() {
    return move_name;
  }

  public void setMoveName(String move_name) {
    this.move_name = move_name;
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

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }
}
