package testjava8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.DoubleBinaryOperator;
import java.util.stream.Collectors;

public class Java8Tester {

   public static void main(String args[]) {
   
      List<String> names1 = new ArrayList<String>();
      names1.add("Mahesh ");
      names1.add("Suresh ");
      names1.add("Ramesh ");
      names1.add("Naresh ");
      names1.add("Kalpesh ");
		
      List<String> names2 = new ArrayList<String>();
      names2.add("Mahesh ");
      names2.add("Suresh ");
      names2.add("Ramesh ");
      names2.add("Naresh ");
      names2.add("Kalpesh ");
		
      Java8Tester tester = new Java8Tester();
      System.out.println("Sort using Java 7 syntax: ");
		
      tester.sortUsingJava7(names1);
      System.out.println(names1);
      System.out.println("Sort using Java 8 syntax: ");
		
      tester.sortUsingJava8(names2);
      System.out.println(names2);
      
      List<String> names3 = new ArrayList<String>();
      names3.add("Mahesha ");
      names3.add("Sureshbb ");
      names3.add("Rameshccc ");
      names3.add("Nareshddddd ");
      names3.add("Kalpesh ");
      
      List<String> names4 = names3.stream().collect(Collectors.toList());
      List<String> names5 = names3.stream().collect(Collectors.toList());
      
      tester.sortUsingJava8(names3);
      System.out.println("names3 : " + names3);
      
      names4.sort(Comparator.comparingInt(String::length));
      System.out.println("names4 : " + names4);
      
      Collections.sort(names5, (x, y) -> Integer.compare(x.length(), y.length()));
      System.out.println("names5 : " + names5);
      

      
      System.out.println("OP PLUS 2 et 3 : " + Operation.PLUS.apply(2, 3));
      System.out.println("OP MOINS 2 et 3 : " + Operation.MOINS.apply(2, 3));
      System.out.println("OPOLD PLUS 2 et 3 : " + OldOperation.PLUS.apply(2, 3));
      System.out.println("OPOLD MOINS 2 et 3 : " + OldOperation.MOINS.apply(2, 3));
      
   }
   
   //sort using java 7
   private void sortUsingJava7(List<String> names) {   
      Collections.sort(names, new Comparator<String>() {
         @Override
         public int compare(String s1, String s2) {
            return s1.compareTo(s2);
         }
      });
   }
   

   //sort using java 8
   private void sortUsingJava8Bad(List<String> names) {   
      names.stream().sorted();  // ne trie pas names mais son flux
	   //names = names.stream().sorted().collect(Collectors.toList());
	   System.out.println(names);
   }
   private void sortUsingJava8(List<String> names) {   
	      Collections.sort(names, (name1, name2) -> name1.compareTo(name2));
	   }
   
   public enum OldOperation {
	   PLUS {

			@Override
			public double apply(double x, double y) {
				return x + y;
			}
		},
	   MOINS {

		@Override
		public double apply(double x, double y) {
			return x - y;
		}} ;
	   public abstract double apply(double x, double y);
   }
   
   public enum Operation {
	   
	   PLUS ( (x, y) -> x+y),
	   MOINS ( (x, y) -> x-y)
	   ;
	   
	   private Operation(DoubleBinaryOperator op) {
		   this.op = op;
	   }
	   private final DoubleBinaryOperator op;
	   
	   public double apply(double x, double y) {
		   return op.applyAsDouble(x, y);
	   }
   }
   public enum MesConstantes {
	   
	   UN (1),
	   DEUX (2);
	   

	   private MesConstantes(int value) {
	   }
   }
   
}
