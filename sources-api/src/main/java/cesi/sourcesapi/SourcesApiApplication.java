package cesi.sourcesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SourcesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SourcesApiApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/public/**").allowedOrigins("http://localhost:8080");
				registry.addMapping("/**").allowedOrigins("http://localhost:8080");
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE");
				
			}
		};
	}

}
