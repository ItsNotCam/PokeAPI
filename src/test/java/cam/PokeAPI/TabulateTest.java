package cam.PokeAPI;

import cam.PokeAPI.util.Tabulate;
import org.junit.jupiter.api.Test;

public class TabulateTest {
  @Test
  void TestValidData() {
    String[] headers = {"number", "name", "sub name", "details", "delete me"};
    String[][] data = {
      { "1", "bulbasaur", "super bulbasaur", "this is a new set of details", "ok delete me" },
      { "2", "charizard", "hella charizard", "this is dumb ok lol", "why did they only give" },
      { "3", "infernape", "dope", "fake GPT 4 thing", "me a couple of queries lol" },
      { "4", "piplup", "nothing really", "what a huge scam", "lmaoooo" },
      { "5", "", "", "", ""},
      { "6", "hhahahahahah", "nakj;sfidhsk", "", ""}
    };

    String output = Tabulate.tabulate(headers, data);
    System.out.println(output);
  }
}
