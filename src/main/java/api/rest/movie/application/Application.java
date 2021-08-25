package api.rest.movie.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import api.rest.movie.entity.Movie;
import api.rest.movie.repository.MovieRepository;

@EntityScan(basePackages = "api.rest.movie.entity")
@EnableJpaRepositories(basePackages = "api.rest.movie.repository")
@ComponentScan(basePackages = "pi.rest.movie.controller")
@SpringBootApplication

public class Application extends SpringBootServletInitializer
implements CommandLineRunner {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
	MovieRepository dao;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			Movie v1 = new Movie(null,"Space Jam","Warner","06/2021", "comÃ©dia/infantil", "jogo do sÃ©culo",
					"https://www.eastonparkatx.com/wp-content/uploads/2019/05/space-jam-cover-nss.jpg", "livre");
			dao.save(v1);
			System.out.println("OK ...");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error :" + ex.getMessage());

		}
	}
	}