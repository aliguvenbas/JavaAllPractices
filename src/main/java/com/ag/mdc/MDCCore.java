package com.ag.mdc;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.util.Scanner;

@Slf4j
public class MDCCore {

	static String id = "df";

	public static void main(String[] args) {
		MDC.put("logging.googleapis.com/labels", id);
		addLog();

		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			id = sc.nextLine();
			if(id.equals("*")) {
				addLog();
			} else {
				MDC.put("logging.googleapis.com/labels", id);
				log.error("id added:" + id);
			}
		}
	}

	private static void addLog() {
		log.error(" Thread working:" + Math.random());
	}
}
