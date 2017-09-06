package reviewFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FirstFX extends Application {
	boolean on = true;
	Circle c = new Circle();
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane bp = new BorderPane();
		Scene scene = new Scene(bp, 400,400);
		
		
		c.setRadius(50);
		c.setStroke(Color.BLACK);
		c.setFill(Color.BEIGE);
		
		Pane p = new Pane();
		c.setCenterX(200);
		c.setCenterY(200);
//		c.centerXProperty().bind(p.widthProperty().divide(2));
//		c.centerYProperty().bind(p.heightProperty().divide(2));
		
		p.getChildren().add(c);
		
		Button b = new Button("Change Color");
		bp.setCenter(p);
		bp.setBottom(b);
//		Event handler Anonymous Inner class
//		b.setOnAction(
//				new EventHandler<ActionEvent>(){
//					public void handle(ActionEvent e){
//						c.setFill(Color.AQUA);
//					}
//				}
//				);
//		Event handler using lambda
		
//		b.setOnAction(e->{
//			if(on){
//				c.setFill(Color.AQUA);
//				on = false;
//			}else{
//				c.setFill(Color.RED);
//				on = true;
//			}
//		});
		
//		Event handler using method resolution
		
		b.setOnAction(this::changeColor);
		
		
//		c.centerXProperty()
		
		primaryStage.setTitle("My First Java FX");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public void changeColor(ActionEvent e){
		if(on){
			c.setFill(Color.AQUA);
			on = false;
		}else{
			c.setFill(Color.RED);
			on = true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
