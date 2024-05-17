package cam.PokeAPI.services;

import cam.PokeAPI.api.objects.PokemonObject;
import cam.PokeAPI.db.PokemonDB;
import cam.PokeAPI.db.models.MessageModel;
import cam.PokeAPI.db.models.PokemonModel;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class PokemonService {
  PokemonObject pokemonModel;

  public PokemonService() {  }

  public PokemonObject getPokemon(String name) {
    try {
      PokemonObject pokemonModel = PokemonDB.getPokemonObject(name);
      return pokemonModel;
    } catch(SQLException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return null;
  }
}
