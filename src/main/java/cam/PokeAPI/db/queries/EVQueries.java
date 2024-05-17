package cam.PokeAPI.db.queries;

import org.intellij.lang.annotations.Language;

public class EVQueries {
  public static String getEV() {
    @Language("PSQL")
    String sql = """
      SELECT * FROM pokemon_ev
      WHERE pokemon_number=?
        AND pokemon_name=?
        AND pokemon_sub_name=?
        AND ev_name=?
    """;
    return sql;
  }
}
