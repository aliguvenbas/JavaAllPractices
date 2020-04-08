package itnv_q_1;

import java.util.List;

public class RaceData {
	  private String racer;
	    private List lapsTime; //time in minutes (integers)

	    //racer - name of the racer
	    //lapsTime - time of each lap in minutes
	    RaceData(String racer, List lapsTime) {
	        this.racer = racer;
	        this.lapsTime = lapsTime;
	    }

	    String getRacer() {
	        return racer;
	    }

	    List<Integer> getLapsTime() {
	        return lapsTime;
	    }
}
