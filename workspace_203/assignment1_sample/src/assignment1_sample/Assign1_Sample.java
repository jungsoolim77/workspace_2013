package assignment1_sample;

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

public class Assign1_Sample extends Application {

	BorderPane bp = new BorderPane();
	TextField tf = new TextField();
	Pane pane = new Pane();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox hb = new HBox();
		hb.getChildren().addAll(new Label("Please enter an order.  "), 
				tf);
		hb.setAlignment(Pos.CENTER);
		tf.setPrefColumnCount(4);
		tf.setAlignment(Pos.BOTTOM_CENTER);
		bp.setBottom(hb);
		
		tf.setOnAction(this::paint);
		Scene scene = new Scene(bp,400,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("H Tree");
		primaryStage.show();
		
	}

	public void paint(ActionEvent e){
		int order = Integer.parseInt(tf.getText());
		pane.getChildren().clear();
		draw(order, 200, new Point2D(10, 10), new Point2D(10, 100));
		bp.setCenter(pane);
	}
	
	public void draw(int order, int size, Point2D p1, Point2D p2){
		if (order > 0){
			Line line = new Line(p1.getX(), p1.getY(),
					p2.getX(), p2.getY());
			pane.getChildren().add(line);
			draw(order -1, size -10, new Point2D(p1.getX() + 10, p1.getY() +10), 
					new Point2D(p2.getX() + 10, p2.getY() +10));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
