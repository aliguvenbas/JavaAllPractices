package com.ag.collections_;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class HowTreeSetCanBeUsedEfficiently {
	public static void main(String[] args) throws ParseException {
		// Generate 100,000 random payments
		List<Payment> arrayList = new ArrayList<>();
		List<Payment> linkedArrayList = new LinkedList<>();
		Set<Payment> hashSet = new HashSet<>();
		Set<Payment> linkedHashSet = new LinkedHashSet<>();
		TreeSet<Payment> treeSet = new TreeSet<>(Comparator.comparing(Payment::getTime));

		for(int i = 0; i < 10000000; i++) {
			Payment payment = new Payment(generateRandomString(16), generateRandomTime(), Math.random() * 100000);
			arrayList.add(payment);
			linkedArrayList.add(payment);
			hashSet.add(payment);
			linkedHashSet.add(payment);
			treeSet.add(payment);
		}

		System.out.println("ArrayList: " + arrayList.size() );
		System.out.println("linkedArrayList: " + linkedArrayList.size() );
		System.out.println("hashSet: " + hashSet.size() );
		System.out.println("linkedHashSet: " + linkedHashSet.size() );
		System.out.println("treeSet: " + treeSet.size() );


		// Given time to search for
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = "1990-12-10";
		Date givenTime = sdf.parse(dateString);

		// Measure search time for ArrayList
		long startTime = System.nanoTime();
		List<Payment> paymentsBeforeTimeArrayList = arrayList.stream()
				.filter(payment -> payment.getTime().before(givenTime))
				.collect(Collectors.toList());
		long endTime = System.nanoTime();
		long arrayListSearchTime = endTime - startTime;

		 startTime = System.nanoTime();
		List<Payment> paymentsBeforeTimeLinkedList = linkedArrayList.stream()
				.filter(payment -> payment.getTime().before(givenTime))
				.collect(Collectors.toList());
		 endTime = System.nanoTime();
		 long linkedListSearchTime = endTime - startTime;

		// Measure search time for HashSet
		startTime = System.nanoTime();
		List<Payment> paymentsBeforeTimeHashSet = hashSet.stream()
				.filter(payment ->  payment.getTime().before(givenTime))
				.collect(Collectors.toList());
		endTime = System.nanoTime();
		long hashSetSearchTime = endTime - startTime;

		// Measure search time for HashSet
		startTime = System.nanoTime();
		List<Payment> paymentsBeforeTimeLinkedHashSet = linkedHashSet.stream()
				.filter(payment ->  payment.getTime().before(givenTime))
				.collect(Collectors.toList());
		endTime = System.nanoTime();
		long linkedHashSetSearchTime = endTime - startTime;

		// Measure search time for TreeSet
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = df.parse("1940-01-01");

		startTime = System.nanoTime();
		SortedSet<Payment> paymentsBeforeTimeTreeSet = treeSet.subSet(
				new Payment("", startDate, 0.0), true,
				new Payment("", givenTime, 0.0), true);
		endTime = System.nanoTime();
		long treeSetSearchTime = endTime - startTime;

		// Print the results
		System.out.println("Given amount: " + givenTime);
		System.out.println("Payments in A: " + paymentsBeforeTimeArrayList.size() + " - Time taken: " + arrayListSearchTime + " ns");
		System.out.println("Payments in L: " + paymentsBeforeTimeLinkedList.size() + " - Time taken: " + linkedListSearchTime + " ns");
		System.out.println("Payments in H: " + paymentsBeforeTimeHashSet.size() + " - Time taken: " + hashSetSearchTime + " ns");
		System.out.println("Payments in L: " + paymentsBeforeTimeLinkedHashSet.size() + " - Time taken: " + linkedHashSetSearchTime + " ns");
		System.out.println("Payments in T: " + paymentsBeforeTimeTreeSet.size() + " - Time taken: " + treeSetSearchTime + " ns");
	}

	// Helper method to generate a random string of a given length
	private static String generateRandomString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder(length);
		Random random = new Random();
		for(int i = 0; i < length; i++) {
			sb.append(characters.charAt(random.nextInt(characters.length())));
		}
		return sb.toString();
	}

	// Helper method to generate a random time string (HH:mm:ss)
	private static Date generateRandomTime() {
		long startDateMillis = 0L; // Start date (UNIX epoch)
		long endDateMillis = System.currentTimeMillis(); // End date (current date)

		// Generate a random timestamp between start and end dates
		long randomTimestamp = startDateMillis + (long) (Math.random() * (endDateMillis - startDateMillis));

		// Create a new Date object with the random timestamp
		return new Date(randomTimestamp);
	}
}

class Payment {
	private String cardNumber;
	private Date time;  // Assuming time is a String in HH:mm:ss format for simplicity
	private double amount;

	public Payment(String cardNumber, Date time, double amount) {
		this.cardNumber = cardNumber;
		this.time = time;
		this.amount = amount;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public Date getTime() {
		return time;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		Payment payment = (Payment) o;
		return Objects.equals(time, payment.time);
	}

	@Override
	public String toString() {
		return "Payment{" +
				"cardNumber='" + cardNumber + '\'' +
				", time='" + time + '\'' +
				", amount=" + amount +
				'}';
	}
}

