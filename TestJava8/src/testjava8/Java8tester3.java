package testjava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Java8tester3 {

	public static void main(String[] args) {
		List names = new ArrayList();
		
	      names.add("Mahesh");
	      names.add("Suresh");
	      names.add("Ramesh");
	      names.add("Naresh");
	      names.add("Kalpesh");
	      
	      // List<String> names = new ArrayList<>();
	      // Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	      
	      names.forEach(System.out::println);
	      
	      List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
	      
	      System.out.println("Print all numbers");
	      // pass n  as a number
	      eval(list, x -> true);
	      
	      System.out.println("Print all even numbers");
	      // pass n  as a number
	      eval(list, x -> x%2 == 0);
	      
	      System.out.println("Print all numbers greater than 3");
	      // pass n  as a number
	      eval(list, x -> x > 3);
	}
	
	private static void eval(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer x : list) {
			if (predicate.test(x)) {
				System.out.println(x);
			}
		}
	}

}
