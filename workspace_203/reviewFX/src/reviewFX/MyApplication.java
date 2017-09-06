package reviewFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MyApplication extends Application {

	Circle c = new Circle();
	int counter = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		c.setCenterX(100);
		c.setCenterY(100);
		c.setRadius(50);
		c.setStroke(Color.BLACK);
		c.setFill(Color.BLUE);
		Button b = new Button("Change Color");
		b.setOnAction(this::changeColor);
		
		Pane bp = new Pane();
		bp.getChildren().add(c);
		bp.getChildren().add(b);
		Scene scene = new Scene(bp, 250, 250);
		primaryStage.setTitle("My First Application");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
	
	public void changeColor(ActionEvent e){
			if(counter%2==0)
			c.setFill(Color.YELLOW);
		else
			c.setFill(Color.GRAY);
		counter++;
		
	}

}









