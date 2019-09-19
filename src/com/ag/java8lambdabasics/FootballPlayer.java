package com.ag.java8lambdabasics;

public class FootballPlayer {

	private String name;
	private String team;
	private int age;
	
	
	public FootballPlayer(String name, String team, int age) {
		super();
		this.name = name;
		this.team = team;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
