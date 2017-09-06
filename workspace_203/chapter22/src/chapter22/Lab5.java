package chapter22;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lab5 extends Application {

	BorderPane bp = new BorderPane();
	TextField tf = new TextField();
	TextArea ta = new TextArea();
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		VBox hBox = new VBox();
	    hBox.getChildren().addAll(new Label("Enter numbers separated by space "), tf);
	    hBox.setAlignment(Pos.CENTER);

	    bp.setTop(hBox);
//		tf.setPrefColumnCount(20);
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		bp.setCenter(ta);
		
		tf.setOnAction(this::getOrder);
		Scene scene = new Scene(bp, 600,200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Review");
		primaryStage.show();
		
	}
	public void getOrder(ActionEvent e){
		ta.clear();
		String[] list = tf.getText().split("\\s+");
		HashMap<String, Integer> hm = new HashMap<>();
		for(int i = 0; i < list.length; i++){
			if(hm.containsKey(list[i])){
				hm.put(list[i], hm.get(list[i]) + 1);
				
			}else{
				hm.put(list[i], 1);
			}
		}
			
		Iterator it = hm.values().iterator();
		Integer max = (Integer) it.next();
		while(it.hasNext()){
			Integer temp = (Integer) it.next();
			if(temp.compareTo(max)>0)
				max = temp;
				
		}
		
		ta.appendText(max.toString());
//		Iterator it = values.iterator();
		
		
	}
	public void main(String[] args){
		Application.launch(args);
	}
	
	
}
