package reviewFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MyFirstApp extends Application {
	Circle c = new Circle();
	boolean toggle = true;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		c.setCenterX(100);
		c.setCenterY(100);
		c.setRadius(50);
		c.setStroke(Color.BLACK);
		c.setFill(Color.YELLOW);
		
		Button b = new Button("Change Color");
		Pane parent = new Pane();
		parent.getChildren().add(c);
		parent.getChildren().add(b);
		b.setOnAction(this::changeColor);
		Scene scene = new Scene(parent, 250,250);
		primaryStage.setTitle("My First Application! Yay!!!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void changeColor(ActionEvent e){
		if(toggle){
			c.setFill(Color.GREEN);
			toggle = false;
		}else
		{
			c.setFill(Color.AQUAMARINE);
			toggle = true;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}
