package cam.PokeAPI;

import cam.PokeAPI.api.objects.Move;
import cam.PokeAPI.api.objects.MoveEffectiveness;
import cam.PokeAPI.db.models.MoveModel;
import cam.PokeAPI.util.Tabulate;
import cam.PokeAPI.db.queries.PokemonQueries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PokeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeApiApplication.class, args);
	}

	/*
	static Connection connection;

	static {
		try {
			final String DB_URL = String.format(
				"jdbc:postgresql://%s:%s/%s?user=%s&password=%s",
				env("DB_HOST"), env("DB_PORT"),
				env("DB_NAME"), env("DB_USER"),
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

	@RequestMapping(value="/move", produces = MediaType.APPLICATION_JSON_VALUE)
	public Move move(@RequestParam String move_name) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String moveDataSQL = PokemonQueries.getMoveData();
			st = connection.prepareStatement(moveDataSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			st.setString(1, move_name);
			rs = st.executeQuery();
			MoveModel model = new MoveModel(rs);

			st.close();
			rs.close();

			String effectivenessSQL = PokemonQueries.getEffectiveness();
			st = connection.prepareStatement(effectivenessSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			st.setString(1, model.getElement_name());
			rs = st.executeQuery();

			return new Move(model, rs);
		} catch(SQLException e) {
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

		return null;
	}

	@RequestMapping(value="/effectiveness", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MoveEffectiveness> effectiveness(
		@RequestParam String attacker,
		@RequestParam String defender
	) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = PokemonQueries.getMoveEffectivenessSQL();
			st = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			{
				st.setString(1, defender);
				st.setString(2, defender);
				st.setString(3, attacker);
			}

			rs = st.executeQuery();
			int resultsLength = getLength(rs);

			String[] headers = { "name", "damage source", "defender", "defender elements", "effectiveness"};
			ArrayList<MoveEffectiveness> moves = new ArrayList<>();
			String[][] data = new String[resultsLength][headers.length];
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
	}*/
}
