package unl.cse.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class SortGrader {

	private static final Comparator<Integer> INTEGER_COMPARATOR = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}};

	private final Random r;
	private final Integer repetitions = 10;
	private final Integer sizes[] = {10, 100, 200, 400, 1000, 10000, 20000};
	private final Comparator<Integer> comparator;
	
	public SortGrader(Comparator<Integer> comparator) {
		this.r = new Random();
		this.comparator = comparator;
	}

	public boolean correctnessCheck(Sorter<Integer> sorter) {
		List<Integer> randomNumbers = new ArrayList<Integer>();
		for(int i=0; i<100; i++) {
			randomNumbers.add(r.nextInt());
		}
		List<Integer> correct = new ArrayList<Integer>(randomNumbers);
		Collections.sort(correct, this.comparator);
		List<Integer> theirs = new ArrayList<Integer>(randomNumbers);
		sorter.sort(theirs, this.comparator);
		return correct.equals(theirs);
	}
	
	private double runExperiment(Sorter<Integer> sorter, int n) {
		
		List<Integer> randomNumbers = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			randomNumbers.add(r.nextInt());
		}
		long start, end;
		long totalDuration = 0l;
		for(int i=0; i<this.repetitions; i++) {
			List<Integer> copy = new ArrayList<Integer>(randomNumbers);
			start = System.currentTimeMillis();
			sorter.sort(copy, INTEGER_COMPARATOR);
			end = System.currentTimeMillis();
			totalDuration += (end - start);
		}
		return totalDuration / (double) this.repetitions;
	}
	
	public void runAllExperiments(List<Sorter<Integer>> sorters) {

		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-20s", "Algorithm"));
		for(Integer size : sizes) {
			sb.append(String.format("%12d", size));
		}
		sb.append("\n");
		for(Sorter<Integer> sorter : sorters) {
			String algo = sorter.getClass().toString();
			algo = algo.substring(algo.lastIndexOf('.')+1);
			sb.append(String.format("%-20s", algo));
			if(correctnessCheck(sorter)) {
				for(Integer size : sizes) {
					double d = runExperiment(sorter, size);
					sb.append(String.format("%10.2fms", d));
				}
				sb.append("\n");
			} else {
				sb.append("\tFAILED: sorter "+sorter.getClass()+" failed to correctly sort.\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static void main(String args[]) {
		
		List<Sorter<Integer>> allSorters = new ArrayList<Sorter<Integer>>();
		Sorter<Integer> insertionSorter = new InsertionSorter<Integer>();
		Sorter<Integer> javaSorter = new JavaSorter<Integer>();
		Sorter<Integer> selectionSorter = new SelectionSorter<Integer>();
		allSorters.add(insertionSorter);
		allSorters.add(javaSorter);
		allSorters.add(selectionSorter);

		SortGrader tester = new SortGrader(INTEGER_COMPARATOR);
		
		tester.runAllExperiments(allSorters);
	}
}
