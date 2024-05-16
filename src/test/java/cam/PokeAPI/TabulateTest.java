package cam.PokeAPI;

import cam.PokeAPI.util.Tabulate;
import org.junit.jupiter.api.Test;

public class TabulateTest {
  @Test
  void TestValidData() {
    String[] headers = {"number", "name", "sub name"};
    String[][] data = {
      { "1", "bulbasaur", "super bulbasaur" },
      { "2", "charizard", "hella charizard" },
      { "3", "infernape", "dope" },
      { "4", "piplup", "nothing really" },
      { "5", "", ""},
      { "6", "hhahahahahah", "nakj;sfidhsk"}
    };

    String output = Tabulate.tabulate(headers, data);
    System.out.println(output);
  }
}
