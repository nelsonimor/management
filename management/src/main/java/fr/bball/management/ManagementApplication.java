package fr.bball.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ManagementApplication {

		
	public static void main(String[] args) {
		System.out.println("-> LeagueApplication.main()");
		SpringApplication.run(ManagementApplication.class, args);
	}

}
