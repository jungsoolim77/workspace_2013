package chapter30;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

public class FlashText2 extends Application {
	
	private String text = "";
	int counter = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	StackPane pane = new StackPane();
	Label lblText = new Label("Java is fun!");
	lblText.setFont(Font.font(20));
	pane.getChildren().add(lblText);
	
	
	new Thread(new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				while(true){
					
				
				if(counter%2==0){
					text = "Programming is fun";
					lblText.setFont(Font.font("Lucida Sans", FontPosture.ITALIC, 28));
				}else{
					text = "Happy Thanksgiving!";
					lblText.setFont(Font.font("Comic Sans MS", FontPosture.ITALIC, 28));
				}
				counter++;
				
				Platform.runLater(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						lblText.setText(text);
					}
				
				});
			
				Thread.sleep(1000);
				}
			}catch(Exception ex){
				
			}
			
		}
		
		
	}).start();
	Scene scene = new Scene(pane, 800, 50);
	primaryStage.setTitle("Thread Demo");
	primaryStage.setScene(scene);
	primaryStage.show();
	

}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	Application.launch(args);
}

}

