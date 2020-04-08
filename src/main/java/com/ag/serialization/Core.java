package com.ag.serialization;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static junit.framework.Assert.assertTrue;

public class Core {
	SerializationManager serializationManager = new SerializationManager();
	String filePath = "serialize-java-class.txt";
	static String filePathConst = "serialize-java-class.txt";

	@BeforeAll
	static void checkConstSerializateedFile(){
		File file = new File(filePathConst);
		assertTrue(file.exists());
	}

	@BeforeEach
	 void deleteSerializedFile(){
		File file = new File(filePath);
		if(file.exists()) file.delete();
	}

	@Test
	public void shouldSerializedJavaClassGenerated() {
		SerializeCls serializeCls = new SerializeCls(99, "some text", 10, false, true);

		serializationManager.serializeTo(serializeCls,filePath);

		File file = new File(filePath);
		assertTrue(file.exists());
		assertTrue(file.length()>0);
	}

	@Test
	public void shouldDeserializeJavaClass(){
		serializationManager.deserializeFrom(SerializeCls.class,filePathConst);
	}

	@Test
	public void shouldSerializedFleEqualToDeserializeJavaClass(){

	}
}
