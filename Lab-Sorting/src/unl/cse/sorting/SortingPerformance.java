package unl.cse.sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortingPerformance {

	private final Integer maxNumLocations;
    private Location locations[];

	public SortingPerformance(Integer maxLocations) {
		this.maxNumLocations = maxLocations;
		this.locations = new Location[maxLocations];
		loadFromFile();
	}
	
	public Location[] getLocations() {
		return this.locations;
	}
	
	private void loadFromFile() {

		List<Location> tmp = new ArrayList<Location>();
        try {
            File file = new File("data/geoData.csv");
            Scanner scanner = new Scanner(file);
            //throw away first line 
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //create airport objects
                String[] arr = line.split(",");
                
                Integer z = Integer.parseInt(arr[0]);
                String zip = String.format("%05d", z);
                Double lat = 0d;
                Double lon = 0d;
                String city = arr[3] == null ? "" : arr[3];
                String state = arr[4] == null ? "" : arr[4];
                try {
                	lat = Double.parseDouble(arr[1]);
                	lon = Double.parseDouble(arr[2]);
                } catch(NumberFormatException nfe) {
                	//silence exceptions
                }
                Location location = new Location(zip, lat, lon, city, state);
                tmp.add(location);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        Collections.shuffle(tmp);
        for(int i=0; i<this.maxNumLocations; i++)
        	this.locations[i] = tmp.get(i);
        return;
	}
	
	public static void printLocationArray(Location list[]) {
		System.out.println(Arrays.toString(list));
	}
	
	public static void main(String args[]) {
		
		int n = 20000;
		SortingPerformance sp = new SortingPerformance(n);
	/*
		long start = System.nanoTime();
		Location[] locationList = sp.getLocations();
		//SortingAlgorithms.javaSort(locationList);
		SortingAlgorithms.quickSort(locationList);
		sp.printLocationArray(locationList);
		long end = System.nanoTime();
		long elapsedTime = (end -start);
		System.out.println(elapsedTime*.0000001);
		
		//TODO: setup your experiments here
		*/
		/*
		long start2 = System.nanoTime();
		Location[] locationList2 = sp.getLocations();
		SortingAlgorithms.insertionSort(locationList2);
		sp.printLocationArray(locationList2);
		long end2 = System.nanoTime();
		long elapsedTime2 = (end2 -start2);
		System.out.println(elapsedTime2*.0000001);
		*/
		/*
		long start3 = System.nanoTime();
		Location[] locationList3 = sp.getLocations();
		SortingAlgorithms.javaSort(locationList3);
		sp.printLocationArray(locationList3);
		long end3= System.nanoTime();
		long elapsedTime3 = (end3 -start3);
		System.out.println(elapsedTime3*.0000001);
		*/
		long start4 = System.nanoTime();
		Location[] locationList4 = sp.getLocations();
		SortingAlgorithms.selectionSort(locationList4);
		sp.printLocationArray(locationList4);
		long end4= System.nanoTime();
		long elapsedTime4 = (end4 -start4);
		System.out.println(elapsedTime4*.0000001);
		
	}
}
