package cam.PokeAPI.api.controllers;

import cam.PokeAPI.api.objects.PokemonObject;
import cam.PokeAPI.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cam.PokeAPI.db.models.Model;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
  PokemonService pokemonService;

  @Autowired
  public PokemonController(PokemonService pokemonService) {
    this.pokemonService = pokemonService;
  }

  @GetMapping("/{name}")
  public PokemonObject getPokemon(@PathVariable String name) {
    return pokemonService.getPokemon(name);
  }
}
