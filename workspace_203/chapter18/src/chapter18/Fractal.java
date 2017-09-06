package chapter18;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;




public class Fractal extends Application {
		 
		  SquarePane squarePane = new SquarePane(); 
		  TextField tfOrder = new TextField(); 
		  @Override // Override the start method in the Application class
		  public void start(Stage primaryStage) {       
		    
//		    tfOrder.setOnAction(
//		      e ->  squarePane.setOrder(Integer.parseInt(tfOrder.getText())));
		    
			tfOrder.setOnAction(this::setMyOrder);
		   
			tfOrder.setPrefColumnCount(4);
		    tfOrder.setAlignment(Pos.BOTTOM_RIGHT);

		    // Pane to hold label, text field, and a button
		    HBox hBox = new HBox(10);
		    hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
		    hBox.setAlignment(Pos.CENTER);
		    
		    BorderPane borderPane = new BorderPane();
		    borderPane.setCenter(squarePane);
		    borderPane.setBottom(hBox);
		        
		    // Create a scene and place it in the stage
		    Scene scene = new Scene(borderPane, 400, 410);
		    primaryStage.setTitle("Fractal square"); // Set the stage title
		    primaryStage.setScene(scene); // Place the scene in the stage
		    primaryStage.show(); // Display the stage
		    
		    scene.widthProperty().addListener(ov -> squarePane.paint());
		    scene.heightProperty().addListener(ov -> squarePane.paint());
		  }

		  public void setMyOrder(ActionEvent e){
			  squarePane.setOrder(Integer.parseInt(tfOrder.getText()));
			  tfOrder.setText("");
			  
		  }
		  /** Pane for displaying fractal */
  static class SquarePane extends Pane {
    private int order = 0;

    /** Set a new order */
    public void setOrder(int order) {
      this.order = order;
      paint();
    }

    SquarePane() {
    }

    protected void paint() {
    	this.getChildren().clear();
    	this.setStyle("-fx-background-color: black;");
    	//using unit 1 as 1/3 of width
    	displaysquare(order, this.getWidth(), new Point2D(this.getWidth()/2, this.getHeight()/2));
    }

    private void displaysquare(int order, double side, Point2D p) {
    	
    	double x = p.getX();
    	double y = p.getY();
    	
    	double width = side/3;
    	
    	//draw square
    	Rectangle rect = new Rectangle(x - width/2, y - width/2, width, width);
    	rect.setFill(Color.WHITE);
    	this.getChildren().add(rect);
    	
    	
    	   
      if (order > 0) { 
    	// Recursively display H-square on lines
    	double side2 = side/2;
    	displaysquare(order - 1, width, new Point2D(x - width, y - width));
    	displaysquare(order - 1, width, new Point2D(x - width, y));
    	displaysquare(order - 1, width, new Point2D(x - width, y + width));
    	displaysquare(order - 1, width, new Point2D(x, y - width));
    	displaysquare(order - 1, width, new Point2D(x, y + width));
    	displaysquare(order - 1, width, new Point2D(x + width, y - width));
    	displaysquare(order - 1, width, new Point2D(x + width, y));
    	displaysquare(order - 1, width, new Point2D(x + width, y + width));
      }
      
    }
    
  }
		  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}