package testjava8;

import java.util.function.IntBinaryOperator;

public class Java8test2 {
	
//	static String salutation = "HOla ";
	
	public static void main(String[] args) {
		
		String salutation = "Ola ";
		
		MathOperation addition = (a, b) -> a + b;
		MathOperation soustraction = (a, b) -> a - b;
		MathOperation multiplication = (a, b) -> { return a * b; };
		MathOperation division = (int a, int b) -> a / b;
		
		Java8test2 tester =  new Java8test2();
		
		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, soustraction));
		System.out.println("10 * 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));

		System.out.println("****************************************************");
		System.out.println("10 + 5 = " + tester.operate2(10, 5, (a, b) -> a + b));
		System.out.println("10 - 5 = " + tester.operate2(10, 5, (a, b) -> a - b));
		System.out.println("10 * 5 = " + tester.operate2(10, 5, (a, b) -> { return a * b; }));
		System.out.println("10 / 5 = " + tester.operate2(10, 5, (int a, int b) -> a / b));
		
		// salutation = "Hollllaaaaa"; // Local variable salutation defined in an enclosing scope must be final or effectively final
		
		GreetingService s = msg -> System.out.println(salutation + msg);
		
		s.sayMessage("Ben");
		s.sayMessage("Loic");
		
		System.out.println("***********FIN*************");
	}
	
	interface MathOperation {
		int operation(int a, int b);
	}
	
	interface GreetingService {
		void sayMessage(String msg);
	}
	
	private int operate(int a, int b, MathOperation op) {
		return op.operation(a, b);
	}

	private int operate2(int a, int b, IntBinaryOperator op) {
		return op.applyAsInt(a, b);
	}

}
