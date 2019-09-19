package com.ag.java8lambdabasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
/*
 * use java.util.function for functional interfaces
 * 
 * https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
 * */

public class LambdaExercise2MoreFeatures {

	public LambdaExercise2MoreFeatures() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<FootballPlayer> players = Arrays.asList(new FootballPlayer("Cristiano Ronaldo", "Juventus", 30), new FootballPlayer("Luka Modric", "Real Madrid", 33), new FootballPlayer("Cengiz Ünder", "Roma", 21), new FootballPlayer("Marcelo Vieira", "Real Madrid", 30));

		java8(players);
	}

	private static void java8(List<FootballPlayer> players) {
		System.out.println("java 8 outputs**************");
		// sort by name
		// Comparator<FootballPlayer> player = (o1, o2)
		// ->o1.getName().compareTo(o2.getName());
		Collections.sort(players, (o1, o2) -> o1.getName().compareTo(o2.getName()));

		// get players in same team
		// ICondition cond = (t, obj)-> t.getTeam().equals(obj.toString());
		getConditionally(players, (t) -> ((FootballPlayer) t).getTeam().equals("Real Madrid"));
		
//		boolean b = (players.get(0)) -> ((FootballPlayer) players.get(0)).getTeam().equals("Real Madrid");
		
		
		// get players which name start with C
		// ICondition cond= (t, obj) -> ((FootballPlayer)
		// t).getName().startsWith(obj.toString());
		getConditionally(players, (t) -> ((FootballPlayer) t).getName().startsWith("C"));
		getConditionally(players, t -> true, t -> ((FootballPlayer) t).getName().startsWith("C"));
	}

	// Predicate has test() method with one argument, returns boolean
	private static void getConditionally(List<FootballPlayer> players, Predicate<FootballPlayer> predicate) {
		for (FootballPlayer fp : players) {
			if (predicate.test(fp)) {
				System.out.println(fp.getName());
			}
		}

	}

	// Consumer has accept() method with one argument, no returns
	private static void getConditionally(List<FootballPlayer> players, Predicate<FootballPlayer> predicate, Consumer<FootballPlayer> consumer) {
		for (FootballPlayer fp : players) {
			if (predicate.test(fp)) {
				consumer.accept(fp);
				// System.out.println(fp.getName());
			}
		}

	}

}
