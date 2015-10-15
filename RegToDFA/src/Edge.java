

public class Edge{
	private char weight;
	private Vertex vertexTo;
	
	
	public Edge(Vertex vertT, char weigh){
		weight = weigh;
		vertexTo = vertT;
	}
		
	public Vertex returnToVertex(){
		return this.vertexTo;
	}
	public char returnWeight(){
		return weight;
	}
	

	
	
	
	
}
