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

public class HilbertCurve extends Application {
	final static int PADDING = 10; 
	final static int SIZE = 400;
	BorderPane bp = new BorderPane();
	Pane pane = new Pane();
	TextField tf = new TextField();
	private double x, y; // U shape center 
    private double length; // length of a U side. Dynamically determined based on order
    private int order = 1;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox hb = new HBox();
		tf.setPrefColumnCount(4);
		tf.setAlignment(Pos.BOTTOM_CENTER);
		hb.getChildren().addAll(new Label("Enter order    "), tf);
		hb.setAlignment(Pos.CENTER);
		bp.setBottom(hb);
		tf.setOnAction(this::drawCurve);
		Scene scene = new Scene(bp, SIZE, SIZE);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hilbert Curve");
		primaryStage.show();
		
		scene.widthProperty().addListener(ov -> paint(order));
	    scene.heightProperty().addListener(ov -> paint(order));

	}
	
	public void drawCurve(ActionEvent e){
		order = Integer.parseInt(tf.getText());
		paint(order);
	}


	public void paint(int order){
		length = Math.min(bp.getWidth(), bp.getHeight());
	      for (int i = 0; i < order; i++)
	        length /= 2;
	      
	      // Reset start cursor position
	      x = length / 2; y = length / 2 - PADDING;
	      
	      pane.getChildren().clear(); // Clear the pane before redisplay

	      upperU(order); // Start recursion
		bp.setCenter(pane);
	}

	/** Display upper U */
    private void upperU(int order) {
      if (order > 0) {
        leftU(order - 1);
        lineNewPosition(0, length);
        upperU(order - 1);
        lineNewPosition(length, 0);
        upperU(order - 1);
        lineNewPosition(0, -length);
        rightU(order - 1);
      }
    }

    /** Display left U */
    private void leftU(int order) {
      if (order > 0) {
        upperU(order - 1);
        lineNewPosition(length, 0);
        leftU(order - 1);
        lineNewPosition(0, length);
        leftU(order - 1);
        lineNewPosition(-length, 0);
        downU(order - 1);
      }
    }

    /** Display right U */
    private void rightU(int order) {
      if (order > 0) {
        downU(order - 1);
        lineNewPosition(-length, 0);
        rightU(order - 1);
        lineNewPosition(0, -length);
        rightU(order - 1);
        lineNewPosition(length, 0);
        upperU(order - 1);
      }
    }

    /** Display down U */
    private void downU(int order) {
      if (order > 0) {
        rightU(order - 1);
        lineNewPosition(0, -length);
        downU(order - 1);
        lineNewPosition(-length, 0);
        downU(order - 1);
        lineNewPosition(0, length);
        leftU(order - 1);
      }
    }

    /** Draw a line from the current position to the new relative position */
    public void lineNewPosition(double deltaX, double deltaY) {
      pane.getChildren().add(new Line(x, y, x + deltaX, y + deltaY));
      x += deltaX;
      y += deltaY;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
