package com.dispatcher.tn;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.dispatcher.controller.HashTagController;
import com.dispatcher.entities.HashTag;
import com.dispatcher.repository.HashTagReposotory;

@SpringBootApplication
@EntityScan(basePackageClasses = HashTag.class)
@ComponentScan(basePackageClasses = { HashTagController.class })
@EnableMongoRepositories(basePackageClasses = { HashTagReposotory.class })
public class DispatcherProjectApplication implements CommandLineRunner {
	@Autowired
	private HashTagReposotory repo ;
	
	public static void main(String[] args) {
		SpringApplication.run(DispatcherProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
	
		repo.deleteAll();
		
		
		
	}

}
