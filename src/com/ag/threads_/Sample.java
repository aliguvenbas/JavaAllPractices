package com.ag.threads_;

public class Sample extends Thread {

	@Override
	public void run() {

		while (true) {
			for (int j = 0; j < 10; j++) {
				System.out.println(j);

				try {
					sleep(1000); // Örneğin her seferinde 1 saniye beklenecek
				} catch (InterruptedException e) {
					// Bekleme esnasında kanala işletimi kesme sinyali
					// gönderilirse
					// yapılacak işler burada ele alınacak
				}
			}
		}
	}

	public static void main(String[] args) {
		Sample a = new Sample();
		a.start();
	}

}