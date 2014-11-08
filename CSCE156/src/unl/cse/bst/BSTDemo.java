package unl.cse.bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class BSTDemo {

    public static final Comparator<Integer> INTEGER_COMPARATOR = new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return a.compareTo(b);
        }
    };

    public static void main(String args[]) {

        Random r = new Random();
    	  int n = 16;
        List<Integer> randomList = new ArrayList<Integer>(n);
        for(int i=0; i<n; i++) {
            randomList.add(r.nextInt());
        }

        //tree balanced at construction
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(randomList, INTEGER_COMPARATOR);
        System.out.println("Balanced on construction:");
        System.out.println(bst);
        System.out.println("Depth: "+bst.getMaxDepth());
        System.out.println("Size: "+bst.getNumNodes());
        
        //randomly generated tree
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>(INTEGER_COMPARATOR);
        for(Integer i : randomList) {
            bst2.addElement(i);
        }
        System.out.println("randomly constructed");
        System.out.println(bst2);
        System.out.println("Depth: "+bst2.getMaxDepth());
        System.out.println("Size: "+bst2.getNumNodes());
        

        List<Integer> l = new ArrayList<Integer>();
        for(int i=0; i<n; i++) {
            l.add(i); //bst3.addElement(i);
        }
        BinarySearchTree<Integer> bst3 = new BinarySearchTree<Integer>(l, INTEGER_COMPARATOR);
        //System.out.println("degenerate case");
        System.out.println(bst3);
        System.out.println("Depth: "+bst3.getMaxDepth());
        System.out.println("Size: "+bst3.getNumNodes());
        System.out.println("Num Leaves: "+bst3.getNumLeaves());
        System.out.println("Pre Order Traversal exp: ");
        bst3.preOrderTraverse();
        System.out.println("In Order Traversal rec:");
        bst3.inOrderTraverse();
        System.out.println("Post Order Traversal rec:");
        bst3.postOrderTraverse();
//		TODO: get this working
        bst3.removeElement(15);
//        System.out.println(bst3);
//        System.out.println("Depth: "+bst3.getMaxDepth());
//        System.out.println("Size: "+bst3.getNumNodes());
    }
}
