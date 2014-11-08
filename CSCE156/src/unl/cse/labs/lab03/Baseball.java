package unl.cse.labs.lab03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Baseball {

	public static void main(String args[]) {
		
		String fileName = "data/mlb_nl_2011.txt";
		Scanner s = null;
		try {
			s = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Team teams[] = new Team[16];

		int i = 0;
		while(s.hasNext()) {
			String name = s.next();
			Integer wins = s.nextInt();
			Integer loss = s.nextInt();
			Team t = new Team(name, wins, loss);
			teams[i] = t;
			i++;
		}

		System.out.println("Teams: ");
		for(Team t : teams) {
			System.out.println(t);
		}

		Arrays.sort(teams, new Comparator<Team>() {
			@Override
			public int compare(Team a, Team b) {
				return b.getWinPercentage().compareTo(a.getWinPercentage());
			}
			
		});
		
		System.out.println("\n\nSorted Teams: ");
		for(Team t : teams) {
			System.out.println(t);
		}
		
		String outFile = "data/mlb_nl_2011_result.txt";
		
		PrintWriter out = null;
		try {
			out = new PrintWriter(outFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		for(Team t : teams) {
			out.write(String.format("%10s %5.2f\n", t.getName(), t.getWinPercentage()*100));
		}
		out.close();
		
	}
	
}
