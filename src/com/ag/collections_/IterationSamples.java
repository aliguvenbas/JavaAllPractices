package com.ag.collections_;

import java.util.Arrays;
import java.util.List;

import com.ag.java8lambdabasics.FootballPlayer;

public class IterationSamples {

	public static void main(String[] args) {
		List<FootballPlayer> players = Arrays.asList(new FootballPlayer("Cristiano Ronaldo", "Juventus", 30), new FootballPlayer("Luka Modric", "Real Madrid", 33), new FootballPlayer("Cengiz Ünder", "Roma", 21), new FootballPlayer("Marcelo Vieira", "Real Madrid", 30));

		// for loop
		System.out.println("for loop");
		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).getName());
		}

		// for-each / for-in loop
		System.out.println("\nfor-each / for-in loop");
		for (FootballPlayer player : players) {
			System.out.println(player.getName());
		}

		// lambda for-each loop
		System.out.println("\nlambda for-each loop");
		players.forEach(player -> {
			System.out.println(player.getName());
			System.out.println(player.getTeam());
		});

	}
}
