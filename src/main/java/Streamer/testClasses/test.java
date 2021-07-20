package testClasses;

import interfaces.markInterface;
import interfaces.testInterface;

public class test {
	
	@markInterface
	String testString = "test";
	
	@markInterface
	int testInt = 42;
	
	@testInterface(myDescription = "testString")
	//@markInterface
	public static void testMethod() {
		
		
		
	}
	
	//@markInterface
	public static String rtnSomething() {
		return "lol";
	}
}
