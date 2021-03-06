package review202;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Runner extends Application {

	BorderPane bp;
	TextField tf;
	Button bt;
	Pane pane;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
bp = new BorderPane();
		
		tf = new TextField();
		bt = new Button("Enter order");
		pane = new Pane();
		HBox hb = new HBox();
		hb.getChildren().addAll(tf,bt);
		bp.setBottom(hb);
		bp.setCenter(pane);

//		anonymous class
//
//		bt.setOnAction(new EventHandler<ActionEvent>(){
//			@Override
//			public void handle(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				int count = Integer.parseInt(tf.getText());
//				if (count > 0){
//					pane.getChildren().clear();
//					paint(count);
//				}
//			}
//			
//		});

//		lambda function
//		
//		bt.setOnAction(e -> {
//			int count = Integer.parseInt(tf.getText());
//			if (count > 0){
//				pane.getChildren().clear();
//				paint(count);
//			}
//		});
//		
//		method resolution 
		
		bt.setOnAction(this::draw);	
		
		Scene scene = new Scene(bp,400,400);
		primaryStage.setTitle("This is my title");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	
	public void paint(int count){
		if(count > 0){
			Line line = new Line(count * 10 , count * 10, count * 5, count * 10);
			line.setStrokeWidth(3);
			pane.getChildren().add(line);
			paint(count-1);
		}
	}
	
	public void draw(ActionEvent e){
		int count = Integer.parseInt(tf.getText());
		if (count > 0){
			pane.getChildren().clear();
			paint(count);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}
