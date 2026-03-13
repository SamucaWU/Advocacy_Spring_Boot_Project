package github.io.advocacy;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);

		SpringApplicationBuilder builder =
				new SpringApplicationBuilder(Application.class);

		builder.bannerMode(Banner.Mode.OFF); // Remove Spring Boot Banner
		builder.run(args);

	}


}
