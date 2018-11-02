package com.ag.java8lambdabasics;


/*if this is a lambda interface there should be only one method
 * 
 * otherwise compiler confused*/

@FunctionalInterface
public interface IHeyLambda {
	void sayHelloAndSum(int a, int b);
}
