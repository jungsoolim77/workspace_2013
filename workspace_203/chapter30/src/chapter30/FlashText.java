package chapter30;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FlashText extends Application {

	private String text = "";
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		StackPane pane = new StackPane();
		Label lblText = new Label("Java is fun!");
		pane.getChildren().add(lblText);
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					while(true){
						
					
					if(lblText.getText().trim().length()==0)
						text = "Programming is fun";
					else
						text = "";
					
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
		Scene scene = new Scene(pane, 200, 50);
		primaryStage.setTitle("Thread Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
