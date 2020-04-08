package itnv_q_1;

import java.util.ArrayList;
import java.util.List;

public class RaceResultCalculater {
	
	public List<RaceResult> getResults(List<RaceData> raceData){
		List<RaceResult> raceResults = new ArrayList<RaceResult>();
		for(RaceData data : raceData) {
			RaceResult result = new RaceResult();
			result.setRacer(data.getRacer());
			result.setAverageTime(getAverageTime(data.getLapsTime()));
			result.setBestLapTime(getBestLapTime(data.getLapsTime()));
			raceResults.add(result);

		}
		
		return raceResults;
	}

	private int getBestLapTime(List<Integer> lapsTime) {
		int bestTime = 0;
		for(Integer time : lapsTime) {
			if(time > bestTime) {
				bestTime=time;
			}
		}
		return bestTime;
	}

	private int getAverageTime(List<Integer> lapsTime) {
		int total = 0;
		for(Integer time : lapsTime) {
			total+=time;
		}
		return total/lapsTime.size();
	}
}
