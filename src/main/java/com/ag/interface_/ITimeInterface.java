package com.ag.interface_;

public interface ITimeInterface {
	public static String getDurationText(long time) {
		return "duration is " + (System.currentTimeMillis() - time) + " ms";
	}

	public long calcTime(long time);

	default public void sentToDB(){

	}
}
