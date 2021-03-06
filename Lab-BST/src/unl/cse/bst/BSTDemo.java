package unl.cse.bst;

import java.util.Comparator;

public class BSTDemo {

    public static final Comparator<Integer> INTEGER_COMPARATOR = new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return a.compareTo(b);
        }
    };

    public static void main(String args[]) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(INTEGER_COMPARATOR);
        
        // Test 1 BST
        bst.addElement(8);
        bst.addElement(10);
        bst.addElement(3);
        bst.addElement(5);
        bst.addElement(7);
        bst.addElement(8);
        bst.addElement(9);
        bst.addElement(1);
        bst.addElement(2);
        bst.addElement(0);
           
        
          /* TEST 2 BST
        bst.addElement(1);
        bst.addElement(2);
        bst.addElement(3);
        bst.addElement(5);
        bst.addElement(8);
        bst.addElement(13);
        bst.addElement(21);
        bst.addElement(34);
        bst.addElement(55);
        bst.addElement(89);
           */
        
           /*TEST 3 BST
        bst.addElement(8);
        bst.addElement(4);
        bst.addElement(2);
        bst.addElement(6);
        bst.addElement(12);
        bst.addElement(10);
        bst.addElement(9);
        bst.addElement(1);
        bst.addElement(0);
        bst.addElement(5);
        bst.addElement(3);
        bst.addElement(14);
        bst.addElement(7);
        bst.addElement(11);
        bst.addElement(15);
        bst.addElement(13);
           */
        
        
        System.out.println(bst);
        System.out.println("Depth: "+bst.getMaxDepth());
        System.out.println("Size: "+bst.getNumNodes());
        System.out.println("Num Leaves: "+bst.getNumLeaves());
        System.out.println("Pre Order Traversal exp: ");
        bst.preOrderTraverse();
        System.out.println("In Order Traversal rec:");
        bst.inOrderTraverse();
        System.out.println("Post Order Traversal rec:");
        bst.postOrderTraverse();
    }
}
