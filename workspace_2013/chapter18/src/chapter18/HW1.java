package chapter18;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class HW1 extends Application {
	BorderPane bp = new BorderPane();
	Button dec = new Button(" - ");
	Button inc = new Button(" + ");
	HTreePane pane = new HTreePane();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		inc.setOnAction(this::increase);
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(dec, inc);
		bp.setCenter(pane);
		bp.setBottom(hbox);
		Scene scene = new Scene(bp, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("My HTree");
		primaryStage.show();
		
		scene.widthProperty().addListener(ov -> pane.paint());
	    scene.heightProperty().addListener(ov -> pane.paint());
	}
	
	public void increase(ActionEvent e){
		pane.setOrder(1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Application.launch(args);
	}

}

class HTreePane extends Pane{
	private int order = 0;
	
	public void setOrder(int diff){
		this.order += diff;
		if(this.order<0){
			this.order = 0;
		}
//		this.getChildren().clear();
		paint();
	}
	
	public void paint(){
		this.getChildren().clear();
		Point2D p = new Point2D(getWidth()/2, getHeight()/2);
		double size = (p.getX()>p.getY()? p.getX(): p.getY());
		display(order, p, size);
		
	}
	
	public void display(int order, Point2D p, double size){
		if(order>=0){
			double nextSize = size/2;
			Point2D p1 = new Point2D(p.getX()-nextSize,
					p.getY()-nextSize);
			Point2D p2 = new Point2D(p.getX()-nextSize,
					p.getY()+nextSize);
			Point2D p3 = new Point2D(p.getX()+nextSize,
					p.getY()-nextSize);
			Point2D p4 = new Point2D(p.getX()+nextSize,
					p.getY()+nextSize);
			
			
			Line hline = new Line(p.getX()-nextSize, p.getY(),
					p.getX()+ nextSize, p.getY());
			Line vLline = new Line(p1.getX(), p1.getY(),
					p2.getX(), p2.getY());
			Line vRLine = new Line(p3.getX(), p3.getY(),
					p4.getX(), p4.getY());
			
			this.getChildren().addAll(hline, vLline, vRLine);
			
			display(order -1, p1, nextSize);
			display(order -1, p2, nextSize);
			display(order -1, p3, nextSize);
			display(order -1, p4, nextSize);
		}
		
	}
	
}
