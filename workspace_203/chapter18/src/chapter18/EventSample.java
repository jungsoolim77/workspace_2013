package chapter18;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class EventSample extends Application {

	private Circle c = new Circle();
	BorderPane borderPane = new BorderPane();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		int width = 400, height = 410;
		HBox hBox = new HBox();
		Button bIncrease = new Button("Increase size");
		Button bDecrease = new Button("Decrease size");
		Button bRed = new Button("Red Color");
		Button bBlue = new Button("Blue Color");
		c.setCenterX(width/2);
		c.setCenterY(height/2);
		c.setRadius(width/4);
		c.setStroke(Color.BLACK);
		c.setFill(Color.YELLOW);
		
		hBox.getChildren().addAll(bIncrease, bDecrease,bRed, bBlue);
		//use inner class
		bIncrease.setOnAction(new Increase());
		
		//use anonymous inner class
		bDecrease.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				if(c.getRadius() > 0){
					c.setRadius(c.getRadius() - 5);
					c.setStroke(Color.BLACK);
					c.setFill(Color.YELLOW);
				}
			}
		});
		
		//using lambda
		bRed.setOnAction(e -> {
			c.setStroke(Color.PINK);
			c.setFill(Color.RED);
		});
		
		//using method resolution   
		bBlue.setOnAction(this::blueColor);
				
		
		borderPane.setCenter(c);
		
		borderPane.setBottom(hBox);

		Scene scene = new Scene(borderPane, width, height);
	    primaryStage.setTitle("HTree"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage

	}

	public void blueColor(ActionEvent e){
		c.setStroke(Color.NAVY);
		c.setFill(Color.BLUE);
	}
	class Increase implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if (c.getRadius() < borderPane.getWidth()){
				c.setRadius(c.getRadius() + 5);
				c.setStroke(Color.BLACK);
				c.setFill(Color.YELLOW);
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}
