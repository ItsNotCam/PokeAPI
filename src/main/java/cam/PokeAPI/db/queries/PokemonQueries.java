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
						WHEN me.effectivenessObject = 0 THEN 'no effectivenessObject'
						WHEN me.effectivenessObject = 0.5 THEN 'not very effective'
						WHEN me.effectivenessObject = 1 THEN 'normal'
						WHEN me.effectivenessObject = 2 THEN 'super-effective'
					END AS friendly_effectiveness,
					STRING_AGG(DISTINCT me.effectivenessObject::text, ',') AS effectivenessObject
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
				ORDER BY effectivenessObject DESC;
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

	public static String getPokemon(boolean includeElements) {
		@Language("PSQL") String sql;
		if(includeElements) {
			sql = """
				SELECT
					p.*,
					STRING_AGG(DISTINCT pe.element_name::text, ',') AS elements,
					STRING_AGG(DISTINCT pm.move_name::text, ',') AS moves,
					STRING_AGG(DISTINCT pa.ability_name::text, ',') AS abilities,
					STRING_AGG(DISTINCT pev.ev_name::text, ',') AS evs
				
				FROM pokemon AS p
				
				INNER JOIN pokemon_element AS pe
					ON pe.pokemon_number = p.number
					AND pe.pokemon_name = p.name
					AND pe.pokemon_sub_name = ''
							
				INNER JOIN pokemon_move AS pm
					ON pm.pokemon_number = p.number
					AND pm.pokemon_name = p.name
					AND pm.pokemon_sub_name = ''
				
				INNER JOIN pokemon_ability AS pa
					ON pa.pokemon_number = p.number
					AND pa.pokemon_name = p.name
					AND pa.pokemon_sub_name = ''
				
				LEFT JOIN pokemon_ev AS pev
					ON pev.pokemon_number = p.number
					AND pev.pokemon_name = p.name
					AND pev.pokemon_sub_name = ''
				
				WHERE p.name = ?
					AND p.sub_name = ''
				
				GROUP BY p.number, p.name, p.sub_name;
			""";

		} else {
			sql = "SELECT * FROM pokemon WHERE name=?";
		}
		return sql;
	}
}
