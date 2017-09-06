package chapter23;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SortTest extends Application {
BorderPane bp = new BorderPane();
TextArea ta = new TextArea();
TextField input = new TextField();
Button[] b = new Button[5];
Button test = new Button("Generic Sort Test");

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		
		HBox hb = new HBox();
		VBox vb = new VBox();
		bp.setTop(ta);
		vb.getChildren().add(new  Text("Please enter your input seperated by a space."));
		vb.getChildren().add(input);
		bp.setCenter(vb);
		b[0] = new Button("Bubble");
		b[1] = new Button("Merge");
		b[2] = new Button("Heap");
		b[3] = new Button("Sort Circle");
		b[4] = new Button("Sort Rectangle");
				
		for(int i = 0; i< b.length; i++){
			hb.getChildren().add(b[i]);
			b[i].setOnAction(this::sort);
		}
		
		hb.getChildren().add(test);
		test.setOnAction(this::testSort);
		HBox.setMargin(hb, new Insets(10,10,10,10));

		bp.setBottom(hb);
		BorderPane.setAlignment(bp, Pos.CENTER);
		
		Scene scene = new Scene(bp, 450, 250);
	    primaryStage.setTitle("Sort Example"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); 
	   

	}
	
	public void sort(ActionEvent e){
		String[] in = input.getText().split("\\s+");
		Double[] numbers = new Double[in.length];
		MyCircle[] circles = new MyCircle[in.length];
		MyRectangle[] rectangles = new MyRectangle[in.length/2];
		
		ta.clear();		
		try{
			for(int i = 0; i < in.length; i++){
				numbers[i] = Double.parseDouble(in[i]);
			}
			
			if(e.getSource().equals(b[0])){
				bubbleSort(numbers);
			}else if(e.getSource().equals(b[1])){
				mergeSort(numbers);
			}else if(e.getSource().equals(b[2])) {
				heapSort(numbers);
			}else if (e.getSource().equals(b[3])) {
				//create circle and sort them
				
				for(int i = 0; i< numbers.length; i++){
					circles[i] = new MyCircle(numbers[i]);
				}
				mergeSort(circles);
			}else if (e.getSource().equals(b[4])){
				//please implement rectangle
				int index =0;
				for(int i = 0; i < in.length; i= i+2){
					rectangles[index] = new MyRectangle(numbers[i], numbers[i+1]);
					index++;
				}
				mergeSort(rectangles);
			}
			
			if(e.getSource().equals(b[3])){
				//output for circle
				for(int i = 0; i < circles.length; i++){
					ta.appendText(String.format("%.2f", circles[i].getArea()));
					//ta.appendText( circles[i].getArea().toString());
					ta.appendText("  ");
				}
				
			}
			else if(e.getSource().equals(b[4])){
				//output for rectangle
				for(int i = 0; i < rectangles.length; i++){
					ta.appendText(String.format("%.2f", rectangles[i].getArea()));
					//ta.appendText( circles[i].getArea().toString());
					ta.appendText("  ");
				}
				
			}else{
				//number sort
				for(int i = 0; i < numbers.length; i++){
					ta.appendText(numbers[i].toString());
					ta.appendText("  ");
				}
			}
			
			
		}catch(Exception ex){
			//this is string
			if(e.getSource().equals(b[1])){
				mergeSort(in);
			}else{
				heapSort(in);
			}
			
			
			for(int i = 0; i < numbers.length; i++){
				ta.appendText(in[i].toString());
				ta.appendText("  ");
			}
		}
		
		//when you finish implement, please remove this 
		if(e.getSource().equals(b[4])){
			//ta.appendText("Please implement rectangle.  ");
		}
		
	}
	
	public void testSort(ActionEvent e){
		Comparable[] list1 = {99, 2, 31, 7, 4, 56, 43, 54};
		Comparable[] list2 = {"cat", "dog", "fish", "an"};
		Comparable[] list3 = { new MyCircle(3.0), new MyCircle(2.0), new MyCircle(1.0)};
		MyGeometricObject[] list4 = { new MyCircle(3.0), new MyCircle(2.0), new MyCircle(1.0)};
		MyGeometricObject[] list5 = { new MyCircle(3.0), new MyRectangle(1.0, 2.0),  
				new MyCircle(2.0), new MyRectangle(3.0, 4.0), new MyCircle(1.0)};
		
//		mergeSort(list1);
		mergeSort(list2);
		mergeSort(list3);
		mergeSort(list4);
		mergeSort(list5);
		heapSort(list1);
		
		
		ta.clear();
		ta.appendText("number sort:   ");
		for(int i = 0; i<list1.length; i++){
			ta.appendText(list1[i].toString() + "  ");
		}
		
		ta.appendText("\n");
		ta.appendText("string sort:  ");
		for(int i = 0; i<list2.length; i++){
			ta.appendText(list2[i].toString() + "  ");
		}
		
		ta.appendText("\n");
		ta.appendText("circle sort from Comparable:  ");
		for(int i = 0; i<list3.length; i++){
			ta.appendText(list3[i].toString() + "  ");
		}
		ta.appendText("\n");
				
		ta.appendText("circle sort from GeometricObject:  ");
		for(int i = 0; i<list4.length; i++){
			ta.appendText(list4[i].toString() + "  ");
		}
		ta.appendText("\n");
		
		ta.appendText("Geomatric object sort from GeometricObject:  ");
		for(int i = 0; i<list5.length; i++){
			ta.appendText(list5[i].toString() + "  ");
		}
	}
	
