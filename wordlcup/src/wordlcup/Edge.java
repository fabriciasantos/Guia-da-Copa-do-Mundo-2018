package wordlcup;

public class Edge {
	@SuppressWarnings("unused")
	private Node src;
	@SuppressWarnings("unused")
	private Node dest;
	private float cost;

	public Edge(Node src, Node dest, float cost){
		this.src = src;
		this.dest = dest;
		this.cost = cost;
	}

}
