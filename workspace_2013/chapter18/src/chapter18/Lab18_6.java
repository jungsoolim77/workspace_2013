package chapter18;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Lab18_6 extends Application {
	BorderPane bp = new BorderPane();
	int WIDTH = 400, HEIGHT = 200;
	TextField tf = new TextField();
	TextArea text = new TextArea(" ");
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox hBox = new HBox();
		
		hBox.getChildren().addAll(new Label("Please enter i >= 1 "), tf);
		
		tf.setOnAction(this::getSum);
		bp.setBottom(hBox);
		bp.setCenter(text);

		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		primaryStage.setTitle("Sum serise");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public void getSum(ActionEvent e){
		text.setText("");
		double m = sumM(Integer.parseInt(tf.getText()));
		text.appendText(" m(i) = " + Double.toString(m));
	}
	public double sumM(int i){
		text.appendText("sumM (" + i + ") was called" + "\n");
		
		if (i == 1 )
			return (double) i/(i + 1);
		else 
			return (double) i/(i + 1) + sumM(i - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}
