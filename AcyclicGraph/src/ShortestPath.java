import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/*This File takes two inputs via command line to allow 
 *the user determine whether a given graph is acyclic.  Graph input text of pattern type 
 * 5 (1,2) (3,4) (3,5) (4,5) where the first value=total vertices and pairs=edges
 *To search via command line: javac CycleFinder.java
 *To run via command line:  java CycleFinder ../data/testcase
 */
public class ShortestPath {
	
	ArrayList<Integer> finalList = new ArrayList<Integer>();
	
	int returnCheck = 0;
	
	public ShortestPath(){
		
	}
	
	
	public Integer[] loadFromFile(String anotherFile, int startingPoint){
		
		File file = new File(anotherFile);
		List<Integer> myList = new ArrayList<Integer>();
		Integer[] arr = myList.toArray(new Integer[myList.size()]);
		int totalVertices = 0;
		
		try {
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				finalList = new ArrayList<Integer>();
				String line = scanner.nextLine();
					
				HashMap<Integer, HashSet<Integer>> hm = new HashMap<Integer, HashSet<Integer>>();
				
				//Token[] >0 is each pair (1,2)
				String token[] = line.split(" ");	
				 totalVertices = Integer.parseInt(token[0]);
				 
				 for(int j=1;j<=totalVertices;j++){
					HashSet<Integer> tempSet = new HashSet<Integer>();
					 hm.put(j,tempSet);
					
				 }
				
				for(int k=1;k<token.length;k++){	
					token[k] = token[k].substring(1, token[k].indexOf(")"));
					String values[] = token[k].split(",");
					int one = Integer.parseInt(values[0]);
					int two = Integer.parseInt(values[1]);
					hm.get(one).add(two);
				}
				bfSearch(hm, totalVertices, startingPoint);
			}//End of while Loop
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		return arr;
	}

	public void bfSearch(HashMap<Integer, HashSet<Integer>> bfnewHash, int bftotal, int startingIndex){
		int newIndex = startingIndex;
		HashMap<Integer, Integer> markings = new HashMap<Integer, Integer>();
		
		
		for(Integer vertex: bfnewHash.keySet()){	
			markings.put(vertex, 0);
		}
		
		Queue queueA = new LinkedList();
		
		finalList.add(newIndex);
		markings.put(newIndex,2);
		
		while(!queueA.isEmpty()){
			//visitChild();
		}
		
	}
	
	public void visitChild(int passingVertex, HashMap<Integer,Integer> checkMarkings, HashMap<Integer,HashSet<Integer>> graphing){
		//put into queueA
	}
	
	public static void main(String args[]){
		ShortestPath cf = new ShortestPath();
		//String test = "data/testcase";
		String test = args[0];
		int startPosition = Integer.parseInt(args[1]);
		//int startPosition = 1;
		cf.loadFromFile(test, startPosition);		
	}	
	
}