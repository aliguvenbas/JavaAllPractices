package com.ag.readfile;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScoodleMockDataProvider {

	public String fetchDomains(){
		InputStream inputStream = getClass().getResourceAsStream("scoodle_domains_response.json");
		JsonObject inputData = JsonParser.parseReader(new InputStreamReader(inputStream)).getAsJsonObject();
		return inputData.getAsString();
	}

	public static void main(String[] args) throws IOException {
		ScoodleMockDataProvider scoodleMockDataProvider = new ScoodleMockDataProvider();
		String s = scoodleMockDataProvider.fetchAllData();
		System.out.println(s);
	}

	public String fetchAllData() {
		String fileName = "scoodle/data/allDataResponse.json";
		// create Gson instance
		Gson gson = new Gson();

		// create a reader
		try {
			Reader reader = Files.newBufferedReader(Paths.get(fileName));
			return reader.toString();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
