package unl.cse;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
/*
 * Flatten.java takes an input as an array list and outputs the information into a compressed file.  
 * The class is further defined with seperate methods to output to .xml and .json.
 */
public class Flatten {
	//Method to convert to XML
	public static void flattenToXML(@SuppressWarnings("rawtypes") ArrayList arrayList,String fileName){
		
		String name = ("data/"+fileName+".xml");
		
		XStream xstreamPerson = new XStream(new DomDriver());					//XStream writer for file
		try {
		    FileOutputStream f = new FileOutputStream(name);
		    xstreamPerson.toXML(arrayList,f);

		} catch (FileNotFoundException ex) {
		    ex.printStackTrace();
		}
	}
	//Method to convert to json
	public static void flattenToGson(@SuppressWarnings("rawtypes") ArrayList arrayList,String fileName){
		String name = ("data/"+fileName+".json");
		Gson gPerson = new GsonBuilder().setPrettyPrinting().create();		//GSON writer for file

		try {
		    PrintWriter WR = new PrintWriter(name);
		    String gsonPerson = gPerson.toJson(arrayList);
			WR.write(gsonPerson);
		    WR.close();
		    

		} catch (FileNotFoundException ex) {
		    ex.printStackTrace();
		}
	}
	

}
