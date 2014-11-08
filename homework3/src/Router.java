import java.io.*;
import java.util.*;


/**
 * Main class that runs program, adding data to a List and printing to the console.
 * 
 * @author Deverick Simpson
 * 
 */
public class Router {

	
	
	public static void main(String[] args){
		Router route = new Router();
		
		System.out.println("Reading packet information");
		route.inputPacketFromFile();
		System.exit(0);

	}

	
	public void inputPacketFromFile(){
		try{
			File file = new File("packets-small.csv");
			Scanner original = new Scanner(file);
			boolean check = true;
			LList newList = new LList();
			
			while(original.hasNextLine()){
				Packet packet = new Packet();
				if(check){
					String address = original.nextLine();
					check = false;
				}
				String line = original.nextLine();
				String[] lineArray = line.split(",");
						packet.setPageId(Integer.parseInt(lineArray[0]));
						packet.setTotalPackets(Integer.parseInt(lineArray[1]));
						packet.setPacketId(Integer.parseInt(lineArray[2]));
						packet.setLengthOfPackets(Double.parseDouble(lineArray[3]));
						packet.setDestinationNode(lineArray[4]);
						packet.setOriginatingNode(lineArray[5]);	
						//add packet to the list
						//Check if page coming in is new or not
						
							newList.add(packet);

			}
				newList.display();
				return;
			
		} catch(FileNotFoundException e){
			e.getMessage();
		}
	}
}
	
