package com.ag.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationManager {

	public void serializeTo(SerializeCls serializeCls, String filePath) {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
			objectOutputStream.writeObject(serializeCls);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void deserializeFrom(Class serializeCls, String filePath) {
//		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
//		Object object = objectInputStream.readObject()
	}
}
