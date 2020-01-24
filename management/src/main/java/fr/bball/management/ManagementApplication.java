package fr.bball.management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.bball.management.controller.LeagueController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ManagementApplication {
	
	static Logger logger = LoggerFactory.getLogger(ManagementApplication.class);

		
	public static void main(String[] args) {
		logger.debug("Launch ManagementApplication");
		SpringApplication.run(ManagementApplication.class, args);
	}

}
