package testjava8.defaultMethods;

public interface Vehicle {
	default void print() {
		System.out.println("I am a Vehicule");
	}
	
	static void blowHorn() {
		System.out.println("Blowing horn!!!");
	}
}
