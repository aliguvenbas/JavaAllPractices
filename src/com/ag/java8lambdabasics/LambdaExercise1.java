package com.ag.java8lambdabasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExercise1 {

	public LambdaExercise1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<FootballPlayer> players = Arrays.asList(new FootballPlayer("Cristiano Ronaldo", "Juventus", 30), new FootballPlayer("Luka Modric", "Real Madrid", 33), new FootballPlayer("Cengiz Ünder", "Roma", 21), new FootballPlayer("Marcelo Vieira", "Real Madrid", 30));

		java7(players);
		java8(players);
	}

	private static void java7(List<FootballPlayer> players) {
		System.out.println("java 7 outputs**************");
		// sort by name
		Collections.sort(players, new Comparator<FootballPlayer>() {

			@Override
			public int compare(FootballPlayer o1, FootballPlayer o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		// get players in same team
		getConditionally(players, new ICondition<FootballPlayer>() {

			@Override
			public boolean cond(FootballPlayer t, Object obj) {
				return t.getTeam().equals(obj.toString());

			}
		});

		// get players which name start with C
		getConditionally(players, new ICondition<FootballPlayer>() {

			@Override
			public boolean cond(FootballPlayer t, Object obj) {
				return t.getName().startsWith(obj.toString());
			}
		});
		
		IHeyLambda heyLambda = new IHeyLambda() {
			
			@Override
			public void sayHelloAndSum(int a, int b) {
				System.out.println("Hello world Lambda, sum+"+(a+b));
			}
		};

	}

	private static void java8(List<FootballPlayer> players) {
		System.out.println("java 8 outputs**************");
		// sort by name
		// Comparator<FootballPlayer> player = (o1, o2)
		// ->o1.getName().compareTo(o2.getName());
		Collections.sort(players, (o1, o2) -> o1.getName().compareTo(o2.getName()));

		// get players in same team
//		ICondition cond = (t, obj)-> t.getTeam().equals(obj.toString());
		getConditionally(players, (t, obj)-> ((FootballPlayer) t).getTeam().equals(obj.toString()));
		
		// get players which name start with C
//		ICondition cond=   (t, obj) -> ((FootballPlayer) t).getName().startsWith(obj.toString());
		getConditionally(players, (t,obj)-> ((FootballPlayer) t).getName().startsWith(obj.toString()));
	}
	

	private static void getConditionally(List<FootballPlayer> players, ICondition iCondition) {
		for (FootballPlayer fp : players) {
			if (iCondition.cond(fp, "Real Madrid")) {
				System.out.println(fp.getName());
			}
		}

	}

}

interface ICondition<T> {
	public boolean cond(T t, Object obj);
}
