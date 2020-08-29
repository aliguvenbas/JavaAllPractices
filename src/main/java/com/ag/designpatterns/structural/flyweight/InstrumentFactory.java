package com.ag.designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class InstrumentFactory {

	static HashMap<String, IInstrument> instrumentHashMap = new HashMap<>();

	public static Drum getDrum(String id){
		Drum drum = (Drum) instrumentHashMap.get(id);
		if(drum == null){
			drum = new Drum();
			instrumentHashMap.put(id,drum);
		}
		return drum;
	}

	public static Guitar getGuitar(String id){
		Guitar guitar = (Guitar) instrumentHashMap.get(id);
		if(guitar == null){
			guitar = new Guitar();
			instrumentHashMap.put(id,guitar);
		}
		return guitar;
	}

	public static Piano getPiano(String id){
		Piano piano = (Piano) instrumentHashMap.get(id);
		if(piano == null){
			piano = new Piano();
			instrumentHashMap.put(id,piano);
		}
		return piano;
	}

	public static Map getObjectList(){
		return instrumentHashMap;
	}
}
