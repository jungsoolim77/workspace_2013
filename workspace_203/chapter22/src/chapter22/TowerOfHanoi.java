package chapter22;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TowerOfHanoi extends Application {
	BorderPane bp = new BorderPane();
	TextField tf = new TextField();
	TextArea ta = new TextArea();
	int totalNumOfCalls = 0;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox hBox = new HBox(10);
	    hBox.getChildren().addAll(new Label("Enter an order: "), tf);
	    hBox.setAlignment(Pos.CENTER);

	    bp.setTop(hBox);
		tf.setPrefColumnCount(4);
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		bp.setCenter(ta);
		ta.setFont(Font.font(20));

		tf.setOnAction(this::getOrder);
		Scene scene = new Scene(bp, 400,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tower of Hanoi");
		primaryStage.show();
		
	}

	public void getOrder(ActionEvent e){
		ta.clear();
		totalNumOfCalls = 0;
		moveDisks(Integer.parseInt(tf.getText()), 'A','B','C');
		ta.appendText("total number of moveDisks call is " + totalNumOfCalls);
	}
	
	public void moveDisks(int n, char fromTower, char toTower, char auxTower){
		totalNumOfCalls++;
		if(n==1){
			ta.appendText("Move disk " + n + " from " + fromTower +
					" to " + toTower + "\n");
		}else{
			moveDisks(n-1, fromTower, auxTower, toTower);
			ta.appendText("Move disk " + n + " from " + fromTower + 
					" to " + toTower + "\n");
			moveDisks(n-1, auxTower, toTower, fromTower);
		}
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Application.launch(args);
	}

}
