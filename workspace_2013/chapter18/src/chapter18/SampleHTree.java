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

public class SampleHTree extends Application {
	BorderPane bp = new BorderPane();
	MyHTree pane = new MyHTree();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		 
		HBox hbox = new HBox();
		Button dec = new Button("-");
		Button inc = new Button("+");
		dec.setOnAction(this::decreaseOrder);
		inc.setOnAction(this::increaseOrder);
		
		hbox.getChildren().addAll(dec,inc);
		hbox.setAlignment(Pos.CENTER);
		
		bp.setCenter(pane);
		bp.setBottom(hbox);
		Scene scene = new Scene(bp, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Fractal Frame Work...");
		primaryStage.show();
		
		scene.widthProperty().addListener(ov -> pane.paint());
	    scene.heightProperty().addListener(ov -> pane.paint());
	}
	public void decreaseOrder(ActionEvent e){
		pane.setOrder(-1);
	}
	
	public void increaseOrder(ActionEvent e){
		pane.setOrder(1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}

class MyHTree extends Pane{
	private int order = 0;
	
	public void setOrder(int diff){
		this.order += diff;
		this.order = (this.order>=0? this.order: 0);
		
		paint();
	}
	
	public MyHTree(){
		
	}
	protected void paint(){
		double width = getWidth();
		double height = getHeight();
		Point2D p = new Point2D(width/2, height/2);
		double size = (width>height? height/2:width/2);
		this.getChildren().clear();
		drawMyTree(order, size, p);
		
	}
	
	protected void drawMyTree(int order, double size, Point2D p){
		if(order >= 0){
			double nextSize = size/2;
			Point2D p1 = new Point2D(p.getX() - nextSize, p.getY()-nextSize);
			Point2D p2 = new Point2D(p.getX() + nextSize, p.getY()-nextSize);
			Point2D p3 = new Point2D(p.getX() - nextSize, p.getY()+nextSize);
			Point2D p4 = new Point2D(p.getX() + nextSize, p.getY()+nextSize);
			
//			draw tree lines
			Line hline = new Line(p.getX()-nextSize, p.getY(),
					p.getX()+nextSize, p.getY());
			
			Line vLline = new Line(p1.getX(), p1.getY(),
					p3.getX(), p3.getY());
			
			Line vRline = new Line(p2.getX(), p2.getY(),
					p4.getX(), p4.getY());
			this.getChildren().addAll(hline, vLline, vRline);
//			recursive call
			drawMyTree(order-1, nextSize, p1);
			drawMyTree(order-1, nextSize, p2);
			drawMyTree(order-1, nextSize, p3);
			drawMyTree(order-1, nextSize, p4);
			
		}
		
	}
}
