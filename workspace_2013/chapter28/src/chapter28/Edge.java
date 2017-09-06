package chapter28;

public class Edge {
	int u, v;
	
	public Edge(int u, int v){
		this.u = u;
		this.v = v;
	}
	
	public boolean equals(Object o){
		return this.u == ((Edge) o).u && this.v == ((Edge) o).v; 
	}

}