/**
 * 
 * Please implement bubbleSort
 * public static <E extends Comparable<E>> void bubbleSort(E[] list)
 * 
 * 
 */
	
	public static <E extends Comparable<E>> void bubbleSort(E[] list){
		boolean needNextPass = true;
		
		for(int k = 1; k< list.length && needNextPass; k++){
			needNextPass = false;
			for(int i = 0; i< list.length - k; i++){
				if(list[i].compareTo(list[i +1]) >0){
					E temp = list[i];
					list[i] = list[i+1];
					list[i+1] = temp;
					needNextPass = true;
				}
			}
		}
	}
	
	public static <E extends Comparable<E>> void mergeSort(E[] list){
		if(list.length > 1){
			int firstHalfSize = list.length/2;
			int secondHalfSize = list.length - firstHalfSize;
			E[] firstHalf = (E[]) new Comparable[firstHalfSize];
			E[] secondHalf = (E[]) new Comparable[secondHalfSize];
							
			System.arraycopy(list,0,firstHalf,0,firstHalfSize);
			System.arraycopy(list,firstHalfSize,secondHalf,0,secondHalfSize);
			mergeSort(firstHalf);
			mergeSort(secondHalf);
			merge(firstHalf, secondHalf, list);
		}
	}
	
	public static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] list3){
		int current1 = 0, current2 = 0, current3 = 0;
		
		while(current1<list1.length && current2 < list2.length){
			if(list1[current1].compareTo(list2[current2])<0){
				list3[current3++] = list1[current1++]; 
			}else{
				list3[current3++] = list2[current2++];
			}
		}
		
		while(current1<list1.length)
			list3[current3++] = list1[current1++];
		while(current2<list2.length)
			list3[current3++] = list2[current2++];
		
	}
	
	
	public static <E extends Comparable<E>> void heapSort(E[] list){
		Heap<E> heap = new Heap<>();
		
		for(int i=0; i< list.length; i++){
			heap.add(list[i]);
		}
		
		for(int i = list.length -1; i >= 0; i--){
			list[i] = heap.remove();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}

/**
 * Heap class
 */

class Heap<E extends Comparable<E>>{
	private java.util.ArrayList<E> list = new ArrayList<>();
	
	public Heap(){
		
	}
	
	public Heap(E[] objects){
		for(int i = 0; i< objects.length; i++){
			add(objects[i]);
		}
	}
	public void add(E newObject){
		list.add(newObject);
		int currentIndex = list.size() -1;
		
		while(currentIndex >0){
			int parentIndex = (currentIndex -1) /2;
			
			if(list.get(currentIndex).compareTo(list.get(parentIndex))>0){
				E temp = list.get(currentIndex);
				list.set(currentIndex,  list.get(parentIndex));
				list.set(parentIndex, temp);
			}
			else{
				break;
			}
			currentIndex = parentIndex;
		}
	}
	
	public E remove(){
		if(list.size() ==0) return null;
		
		E removedObject = list.get(0);
		list.set(0, list.get(list.size() -1));
		list.remove(list.size() - 1);
		
		int currentIndex = 0;
		while(currentIndex < list.size()){
			int leftChildIndex = 2*currentIndex + 1;
			int rightChildIndex = 2 * currentIndex +2;
			
			if (leftChildIndex >= list.size()) break;
			int maxIndex = leftChildIndex;
			if(rightChildIndex < list.size()){
				if(list.get(maxIndex).compareTo(list.get(rightChildIndex))<0){
					maxIndex = rightChildIndex;
				}
			}
			if (list.get(currentIndex).compareTo(list.get(maxIndex))<0){
				E temp = list.get(maxIndex);
				list.set(maxIndex,  list.get(currentIndex));
				list.set(currentIndex,  temp);
				currentIndex = maxIndex;
			}else
				break;
			}
		return removedObject;
	}
	
	public int getSize(){
		return list.size();
	}
}

/**
 * 
 * MyGeometricObject class
 *
 */
abstract class MyGeometricObject implements Comparable<MyGeometricObject>{
	abstract Double getArea();
}

/**
 * 
 * MyCircle class
 *
 */
class MyCircle extends MyGeometricObject {
	private double radius;
	public MyCircle(){
		radius = 0;
	}
	public MyCircle(Double radius){
		this.radius = radius;
	}
	
	@Override
	public Double getArea(){
		return radius*radius*Math.PI;
	}
	@Override
	public int compareTo(MyGeometricObject c){
		double result = getArea() - c.getArea();
		if(result == 0)
			return 0;
		else if (result > 0)
			return 1;
		else
			return -1;

	}
	@Override
	public String toString(){
		
		return String.format("%.2f",getArea());
		
	}
	
}

class MyRectangle extends MyGeometricObject{
	private double width, height;
	public MyRectangle(){
		this.width = 0;
		this.height = 0;
		
	}
	
	public MyRectangle(double width, double height){
		this.width = width;
		this.height = height;
		
	}
	
	@Override
	public Double getArea(){
		
		return width * height;
	}
	
	@Override
	public int compareTo(MyGeometricObject o){
		double result = getArea() - o.getArea();
		if(result == 0)
			return 0;
		else if (result > 0)
			return 1;
		else
			return -1;
	}
	
	@Override
	public String toString(){
		
		return String.format("%.2f",getArea());
		
	}
	
}

