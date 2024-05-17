package cam.PokeAPI.api.objects;

import cam.PokeAPI.db.models.PokemonEVModel;
import cam.PokeAPI.db.models.PokemonModel;

public class PokemonObject {
  String[] elements;
  String[] moves;
  String[] abilities;
  PokemonEVObject[] evs;
  PokemonModel pokemon;

  public PokemonObject(String[] elements, String[] moves, String[] abilities, PokemonEVObject[] evs, PokemonModel model) {
    this.elements = elements;
    this.pokemon = model;
    this.moves = moves;
    this.abilities = abilities;
    this.evs = evs;
  }

  public String[] getElements() {
    return elements;
  }

  public void setElements(String[] elements) {
    this.elements = elements;
  }

  public PokemonModel getPokemon() {
    return pokemon;
  }

  public void setPokemon(PokemonModel pokemon) {
    this.pokemon = pokemon;
  }

  public String[] getMoves() {
    return moves;
  }

  public void setMoves(String[] moves) {
    this.moves = moves;
  }

  public String[] getAbilities() {
    return abilities;
  }

  public void setAbilities(String[] abilities) {
    this.abilities = abilities;
  }

  public PokemonEVObject[] getEvs() {
    return evs;
  }

  public void setEvs(PokemonEVObject[] evs) {
    this.evs = evs;
  }
}
