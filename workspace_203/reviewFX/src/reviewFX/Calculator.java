package reviewFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Calculator extends Application {
	static int WIDTH =300, HEIGHT = 100;
	Button[] buttons = new Button[4];
	TextField[] tf = new TextField[3];
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane bp = new BorderPane();
		HBox inputHBox = new HBox();
		HBox buttonHBox = new HBox();
		
		buttons[0] = new Button("Add");
		buttons[1] = new Button("Subtract");
		buttons[2]= new Button("Multiply");
		buttons[3] = new Button("Division");
		
		for(int i = 0; i < buttons.length; i++){
			buttonHBox.getChildren().add(buttons[i]);
		}
		
		for(int i=0; i < tf.length; i++){
			tf[i] = new TextField();
			
		}
		
		inputHBox.getChildren().addAll(new Label("Number 1 "),tf[0], 
				new Label("Number 2 "), tf[1], 
				new Label("Answer "), tf[2]);
		bp.setCenter(inputHBox);
		bp.setBottom(buttonHBox);
		
		buttons[0].setOnAction(this::compute);
		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		primaryStage.setTitle("Simple Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}

	public void compute(ActionEvent e){
		Integer n1 = Integer.parseInt(tf[0].getText());
		Integer n2 = Integer.parseInt(tf[1].getText());
		if(e.getSource().equals(buttons[0])){
			tf[2].setText(Integer.toString(n1+n2));
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
