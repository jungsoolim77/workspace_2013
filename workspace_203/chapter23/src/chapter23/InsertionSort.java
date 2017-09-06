package chapter23;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InsertionSort extends Application{
	BorderPane bp = new BorderPane();
	int WIDTH = 700, HEIGHT = 200;
	TextField tf = new TextField();
	TextField key = new TextField();
	TextArea text = new TextArea(" ");
	Button btStep = new Button("Sort");
	Button btReset = new Button("Reset");
	
	
public void start(Stage primaryStage){
	HBox hBox = new HBox();
	Insets inset = new Insets(0, 20, 0, 20);
	hBox.setPadding(new Insets(5,5,5,5));
	HBox.setMargin(tf, inset);
	HBox.setMargin(key, inset);
	
	//hBox.getChildren().addAll(new Label("Please enter numbers to sort from 1 to 10. "), tf, new Label("Please enter a key"), key);
	hBox.getChildren().addAll(btStep, btReset, tf);
	
	//StepControl control = new StepControl();
	//HistogramPane pane = new HistogramPane();
	
	
	//tf.setOnAction(this::action);
	//key.setOnAction(this::action);
	bp.setBottom(hBox);
	BorderPane.setAlignment(hBox, Pos.CENTER);
	//bp.setCenter(pane);
	tf.setOnAction(this::sort);
	Scene scene = new Scene(bp, WIDTH, HEIGHT);
	primaryStage.setTitle("Insertion Sort");
	primaryStage.setScene(scene);
	primaryStage.show();
	
	
	//pane.widthProperty().addListener(ov -> pane.repaint()); 
    //pane.heightProperty().addListener(ov -> pane.repaint());
    /*
    btStep.setOnAction(e -> {    
        if (control.step())
          pane.setColoredBarIndex(control.getCurrentIndex());
        else
          tf.setText("The array is already sorted");
      });
      
      btReset.setOnAction(e -> {    
        control.reset();
        pane.setColoredBarIndex(-1);
        tf.setText("");
      });
      */
}



	public void sort(ActionEvent e) {
		
}
	
public static <E extends Comparable<E>> void sort(E[] list) {
	  for (int i = 1; i < list.length; i++) {
	      /** insert list[i] into a sorted sublist list[0..i-1] so that
	           list[0..i] is sorted. */
	      E currentElement = list[i];
	      int k;
	      for (k = i - 1; k >= 0 && list[k].compareTo(currentElement) > 0; k--) {
	        list[k + 1] = list[k];
	      }

	      // Insert the current element into list[k+1]
	      list[k + 1] = currentElement;
	    }
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}

/*

class HistogramPane extends Pane {
    private int[] numbers;
    private int coloredBarIndex = -1;

    public void setNumbers(int[] numbers) {
      this.numbers = numbers;
      repaint();
    }

    public void setColoredBarIndex(int index) {
      coloredBarIndex = index;
      repaint();
    }

    public void repaint() {
      // Find maximum integer
      int max = numbers[0];
      for (int i = 1; i < numbers.length; i++) {
        if (max < numbers[i]) {
          max = numbers[i];
        }
      }

      this.getChildren().clear();
      
      double height = getHeight() * 0.88;
      double width = getWidth() - 20;
      double unitWidth = width * 1.0 / numbers.length;
      for (int i = 0; i < numbers.length; i++) {
        Rectangle bar =  new Rectangle(i * unitWidth + 10, getHeight()
          - (numbers[i] * 1.0 / max) * height, unitWidth, (numbers[i] * 1.0 / max) * height);
        bar.setFill(Color.WHITE);
        bar.setStroke(Color.BLACK);
        this.getChildren().add(bar);
        this.getChildren().add(new Text(i * unitWidth + 10 + 10,
          getHeight() - (numbers[i] * 1.0 / max) * height - 10,
          numbers[i] + ""));
      }

      if (coloredBarIndex >= 0) {
        int i = coloredBarIndex;
        Rectangle filledRectangle = new Rectangle(i * unitWidth + 10, getHeight()
          - (numbers[i] * 1.0 / max) * height, unitWidth, (numbers[i] * 1.0 / max) * height);
        filledRectangle.setFill(Color.RED);
        this.getChildren().add(filledRectangle);
      }
    }
  }

class StepControl {
	public final int ARRAY_SIZE = 20;
    private int[] list = new int[ARRAY_SIZE];
    
    public int[] getArray() {
      return list;
    }
    
    StepControl() {
      initializeNumbers();
    }
    
    public void initializeNumbers() {
      for (int i = 0; i < list.length; i++) {
        list[i] = i + 1;
      }
  
      // Random shuffle
      for (int i = 0; i < list.length; i++) {
        int index = (int)(Math.random() * ARRAY_SIZE);
        int temp = list[i];
        list[i] = list[index];
        list[index] = temp;
      }
    }
    
    private int i = 0;
    
    public int getCurrentIndex() {
      return i - 1;
    }
    
    public void reset() {
      i = 0;
      initializeNumbers();
    }
    
    public boolean step() {      
      if (i > list.length - 1) return false;
      
      // Find the minimum in the list[i..list.length-1]
      int currentMin = list[i];
      int currentMinIndex = i;

      for (int j = i + 1; j < list.length; j++) {
        if (currentMin > list[j]) {
          currentMin = list[j];
          currentMinIndex = j;
        }
      }

      // Swap list[i] with list[currentMinIndex] if necessary;
      if (currentMinIndex != i) {
        list[currentMinIndex] = list[i];
        list[i] = currentMin;
      }

      i++; // Increase step
      
      return true;
    }
  }
*/