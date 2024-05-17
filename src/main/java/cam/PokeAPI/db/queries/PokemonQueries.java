package cam.PokeAPI.db.queries;

import org.intellij.lang.annotations.Language;

public class PokemonQueries {
	public static String getMoveEffectivenessSQL() {
    @Language("PSQL")
    String sql = """
			SELECT
					DISTINCT m.name AS move_name,
					me.dmg_source,
					defender.name AS defender_name,
					defender.sub_name AS defender_sub_name,
					STRING_AGG(DISTINCT defender_element.element_name::text, ',') AS defender_elements,
					CASE
						WHEN me.effectiveness = 0 THEN 'no effectiveness'
						WHEN me.effectiveness = 0.5 THEN 'not very effective'
						WHEN me.effectiveness = 1 THEN 'normal'
						WHEN me.effectiveness = 2 THEN 'super-effective'
					END AS friendly_effectiveness,
					STRING_AGG(DISTINCT me.effectiveness::text, ',') AS effectiveness
				FROM pokemon_move AS pm
				INNER JOIN pokemon AS defender
					ON defender.name = ?
					AND defender.sub_name = ''
				INNER JOIN move AS m
					ON m.name = pm.move_name
				INNER JOIN move_effectiveness AS me
					ON me.dmg_dest IN (
						SELECT element_name
						FROM pokemon_element
						WHERE pokemon_name = ?
					)
					AND me.dmg_source = m.element_name
				INNER JOIN pokemon_element AS defender_element
					ON defender_element.pokemon_number = defender.number
					AND defender_element.pokemon_name = defender.name
					AND defender_element.pokemon_sub_name = defender.sub_name
				WHERE pm.pokemon_name = ?
				GROUP BY
					pm.move_name,
					me.dmg_dest,
					defender.name,
					defender.sub_name,
					m.name,
					me.dmg_source
				ORDER BY effectiveness DESC;
			""";

		return sql;
  }

	public static String getMoveData() {
		@Language("PSQL")
		String sql = "SELECT * FROM move WHERE name=?";
		return sql;
	}

	public static String getEffectiveness() {
		@Language("PSQL")
		String sql = "SELECT * FROM move_effectiveness WHERE dmg_source = ?";
		return sql;
	}
}
