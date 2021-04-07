package com.ag.random_;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.junit.jupiter.api.Test;

public class Core {

	@Test
	public void shouldGenerateRandom8Digit(){
		SecureRandom sr = new SecureRandom();
		StringBuffer stringBuffer = new StringBuffer();
		for(int i = 0;i<8;i++){
			stringBuffer.append(sr.nextInt(10));

		}
		;
		System.out.println(stringBuffer.toString());
	}
}
