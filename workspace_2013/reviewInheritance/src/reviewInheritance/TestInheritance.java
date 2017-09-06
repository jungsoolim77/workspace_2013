package reviewInheritance;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TestInheritance extends Application {

	BorderPane bp = new BorderPane();
	TextField tf = new TextField();
	TextArea ta = new TextArea();
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		bp.setCenter(ta);
		HBox hbox = new HBox();
		hbox.getChildren().addAll(new Label("Please enter an object to test. "), tf);
		bp.setBottom(hbox);
		hbox.setAlignment(Pos.CENTER);
		//tf.setAlignment(Pos.BOTTOM_RIGHT);
		tf.setOnAction(this::Action);
		
		Scene scene = new Scene(bp, 400,200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Inheritance Test");
		primaryStage.show();
	}

	public void Action(ActionEvent e){
		try{
			int index = 0;
			Edible[] list = new Edible[4];
			list[0] = new Apple();
			list[1] = new GreenApple();
			list[2] = new Chicken();
			list[3] = new Tiger();
			ta.clear();
			if(tf.getText().equals("Apple"))
				index = 0;
			else if (tf.getText().equals("GreenApple"))
				index = 1;
			else if (tf.getText().equals("Chicken"))
				index = 2;
			else if (tf.getText().equals("Tiger"))
				index = 3;
			else
				index = -1;
			
			if (index >=0)
				ta.setText(tf.getText() + " can be eaten as ..." + list[index].howToEat());
			else
				ta.setText(tf.getText() + " has not been defined yet.");

			
		}catch(Exception ex){
			ta.clear();
			ta.setText(tf.getText() + " has not been defined yet.");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

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

class Fruit implements Edible, Comparable<Fruit>{
	String name;
	int size;
	
	
	public Fruit(){
		this("Delicious", 7);
	}
	
	public Fruit(String name, int size){
		this.name = name;
		this.size = size;
	}
	
	public int getSize(){
		return size;
		
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	@Override
	public String howToEat() {
		// TODO Auto-generated method stub
		return "Depending on...";
	}

	@Override
	public boolean isEdible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int compareTo(Fruit o) {
		// TODO Auto-generated method stub
		return this.getSize() - o.getSize();
	}
	
}

class Animal implements Edible, Active, Comparable<Animal>{
	String name;
	int speed;
	
	public Animal(){
		this("Who are you? ", 10);
		
	}
	
	public Animal(String name, int speed){
		this.name = name;
		this.speed = speed;
	}
	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}

	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String howToEat() {
		// TODO Auto-generated method stub
		return "Depending on...";
	}

	@Override
	public boolean isEdible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compareTo(Animal o) {
		// TODO Auto-generated method stub
		return this.getSpeed() - o.getSpeed();
	}

}

class Apple extends Fruit{
	
	@Override
	public String howToEat() {
		// TODO Auto-generated method stub
		return "Clean and eat it!";
	}
}

class GreenApple extends Apple{
	
}

class Orange extends Fruit{
	@Override
	public String howToEat() {
		// TODO Auto-generated method stub
		return "Peel its skin and eat it!";
	}
}

class Chicken extends Animal{
	public Chicken(){
		super("Chicken", 3);
		
	}
	
	@Override
	public String howToEat() {
		// TODO Auto-generated method stub
		return "Make a soup. ";
	}

	@Override
	public boolean isEdible() {
		// TODO Auto-generated method stub
		return true;
	}
}

class Tiger extends Animal{
	public Tiger(){
		super("Tiger", 3);
		
	}
	
	@Override
	public String howToEat() {
		// TODO Auto-generated method stub
		return "Don't even think about it! ";
	}
}