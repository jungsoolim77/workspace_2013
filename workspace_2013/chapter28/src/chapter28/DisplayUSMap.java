package chapter28;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DisplayUSMap extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		City[] vertices = {new City("Seattle", 75, 50), new City("San Francisco", 50, 210), new City("Los Angeles", 75, 275),
				new City("New York", 675, 120), new City("Miami", 600, 400), new City("Denver", 275,175), 
				new City("Kansas City", 400,245), new City("Chicago", 450,100)};
		int[][] edges = {{0,1}, {1,2}, {2,3}, {3,4}, {2,4}, {3,0}, {3,1},{3,2},{3,4},{3,5},{0,6},{3,6},{4,5},{5,6}};
		
		Graph<City> graph = new UnweightedGraph<>(vertices, edges);
		Pane pane = new GraphView(graph);
		
		Scene scene = new Scene(pane, 750, 450);
		primaryStage.setTitle("Display US Map");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}
}

class City implements Displayable{
	private int x, y;
	private String name;
	
	public City(String name, int x, int y){
		this.name = name; 
		this.x = x;
		this.y = y;
	}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
}