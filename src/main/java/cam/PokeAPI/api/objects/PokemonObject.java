package cam.PokeAPI.api.objects;

import cam.PokeAPI.db.models.PokemonModel;

public class PokemonObject {
  String[] elements;
  String[] moves;
  String[] abilities;
  PokemonEVObject[] evs;
  PokemonElementEffectivenessObject[] effectiveness_defending;
  PokemonElementEffectivenessObject[] effectiveness_attacking;
  PokemonModel pokemon;

  public PokemonObject(String[] elements, String[] moves, String[] abilities, PokemonEVObject[] evs,
                       PokemonElementEffectivenessObject[] effects_from,
                       PokemonElementEffectivenessObject[] effects_against,
                       PokemonModel model) {
    this.elements = elements;
    this.pokemon = model;
    this.moves = moves;
    this.abilities = abilities;
    this.evs = evs;
    this.effectiveness_defending = effects_from;
    this.effectiveness_attacking = effects_against;
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

  public PokemonElementEffectivenessObject[] getEffectiveness_defending() {
    return effectiveness_defending;
  }

  public void setEffectiveness_defending(PokemonElementEffectivenessObject[] effectiveness) {
    this.effectiveness_defending = effectiveness;
  }

  public PokemonElementEffectivenessObject[] getEffectiveness_attacking() {
    return effectiveness_attacking;
  }

  public void setEffectiveness_attacking(PokemonElementEffectivenessObject[] effectiveness) {
    this.effectiveness_attacking = effectiveness;
  }
}
