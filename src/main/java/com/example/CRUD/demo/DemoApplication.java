package com.example.CRUD.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.CRUD.demo.dao.GamingDAO;
import com.example.CRUD.demo.entity.Game;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private void createGame(GamingDAO gamingDAO){
		System.out.println("Creating new game ...");
		Game game = new Game("Stardew Valley", 'E', 300);
		System.out.println("Saving Game to db ...");
		gamingDAO.save(game);
		System.out.printf("Saved game. Generated id is: %d \n",game.getId());
	}

	private void getAllGames(GamingDAO gamingDAO){
		List<Game> allGames = gamingDAO.findAll();
		allGames.stream().forEach(game -> System.out.println(game));
	}

	private void updateGame(GamingDAO gamingDAO){
		Game gameToUpdate = gamingDAO.get(1);
		gameToUpdate.setHoursToBeat(100);
		gamingDAO.update(gameToUpdate);
		System.out.printf("Game was updated...");
	}

	private void deleteGame(GamingDAO gamingDAO){
		gamingDAO.delete(1);
	}

	@Bean
	public CommandLineRunner commandLineRunner(GamingDAO gamingDAO){
		return  runner -> {
			createGame(gamingDAO);
			getAllGames(gamingDAO);
			updateGame(gamingDAO);
			deleteGame(gamingDAO);
		};
	}
}
