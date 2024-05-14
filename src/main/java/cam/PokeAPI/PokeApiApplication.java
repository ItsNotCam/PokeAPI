package cam.PokeAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class PokeApiApplication {
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PokeApiApplication.class, args);
	}
}
