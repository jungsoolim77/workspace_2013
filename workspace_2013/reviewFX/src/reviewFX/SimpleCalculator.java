package reviewFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {
	BorderPane bp = new BorderPane();
	HBox buttonHBox = new HBox();
	HBox inputHBox = new HBox();
	static int WIDTH = 300, HEIGHT = 200;
	Button[] buttons = new Button[4];
	TextField[] tf = new TextField[3];
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		buttons[0] = new Button("Add");
		buttons[1] = new Button("Subtract");
		buttons[2] = new Button("Multiply");
		buttons[3] = new Button("Division");
		
		for(int i=0; i<buttons.length; i++){
			buttonHBox.getChildren().add(buttons[i]);
//			Event handler
			buttons[i].setOnAction(this::compute);
		}
		
		for(int i=0; i<tf.length; i++){
			tf[i] = new TextField();
		}
		inputHBox.getChildren().addAll(new Label("Num 1 "), tf[0],
				new Label("Num 2 "), tf[1],
				new Label("Answer "), tf[2]);
		bp.setBottom(buttonHBox);
		bp.setCenter(inputHBox);
		
		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Simple Calculator");
		primaryStage.show();
		
	}
	
	public void compute(ActionEvent e){
		Double num1 = Double.parseDouble(tf[0].getText());
		Double num2 = Double.parseDouble(tf[1].getText());
		
		if(e.getSource().equals(buttons[0])){
		//for add
			tf[2].setText(Double.toString(num1 + num2));
		}else if(e.getSource().equals(buttons[1])){
		//for subtract
			tf[2].setText(Double.toString(num1 - num2));
		}else if(e.getSource().equals(buttons[2])){
		//for multiply
			tf[2].setText(Double.toString(num1 * num2));
		}else if(e.getSource().equals(buttons[3])){
		//for multiply
			if(num2!=0){
				tf[2].setText(Double.toString(num1 / num2));
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}
