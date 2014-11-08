package unl.cse.bears;

public class BearGameGrader {
	
	public static void main(String args[]) {
		BearGameAnswer answer = new BearGameAnswer();
		BearGame       student = new BearGame();
		int n = 10000;
		
		int numCorrectBoolean = 0;
		int numCorrectCount = 0;
		
		for(int i=0; i<n; i++) {
			if(answer.isWinnable(i) == student.isWinnable(i))
				numCorrectBoolean++;
			if(answer.getNumSolutions(i).intValue() == student.getNumSolutions(i).intValue())
				numCorrectCount++;
		}
		
		System.out.println("Visual Inspection 01:");
		System.out.println("ANSWER:");
		System.out.println("=================================================================");
		answer.printAllSolutions(91329);
		System.out.println("STUDENT:");
		System.out.println("=================================================================");
		student.printAllSolutions(91329);

		System.out.println("Visual Inspection 02:");
		System.out.println("ANSWER:");
		System.out.println("=================================================================");
		answer.printAllSolutions(939);
		System.out.println("STUDENT:");
		System.out.println("=================================================================");
		student.printAllSolutions(939);
		
		double boolPerc = numCorrectBoolean / (double) n;
		double boolPt   = boolPerc * 20.0;
		System.out.println("isWinnable Test Cases: passed "+numCorrectBoolean+" out of " + n + " = "+String.format("%.2f", boolPerc*100.0)+" x 20 pts = "+boolPt);

		double countPerc = numCorrectCount / (double) n;
		double countPt   = countPerc * 20.0;
		System.out.println("getNumberSolutions Test Cases: passed "+numCorrectCount+" out of " + n + " = "+String.format("%.2f", countPerc*100.0)+" x 20 pts = "+countPt);

		System.out.println("printAllSolutions Test Cases: passed "+"_______"+" out of " + "______" + " = ______% x 10 pts = ____");

	}
}
