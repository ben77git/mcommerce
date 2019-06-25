package testjava8.complexMethods;

import java.util.Optional;

public class OptionalTester {
	
	public static void main(String[] args) {
		OptionalTester tester = new OptionalTester();
		Integer value1 = null;
	    Integer value2 = null; // new Integer(10);
	    
	  //Optional.ofNullable - allows passed parameter to be null.
	    Optional<Integer> a = Optional.ofNullable(value1);
	    
	  //Optional.of - throws NullPointerException if passed parameter is null
	    //Optional<Integer> b = Optional.of(value2);
	    Optional<Integer> b = Optional.ofNullable(value2);
	    
	    System.out.println("La somme vaut : " + tester.sum(a, b));
	      
	}
	
	public int sum(Optional<Integer> a, Optional<Integer> b) {
		//Optional.isPresent - checks the value is present or not
		
	      System.out.println("First parameter is present: " + a.isPresent());
	      System.out.println("Second parameter is present: " + b.isPresent());
	      
	    //Optional.orElse - returns the value if present otherwise returns
	      //the default value passed.
		int x = a.orElse(0);
		
		//Optional.get - gets the value, value should be present
		int y = b.get();
		return x + y;
	}

}
