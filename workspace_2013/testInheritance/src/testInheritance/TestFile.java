package testInheritance;
/*
 * Please note that this is an example to read text file.
 * To read binary file, you will have to make file reading procedure accordingly
 * Procedure
 * 1. Click Open files button
 * 2. Navigate to your text file
 * 3. Open file 
 * 4. The content of file will be read and posted on pane
 */
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TestFile extends Application {
	BorderPane pane = new BorderPane(); 
	VBox top = new VBox();
	VBox bottom = new VBox();
	
	FileChooser fileChooser = new FileChooser();
	Stage primaryStage = new Stage();
	private Desktop desktop = Desktop.getDesktop();

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Button openB = new Button("Open files...");
        openB.setOnAction(this::getFiles);
        pane.setCenter(openB);
        pane.setTop(top);
        pane.setBottom(bottom);
		Scene scene = new Scene(pane, 300,300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("File chooser testing");
		primaryStage.show();

	}

	public void getFiles(ActionEvent e){
		File file = fileChooser.showOpenDialog(primaryStage);
		try {
			if(file != null){
				String path = file.getPath();
				top.getChildren().addAll(new Label(path));
				Scanner input = new Scanner(new File(path));
				StringBuilder sb = new StringBuilder();
				while(input.hasNextLine()){
					sb.append(input.nextLine());
				}
				bottom.getChildren().add(new Label(sb.toString()));
				desktop.open(file);
				input.close();
				
				
			}
		}catch (IOException ex) {
            Logger.getLogger(
                FileChooser.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }

		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
