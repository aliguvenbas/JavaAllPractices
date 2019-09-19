package itnv_q_1;

import java.util.List;

public class Referee {

	public void decideWinner(List<RaceResult> raceResults){
		RaceResult winner = null;
		int bestAverage = 0;
		for(RaceResult result: raceResults) {
			if(result.getAverageTime()>bestAverage) {
				bestAverage = result.getAverageTime();
				winner = result;
			}
		}
		winner.setWinner(true);
	}
}
