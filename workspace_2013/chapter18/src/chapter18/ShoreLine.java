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
import javafx.scene.shape.Line;
import javafx.stage.Stage;




public class ShoreLine extends Application {
		 
		  ShoreLinePane shorelinePane = new ShoreLinePane(); 
		  TextField tfOrder = new TextField(); 
		  @Override // Override the start method in the Application class
		  public void start(Stage primaryStage) {       
		    
//		    tfOrder.setOnAction(
//		      e ->  shorelinePane.setOrder(Integer.parseInt(tfOrder.getText())));
		    
			tfOrder.setOnAction(this::setMyOrder);
		   
			tfOrder.setPrefColumnCount(4);
		    tfOrder.setAlignment(Pos.BOTTOM_RIGHT);

		    // Pane to hold label, text field, and a button
		    HBox hBox = new HBox(10);
		    hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
		    hBox.setAlignment(Pos.CENTER);
		    
		    BorderPane borderPane = new BorderPane();
		    borderPane.setCenter(shorelinePane);
		    borderPane.setBottom(hBox);
		        
		    // Create a scene and place it in the stage
		    Scene scene = new Scene(borderPane, 400, 410);
		    primaryStage.setTitle("Shoreline Paradox"); // Set the stage title
		    primaryStage.setScene(scene); // Place the scene in the stage
		    primaryStage.show(); // Display the stage
		    
		    scene.widthProperty().addListener(ov -> shorelinePane.paint());
		    scene.heightProperty().addListener(ov -> shorelinePane.paint());
		  }

		  public void setMyOrder(ActionEvent e){
			  shorelinePane.setOrder(Integer.parseInt(tfOrder.getText()));
			  tfOrder.setText("");
			  
		  }
		  /** Pane for displaying fractal */
  static class ShoreLinePane extends Pane {
    private int order = 0;

    /** Set a new order */
    public void setOrder(int order) {
      this.order = order;
      paint();
    }

    ShoreLinePane() {
    }

    protected void paint() {
    	this.getChildren().clear();
    	//using unit 1 as 1/3 of width
    	displayShoreLine(order, this.getWidth(), new Point2D(0,0));
    }

    private void displayShoreLine(int order, double side, Point2D p) {
    	
    	double x = p.getX();
    	double y = p.getY();
    	double side2 = side/2;
    	
      if (order > 0) { 
    	// Recursively display shoreline
    	displayShoreLine(order - 1, side2, new Point2D(x + side2, y));
    	displayShoreLine(order - 1, side2, new Point2D(x, y + side2));
      }
      else{
    	//draw shoreline
      	this.getChildren().add(new Line(x, y + side, x + side/2 , y +side));
      	this.getChildren().add(new Line(x + side/2, y + side, x + side/2, y + side/2));
      	this.getChildren().add(new Line(x + side/2, y + side/2, x + side, y + side/2));  
      	this.getChildren().add(new Line(x + side, y + side/2, x + side, y)); 
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