package samplePKG;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.paint.*;

public class ReviewFX extends Application {
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
		
		bt.setOnAction(this::draw);
		
		Scene scene = new Scene(bp,400,400);
		primaryStage.setTitle("This is my title");
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}
	
	public void draw(ActionEvent e){
		pane.getChildren().clear();
		Line line1 = new Line(10,10, 10, 50);
		Line line2 = new Line(30,10,30,50);
		line1.setStrokeWidth(5);
		line2.setStrokeWidth(5);
//		line1.setStroke(Color.GREEN);
		pane.getChildren().addAll(line1, line2);
	}
	public static void main(String[] args){
		launch(args);
	}

}
