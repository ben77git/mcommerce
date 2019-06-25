package testjava8.defaultMethods;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Car implements Vehicle, FourWheeler {
	// Default methods are allowed only in interfaces
	@Override 
	public void print() {
		 Vehicle.super.print();
		 //System.out.println("I am a four wheeler car vehicle!");
		 FourWheeler.super.print();
		 Vehicle.blowHorn();
		 System.out.println("I am a car");
		 
		 System.out.println("10 entiers aleatoires*****************");
		 new Random().ints().limit(10).forEach(System.out::println);
		 
		 System.out.println("10 entiers aleatoires triés avec foreachOrdered *****************");
		 new Random().ints().limit(10).forEachOrdered(System.out::println);
		 
		 System.out.println("10 entiers aleatoires trié avec sorted() *****************");
		 new Random().ints().limit(10).sorted().forEach(System.out::println);
		 
		 
		 List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		 List<String> filteredList = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
		 System.out.println("Liste filtrées : " + filteredList);
		 
		 // filteredList2
		 String filteredString2 = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(", "));
		 System.out.println("String filtrées : " + filteredString2);
		 
		 List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		 
		 List<Integer> squares = numbers.stream().map(x -> x * x).distinct().collect(Collectors.toList());
		 System.out.println("Liste carrées : " + squares);
		 
		 List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

		//get count of empty string
		 long nb = strings2.stream().filter( s -> s.isEmpty()).count();
		 System.out.println("nb de \"\" trouvés : " + nb);
		 
		 long nb2 = strings2.parallelStream().filter( s -> s.isEmpty()).count();
		 System.out.println("nb de \"\" trouvés avec parallelStream() : " + nb2);
		 
		 List numbers2 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		 IntSummaryStatistics stats = numbers2.stream().mapToInt(x -> (int)x).summaryStatistics();
		 System.out.println("Highest number in list : " + stats.getMax());
		 System.out.println("Lowest number in list : " + stats.getMin());
		 System.out.println("Sum of all numbers : " + stats.getSum());
		 System.out.println("Average of all numbers : " + stats.getAverage());

	 }
	
	public static void main(String[] args) {
		FourWheeler fw = new Car();
		fw.print();
	}
}
