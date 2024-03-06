package com.example.Test_REST_API;

import com.example.Test_REST_API.model.GroceryItem;
import com.example.Test_REST_API.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TestRestApiApplication implements CommandLineRunner {
	@Autowired
	private ItemRepository groceryItemRepo;
	public static void main(String[] args) {
		SpringApplication.run(TestRestApiApplication.class, args);

	}

	@Autowired
	private  ItemRepository ip;
	@Override
	public void run(String... args) throws Exception {
		GroceryItem gs = new GroceryItem();
		gs.setName("Pratik");
		gs.setQuantity("6");
		gs.setCategory("testing");
		ip.save(gs);


	}
}
