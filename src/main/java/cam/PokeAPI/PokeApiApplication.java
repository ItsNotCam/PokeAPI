package cam.PokeAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.Arrays;

@RestController
@EnableAutoConfiguration
public class PokeApiApplication {
	static final String DB_URL = String.format(
			"jdbc:postgresql://%s:%d/%s?user=%s&password=%s",
			System.getenv("DB_HOST"),
			Integer.parseInt(System.getenv("DB_PORT")),
			System.getenv("DB_NAME"),
			System.getenv("DB_USER"),
			System.getenv("DB_PASS")
	);
	static Connection connection;

	static {
		try {
			connection = DriverManager.getConnection(DB_URL);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@RequestMapping("/")
	@ResponseBody
	String home() {
		StringBuilder msg = new StringBuilder();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("""
					SELECT
							m.name AS move_name,
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
							ON defender.name = 'Charizard'
						INNER JOIN move AS m
							ON m.name = pm.move_name
						INNER JOIN move_effectiveness AS me
							ON me.dmg_dest IN (
								SELECT element_name
								FROM pokemon_element
								WHERE pokemon_name = 'Charizard'
							)
							AND me.dmg_source = m.element_name
						INNER JOIN pokemon_element AS defender_element
							ON defender_element.pokemon_number = defender.number
							AND defender_element.pokemon_name = defender.name
							AND defender_element.pokemon_sub_name = defender.sub_name
						WHERE pm.pokemon_name = 'Bulbasaur'
						GROUP BY
							pm.move_name,
							me.dmg_dest,
							defender.name,
							defender.sub_name,
							m.name,
							me.dmg_source
						ORDER BY effectiveness DESC;
			""");

			int rowNumber = 1;
			while(rs.next()) {
				System.out.println("\nFetch Size? " + rs.getFetchSize() + "\n");
				final String name = rs.getString(1);
				final String dmg_source = rs.getString(2);
				final String defender_name = rs.getString(3);
				final String defender_sub_name = rs.getString(4);
				final String defender_elements = rs.getString(5);
				final String friendly_effectiveness = rs.getString(6);
				final String effectiveness = rs.getString(7);

				msg.append(String.format(
						"""
						Row #:       %d
						Name:        %s
						dmg_src:     %s
						defender_name: %s
						defender_sub_name: %s
						defender_elements: %s
						effectiveness: %s
						\n""", rowNumber, name, dmg_source, defender_name, defender_sub_name, defender_elements,
						friendly_effectiveness
				));

				rowNumber++;
			}
		}	catch (SQLException e) {
			System.out.println(e.getMessage());
			for (StackTraceElement s : e.getStackTrace()) {
				System.out.println(s.toString());
			}

			msg.append(String.format(
				"SQL Exception: %s", e.getMessage()
			));
		}

		return msg.toString();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PokeApiApplication.class, args);
	}
}
