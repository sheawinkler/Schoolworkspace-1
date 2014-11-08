import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/*Deverick Simpson Feb 2014
 *This File takes two inputs via command line to allow 
 *the user determine whether a given graph is acyclic.  Furthermore, this algorithm will 
 *output multiple cycles if more than one exists within a single graph 
 *Graph input text of pattern type 
 *5 (1,2) (3,4) (3,5) (4,5) 
 *where the first value=total vertices and pairs=edges
 *To search via command line: javac CycleFinder.java
 *To run via command line:  java CycleFinder ../data/testcase
 */
public class CycleFinder {
	
	ArrayList<Integer> finalList = new ArrayList<Integer>();
	ArrayList<Integer> topoList = new ArrayList<Integer>();
	int returnCheck = 0;
	
	public CycleFinder(){
	}
	
	public Integer[] loadFromFile(String anotherFile){
		File file = new File(anotherFile);
		List<Integer> myList = new ArrayList<Integer>();
		Integer[] arr = myList.toArray(new Integer[myList.size()]);
		int totalVertices = 0;
		
		try {
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				finalList = new ArrayList<Integer>();
				topoList = new ArrayList<Integer>();
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
					/*if(!hm.containsKey(one) ) {
						HashSet<Integer> set = new HashSet<Integer>();
						set.add(two);
						hm.put(one, set);
					}else{
					*/
					hm.get(one).add(two);
					//}
				}
				dfSearch(hm, totalVertices);
			}//End of while Loop
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		return arr;
	}
	
	public void dfSearch(HashMap<Integer, HashSet<Integer>> newHash, int total){
		HashMap<Integer, Integer> markings = new HashMap<Integer, Integer>();
		//System.out.println(newHash.entrySet());
		for(Integer vertex: newHash.keySet()){
			markings.put(vertex, 0);
		}
		
		for(Integer vertex: newHash.keySet()){
			if(markings.get(vertex)==0){
				visitChild(vertex, markings, newHash);
			}			
		}

		Collections.reverse(finalList);
		if(returnCheck==0){
		System.out.println("Acyclic "+finalList);
		}
	}
	
	public void visitChild(int passingVertex, HashMap<Integer,Integer> checkMarkings, HashMap<Integer,HashSet<Integer>> graphing){
		//1 is defined as "gray"
		//System.out.println(checkMarkings.get(passingVertex));
		
		if(checkMarkings.get(passingVertex)==1){
			System.out.println("Cycle Exists");	
			returnCheck =5;
		}
		
		
		//0 means has not been visited
		if(checkMarkings.get(passingVertex)==0){
			
			checkMarkings.put(passingVertex,1);
			
			
			//checkMarkings.remove(checkMarkings.get(passingVertex));
			checkMarkings.put(checkMarkings.get(passingVertex),0);

			for(Integer vertex: graphing.get(passingVertex)){
				returnCheck=0;
					visitChild(vertex,checkMarkings,graphing);
			
			}

			//2 means done
			checkMarkings.put(passingVertex,2);
			finalList.add(passingVertex);
		
		}
		

		
	}
	
	
	public static void main(String args[]){
		CycleFinder cf = new CycleFinder();
		String test = "data/testcase";
		//String test = args[0];
		cf.loadFromFile(test);		
	}	
}