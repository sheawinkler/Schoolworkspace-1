package unl.cse.bst;

import java.util.Arrays;
import java.util.List;

import unl.cse.counting.JohnsonTrotter;
import unl.cse.counting.Permutation;

public class BSTQuestion {

	public static void main(String args[]) {
		
		//Weiss 19.2
//		List<Integer> list = Arrays.asList(1, 2, 3, 4);
//		BinarySearchTree<Integer> bst;
//		
//		Permutation<Integer> p = new JohnsonTrotter<Integer>(list);
//		
//		for(List<Integer> l : p) {
//			bst = new BinarySearchTree<Integer>(BSTDemo.INTEGER_COMPARATOR);
//			for(Integer i : l) {
//				bst.addElement(i);
//			}
//			System.out.println("Perm: "+l+": \\\\");
//			//System.out.println("Tree: \n"+bst);
//			System.out.println(bst.toTikzString());
//		}
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(BSTDemo.INTEGER_COMPARATOR);
		List<Integer> list = Arrays.asList(32, 10, 1, 6, 65, 42, 21);
		for(Integer i : list) {
			bst.addElement(i);
		}
		System.out.println(bst.toTikzString());
		
	}
}
