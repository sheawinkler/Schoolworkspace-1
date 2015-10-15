
public class Vertex {
	
	public int stateID;
	private boolean rootState;
	private boolean finalState;
	public Edge out;
	public Edge out2;

	public Vertex(){
		stateID=-1;
		setRootState(false);
		setFinalState(false);
		out = null;
		out2 = null;
	}
	public void setStateID(int stateID){
		this.stateID=stateID;
	}
	public int getStateID(){
		return this.stateID;
	}
	
	
	public void makeFinalFalse(){
		this.setFinalState(false);
	}
	public void makeFinalTrue(){
		this.setFinalState(true);
	}
	public void makeRootFalse(){
		this.setRootState(false);
	}
	public void makeRootTrue(){
		this.setRootState(true);
	}
	
	
	public boolean getRootState() {
		return rootState;
	}
	public void setRootState(boolean rootState) {
		this.rootState = rootState;
	}
	
	
	
	public boolean getFinalState() {
		return finalState;
	}
	public void setFinalState(boolean finalState) {
		this.finalState = finalState;
	}
	
}
