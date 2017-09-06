package testInheritance;

import javafx.application.Application;
import javafx.stage.Stage;

public class TestInheritance extends Application {
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface Edible{
	String howToEat();
	boolean isEdible();
}

interface Active{
	int getSpeed();
	boolean isActive();
}

class Fruit implements Edible{
	String name;
	
	public Fruit(){
		this("Delicious...");
		
	}
	
	public Fruit(String name){
		this.name = name;
	}
	@Override
	public String howToEat() {
		// TODO Auto-generated method stub
		return "Depending on the fruit...";
	}

	@Override
	public boolean isEdible() {
		// TODO Auto-generated method stub
		return true;
	}
	
}

class Apple extends Fruit{
	
	public Apple(){
		super("Apple");
	}
	public Apple(String name){
		super(name);
	}
	@Override
	public String howToEat() {
		// TODO Auto-generated method stub
		return "Wash it and eat it!";
	}

	
}