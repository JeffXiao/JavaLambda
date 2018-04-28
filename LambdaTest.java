import java.util.*;
import java.util.function.*;

public class LambdaTest {
	public static void main(String args[]) {
		doNumericTest();
		doGreetingTest();
		doStringTest();
		doGenericTest();
	}

	interface NumericTest {
		boolean computeTest(int n); 
	}

	public static void doNumericTest() {
		// Output: false
		NumericTest isEven = (n) -> (n % 2) == 0;
		System.out.println(isEven.computeTest(5));

		// Output: true
		NumericTest isNegative = (n) -> (n < 0);
		System.out.println(isNegative.computeTest(-5));
	}

	interface MyGreeting {
		String processName(String str);
	}

	public static void doGreetingTest() {
		// Output: Good Morning Luis! 
		MyGreeting morningGreeting = (str) -> "Good Morning " + str + "!";
		System.out.println(morningGreeting.processName("Luis"));

		// Output: Good Evening Jessica!
		MyGreeting eveningGreeting = (str) -> "Good Evening " + str + "!";
		System.out.println(eveningGreeting.processName("Jessica"));	
	}

	interface MyString {
		String myStringFunction(String str);
	}

	public static void doStringTest() {
		// Block lambda to reverse string
		MyString reverseStr = (str) -> {
			String result = "";
		
			for(int i = str.length()-1; i >= 0; i--)
				result += str.charAt(i);
		
			return result;
		};

		// Output: omeD adbmaL
		System.out.println(reverseStr.myStringFunction("Lambda Demo")); 
	}

	interface MyGeneric<T> {
		T compute(T t);
	}

	public static void doGenericTest(){

		// String version of MyGenericInteface
		MyGeneric<String> reverse = (str) -> {
			String result = "";
		
			for(int i = str.length()-1; i >= 0; i--)
				result += str.charAt(i);
		
			return result;
		};

		// Output: omeD adbmaL
		System.out.println(reverse.compute("Lambda Demo")); 

		// Integer version of MyGeneric
		MyGeneric<Integer> factorial = (n) -> {
			int result = 1;
		
			for(int i = 1; i <= n; i++)
				result = i * result;
		
			return result;
		};

		// Output: 120
		System.out.println(factorial.compute(5)); 
	}
}