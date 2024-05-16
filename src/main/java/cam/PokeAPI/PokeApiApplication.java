package cam.PokeAPI;

import cam.PokeAPI.jsonObjects.MoveEffectiveness;
import cam.PokeAPI.util.Tabulate;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class PokeApiApplication {
	static Connection connection;

	static {
		try {
			final String DB_URL = String.format(
				"jdbc:postgresql://%s:%s/%s?user=%s&password=%s",
				env("DB_HOST"),
				env("DB_PORT"),
				env("DB_NAME"),
				env("DB_USER"),
				env("DB_PASS")
			);
			connection = DriverManager.getConnection(DB_URL);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private static String env(String txt) {
		return System.getenv(txt);
	}

	@RequestMapping("/pokemon")
	@ResponseBody
	String getPokemon(
			@RequestParam() String ok,
			@RequestParam() String whoasked
	) {
		return ok.concat(whoasked);
	}

	@RequestMapping(value="/effectiveness", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MoveEffectiveness> home(
		@RequestParam String attacker,
		@RequestParam String defender
	) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
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

			st = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			{
				st.setString(1, defender);
				st.setString(2, defender);
				st.setString(3, attacker);
			}

			rs = st.executeQuery();

			String[] headers = { "name", "damage source", "defender", "defender elements", "effectiveness"};
			ArrayList<MoveEffectiveness> moves = new ArrayList<>();
			String[][] data = new String[getLength(rs)][headers.length];
			int rowIdx = 0;
			while(rs.next()) {
				final String name = rs.getString(1);
				final String dmg_source = rs.getString(2);
				final String defender_name = String.format(
					"%s %s", rs.getString(3), rs.getString(4)
				);
				final String defender_elements = rs.getString(5);
				final String friendly_effectiveness = rs.getString(6);

				data[rowIdx] = new String[] {
					name, dmg_source, defender_name.trim(), defender_elements, friendly_effectiveness
				};
				rowIdx++;

				moves.add(new MoveEffectiveness(
					name, dmg_source, defender, defender_elements, friendly_effectiveness
				));
			}

			System.out.println(Tabulate.tabulate(headers, data));
			return moves;
		}	catch (SQLException e) {
			System.out.println(e.getMessage());
			for (StackTraceElement s : e.getStackTrace()) {
				System.out.println(s.toString());
			}
		} finally {
			try {
				if(st != null) st.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

		return new ArrayList<>();
	}

	static int getLength(ResultSet rs) throws SQLException {
		int rowCount = 0;
		if(rs != null) {
			rs.last();
			rowCount = rs.getRow();
			rs.beforeFirst();
		}
		return rowCount;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PokeApiApplication.class, args);
	}
}
