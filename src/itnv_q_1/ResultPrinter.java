package itnv_q_1;

import java.util.List;

public class ResultPrinter {

	public void printResults(List<RaceResult> raceResults) {
		  System.out.print("--------------------\n");
		  for(int i = 0;i<raceResults.size();i++) {
			  System.out.print("Racer"+(raceResults.get(i).isWinner()?"(Winner)":"")+":"+raceResults.get(i).getRacer());
			  System.out.print("Average time:"+raceResults.get(i).getAverageTime());
			  System.out.print("Best lap:"+raceResults.get(i).getBestLapTime());
		  }
		  System.out.print("--------------------\n");
	}
}
