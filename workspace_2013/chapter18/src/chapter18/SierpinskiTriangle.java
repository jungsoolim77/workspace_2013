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
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class SierpinskiTriangle extends Application {
	BorderPane bp = new BorderPane();
	SierpinskiTrianglePane pane = new SierpinskiTrianglePane();
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

class SierpinskiTrianglePane extends Pane{
	private int order = 0;
	
	public void setOrder(int diff){
		this.order += diff;
		this.order = (this.order>=0? this.order: 0);
		
		paint();
	}
	
	public SierpinskiTrianglePane(){
		
	}
	protected void paint(){
		double width = getWidth();
		double height = getHeight();
		Point2D p1 = new Point2D(width/2, 10);
		Point2D p2 = new Point2D(10, height - 10);
		Point2D p3 = new Point2D(width - 10, height - 10);
		this.getChildren().clear();
				
		drawTriangles(order, p1, p2, p3);
		
	}
	
	protected void drawTriangles(int order, Point2D p1, Point2D p2, Point2D p3){
		if(order == 0){
			Polygon triangle = new Polygon();
			triangle.getPoints().addAll(p1.getX(), p1.getY(),
					p2.getX(), p2.getY(), p3.getX(), p3.getY());
			triangle.setStroke(Color.BLACK);
			triangle.setStroke(Color.WHITE);
			this.getChildren().add(triangle);
			
		}else{
//			Get points for next order
			Point2D p12 = p1.midpoint(p2);
			Point2D p23 = p2.midpoint(p3);
			Point2D p31 = p3.midpoint(p1);
			
//			recursive call
			drawTriangles(order-1, p1, p12, p31);
			drawTriangles(order-1, p12, p2, p23);
			drawTriangles(order-1, p31, p23, p3);
			}
		
	}
}
