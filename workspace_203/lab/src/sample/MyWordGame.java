package sample;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyWordGame extends Application {
	BorderPane bp = new BorderPane();
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		MyPane mp = new MyPane();
		bp.setCenter(mp);
		Scene scene = new Scene(bp, 400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
		mp.requestFocus();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}

class MyPane extends Pane{
	LinkedHashSet<Character> letters = new LinkedHashSet<>();
	String[] library = {"Java", "is", "fun!"};
	LinkedHashMap<Integer,Character> hiddenWord = new LinkedHashMap<>();
	ArrayList<Character> placeHolder = new ArrayList<>();
	public MyPane(){
		getStarted();
		this.setOnKeyPressed(e->{
			if(e.getCode().isLetterKey()){
				letters.add(e.getText().charAt(0));
				Text temp = new Text(10, 70, "Letter you typed are " + letters.toString());
				temp.setFont(Font.font(20));
				this.getChildren().add(temp);
				System.out.println(letters.toString());
			}
		});
	}

	private void getStarted(){
		String myword = library[(int) (Math.random()*library.length)];
		this.getChildren().clear();
		for(int i = 0; i< myword.length(); i++){
			hiddenWord.put(i, myword.charAt(i));
			placeHolder.add('*');
		}
		System.out.println(myword+" " + placeHolder.toString() +" "+ hiddenWord.toString());
		
		
	}
	
}

