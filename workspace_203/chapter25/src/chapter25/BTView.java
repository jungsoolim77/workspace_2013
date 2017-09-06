package chapter25;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class BTView extends Pane {
	private BST<Integer> tree = new BST<>();
	private double radius = 15;
	private double vGap = 50;
	
	BTView(BST<Integer> tree){
		this.tree = tree;
		setStatus("Tree is empty");
	}
	
	public void setStatus(String msg){
		getChildren().add(new Text(20,20,msg));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
