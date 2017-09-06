package chapter22;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConvexHull extends Application {  
  double radius = 2;
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {     
    Pane pane = new View();
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 400, 250);
    primaryStage.setTitle("Convex Hull"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
    
  private Polygon polygon = new Polygon();
        
  class View extends Pane {
    View() {
      Rectangle rectangle = new Rectangle(20, 10, 140, 60);
      rectangle.setFill(Color.WHITE);
      rectangle.setStroke(Color.BLACK);
      Text text = new Text(30, 30, 
        "INSTRUCTION\nAdd: Left Click\nRemove: Right Click");
      Rectangle boundingRectangle = new Rectangle();
      boundingRectangle.setFill(Color.WHITE);
      boundingRectangle.setStroke(Color.BLACK);

      polygon.setFill(Color.WHITE);
      polygon.setStroke(Color.BLACK);
      
      getChildren().addAll(rectangle, text, boundingRectangle, polygon);
      
      this.setOnMouseClicked(e -> { 
        if (e.getButton() == MouseButton.PRIMARY) { // Left button clicked       
          Circle circle = new Circle(e.getX(), e.getY(), 5);
          getChildren().add(circle);
          drawNewPolygon();
        }
        else if (e.getButton() == MouseButton.SECONDARY) { // Right button clicked
          ObservableList<Node> list = getChildren();
          for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Circle && list.get(i).contains(e.getX(), e.getY())) {
              list.remove(i);
            }
          }
          
          drawNewPolygon();
        }
      });
    }
    
    protected void drawNewPolygon() {     
      // Gather all points
      ObservableList<Node> list = getChildren();
      List<Circle> listOfCircle = new ArrayList<>();
      
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i) instanceof Circle) {
          listOfCircle.add((Circle)(list.get(i)));
        }
      }
      
      polygon.getPoints().clear(); // Clear the polygon to start a new polygon
              
      // Draw the polygon
      if (listOfCircle.size() >= 3) {
        double[][] points = new double[listOfCircle.size()][2];

        for (int i = 0; i < points.length; i++) {
          points[i][0] = listOfCircle.get(i).getCenterX();
          points[i][1] = listOfCircle.get(i).getCenterY();
        }
        
        ArrayList<ConvexPoints.MyPoint> listOfPoints = ConvexPoints.getConvexHull(points);
        for (int i = 0; i < listOfPoints.size(); i++) {
          polygon.getPoints().addAll(listOfPoints.get(i).x, listOfPoints.get(i).y);
        }
      }
    }
  }
}

class ConvexPoints {
	  public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);

	    System.out.print("How many points are in the set? ");
	    int numberOfPoints = input.nextInt();
	    
	    double[][] p = new double[numberOfPoints][2];    
	    System.out.print("Enter " + p.length + " points: ");
	    for (int i = 0; i < p.length; i++)
	      for (int j = 0; j < p[i].length; j++) 
	        p[i][j] = input.nextDouble();
	    
	    ArrayList<MyPoint> list = getConvexHull(p);
	    
	    System.out.print("The convex hull is ");
	    for (int i = 0; i < list.size(); i++) {
	      System.out.print("(" + list.get(i).x + ", " + list.get(i).y + ") ");
	    }
	  }

	  static class MyPoint {
	    double x, y; 
	    
	    MyPoint(double x, double y) {
	      this.x = x; this.y = y;
	    }
	    
	    public boolean equals(Object o) {
	      return x == ((MyPoint)o).x && y == ((MyPoint)o).y;
	    }
	  }
	  
	  /** Return the points that form a convex hull */
	  public static ArrayList<MyPoint> getConvexHull(double[][] s) {
	    // For efficiency, create an array of objects 
	    MyPoint[] myPoints = new MyPoint[s.length];
	    for (int i = 0; i < myPoints.length; i++)
	      myPoints[i] = new MyPoint(s[i][0], s[i][1]);
	    
	    // Step 1
	    MyPoint h0 = getRightmostLowestPoint(myPoints);
	    ArrayList<MyPoint> H = new ArrayList<MyPoint>();
	    H.add(h0);
	    
	    MyPoint t0 = h0;
	        
	    // Step 2 and Step 3
	    while (true) {   
	      // Step 2
	      MyPoint t1 = myPoints[0]; // Let t1 be s0
	      for (int i = 1; i < myPoints.length; i++) {
	        double status = whichSide(t0.x, t0.y, t1.x, t1.y, myPoints[i].x, myPoints[i].y);
	        
	        if (status > 0)  // Right side of the line. Please note we are using the Java coordinate system. y increases downward
	          t1 = myPoints[i];
	        else if (status == 0) {
	          if (distance(s[i][0], s[i][1], t0.x, t0.y) > distance(t1.x, t1.y, t0.x, t0.y)) 
	            t1 = myPoints[i];
	        }
	      }
	      
	      // Step 3
	      if (t1.equals(h0))   // (t1.x == h0.x && t1.y == h0.y) 
	        break; // A convex hull is found
	      else {
	        H.add(t1);
	        t0 = t1;
	      }       
	    }
	    
	    return H;
	  }
	  
	  /** Return the rightmost lowest point in S */ 
	  private static MyPoint getRightmostLowestPoint(MyPoint[] p) {
	    int rightMostIndex = 0;
	    double rightMostX = p[0].x;
	    double rightMostY = p[0].y;
	    
	    for (int i = 1; i < p.length; i++) {
	      if (rightMostY < p[i].y) {
	        rightMostY = p[i].y;
	        rightMostX = p[i].x;
	        rightMostIndex = i;
	      }
	      else if (rightMostY == p[i].y && rightMostX < p[i].x) {
	        rightMostX = p[i].x;
	        rightMostIndex = i;
	      }
	    }      
	    
	    return p[rightMostIndex];
	  }
	  
	  public static double distance(double x1, double y1, double x2, double y2) {
	    return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	  }
	  
	  static double whichSide(double x0, double y0, double x1, double y1, double x2, double y2) {
	    return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
	  }
	}


