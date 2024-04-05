package com.ag.stream_;

import static junit.framework.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class StreamThreads {

	List<String> array = Arrays.asList("test-1", "test-2", "test-3", "test-4", "test-5", "test-6", "test-7", "test-8");


	@Test
	public void shouldEachElementRunInSequence(){
		long startTime = System.currentTimeMillis();
		array.stream().forEach(element -> {
			long threadId = Thread.currentThread().getId();
			System.out.println(element+",  Thread " + threadId );
		});
		long endTime = System.currentTimeMillis();
		System.out.println("success in "+(endTime-startTime));
	}

	@Test
	public void shouldEachElementRunInParallel(){
		long startTime = System.currentTimeMillis();
		array.parallelStream().forEach(element -> {
			long threadId = Thread.currentThread().getId();
			System.out.println(element+",  Thread " + threadId );
		});
		long endTime = System.currentTimeMillis();
		System.out.println("success in "+(endTime-startTime));
	}
}
