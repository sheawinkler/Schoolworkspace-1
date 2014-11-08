package unl.cse.bst;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree<T> {

    private TreeNode<T> root;
    private final Comparator<T> comparator;

    public BinarySearchTree(Comparator<T> comparator) {
        this(Collections.<T> emptyList(), comparator);
    }

    public BinarySearchTree(Collection<T> items, Comparator<T> comparator) {
        this.comparator = comparator;
        List<T> sortedItems = new ArrayList<T>(items);
        java.util.Collections.sort(sortedItems, this.comparator);
        addSortedItems(sortedItems);
    }

    private void addSortedItems(List<T> items) {
        if(items.size() < 1)
            return;
        else if(items.size() == 1)
            addElement(items.get(0));
        else {
            int mid = items.size() / 2;
            addElement(items.get(mid));
            addSortedItems(items.subList(0, mid));
            addSortedItems(items.subList(mid+1, items.size()));
        }

    }

    public boolean containsElement(T item) {
        return (this.findElement(item) != null);
    }

    public T findElement(T item) {
        T result = null;
        if(root == null)
            return null;

        Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
        TreeNode<T> curr = root;
        while(curr != null) {
            if(curr.getRightChild() != null)
                s.push(curr.getRightChild());
            if(curr.getLeftChild() != null)
                s.push(curr.getLeftChild());

            if(curr.getValue().equals(item))
                return curr.getValue();

            if(s.isEmpty())
                curr = null;
            else
                curr = s.pop();
        }

        return result;
    }
    
    private TreeNode<T> findElementNode(T item) {

        if(root == null)
            return null;

        Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
        TreeNode<T> curr = root;
        while(curr != null) {
            if(curr.getRightChild() != null)
                s.push(curr.getRightChild());
            if(curr.getLeftChild() != null)
                s.push(curr.getLeftChild());

            if(curr.getValue().equals(item))
                return curr;

            if(s.isEmpty())
                curr = null;
            else
                curr = s.pop();
        }
        return null;
    }

    public int getMaxDepth() {
        if(root == null)
            return 0;
        else if(root.getLeftChild() == null && root.getRightChild() == null)
            return 1;

        TreeNode<T> curr = root;
        TreeNode<T> prev = null;
        int depth = 0;
        int maxDepth = depth;
        while(curr != null) {
            if(curr.getParent() == prev) {
                if(curr.getLeftChild() != null) {
                    prev = curr;
                    curr = curr.getLeftChild();
                    depth++;
                    maxDepth = Math.max(maxDepth, depth);
                } else if(curr.getRightChild() != null) {
                    prev = curr;
                    curr = curr.getRightChild();
                    depth++;
                    maxDepth = Math.max(maxDepth, depth);
                } else {
                    prev = curr;
                    curr = curr.getParent();
                    depth--;
                }
            } else if(curr.getLeftChild() == prev) {
                if(curr.getRightChild() != null) {
                    prev = curr;
                    curr = curr.getRightChild();
                    depth++;
                    maxDepth = Math.max(maxDepth, depth);
                } else {
                    prev = curr;
                    curr = curr.getParent();
                    depth--;
                }
            } else if(curr.getRightChild() == prev) {
                prev = curr;
                curr = curr.getParent();
                depth--;
            } else {
                throw new IllegalStateException("Current/Previous: "+curr.getValue()+", "+prev.getValue());
            }
        }
        return maxDepth;
   }

    private int getDepth(TreeNode<T> node) {
        int depth = 0;
        TreeNode<T> curr = node;
        while(curr != root) {
            curr = curr.getParent();
            depth++;
        }
        return depth;
    }
    
    public int getNumNodes() {
    	
    	int count = 0;

    	if(root == null)
        	return count;

        Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
        TreeNode<T> curr = root;
        while(curr != null) {
            if(curr.getRightChild() != null)
                s.push(curr.getRightChild());
            if(curr.getLeftChild() != null)
                s.push(curr.getLeftChild());

            count++;
            if(s.isEmpty())
                curr = null;
            else
                curr = s.pop();
        }
        return count;
    }
    
    public void addElement(T item) {
        if(item == null)
            throw new IllegalArgumentException("BinarySearchTree does not allow null elements");
        if(containsElement(item))
            return;
        TreeNode<T> newNode = new TreeNode<T>(item);
        if(root == null) {
            root = newNode;
            return;
        }
        TreeNode<T> curr = root;
        TreeNode<T> prev = null;
        while(curr != null) {
            if(this.comparator.compare(curr.getValue(), item) > 0) {
                prev = curr;
                curr = curr.getLeftChild();
            } else {
                prev = curr;
                curr = curr.getRightChild();
            }
        }
        if(this.comparator.compare(prev.getValue(), item) > 0 ) {
            prev.setLeftChild(newNode);
            newNode.setParent(prev);
        } else {
            prev.setRightChild(newNode);
            newNode.setParent(prev);
        }
    }

    @Override
    public String toString() {
        if(root == null)
            return "[empty]";

        StringBuilder sb = new StringBuilder();
        Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
        TreeNode<T> curr = root;
        while(curr != null) {
            if(curr.getRightChild() != null)
                s.push(curr.getRightChild());
            if(curr.getLeftChild() != null)
                s.push(curr.getLeftChild());

            for(int i=0; i<getDepth(curr); i++)
                sb.append(" ");
            sb.append("|-"+curr.getValue()+"\n");
            if(s.isEmpty())
                curr = null;
            else
                curr = s.pop();
        }
        return sb.toString();
    }
    
    public int getNumLeaves() {
		//TODO: implement this
    
    	int count = 0;
        Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
        TreeNode<T> curr = root;
        while(curr != null) {
            if(curr.getRightChild() != null)
                s.push(curr.getRightChild());
            if(curr.getLeftChild() != null)
                s.push(curr.getLeftChild());

            if(curr.getLeftChild() == null && curr.getRightChild() == null) 
            	count++;
            if(s.isEmpty())
                curr = null;
            else
                curr = s.pop();
        }
        return count;
    }

    public void preOrderTraverse() {
		//TODO: implement this
    	
    	preOrderTraversalRec(this.root);
    	System.out.print("\n");
    }

    public void inOrderTraverse() {
		//TODO: implement this
    	
    	inOrderTraversalRec(this.root);
    	System.out.print("\n");
    }
    
    public void postOrderTraverse() {
		//TODO: implement this
    	
    	postOrderTraversalRec(this.root);
    	System.out.print("\n");
    }
    
    private void preOrderTraversalRec(TreeNode<T> node) {
        if(node == null) return;
        System.out.print(node.getValue()+", ");
        preOrderTraversalRec(node.getLeftChild());
        preOrderTraversalRec(node.getRightChild());
    }
    
    private void inOrderTraversalRec(TreeNode<T> node) {
        if(node == null) return;
        inOrderTraversalRec(node.getLeftChild());
        System.out.print(node.getValue()+", ");
        inOrderTraversalRec(node.getRightChild());
    }

    private void postOrderTraversalRec(TreeNode<T> node) {
        if(node == null) return;
        postOrderTraversalRec(node.getLeftChild());
        postOrderTraversalRec(node.getRightChild());
        System.out.print(node.getValue()+", ");
    }
    
public static void main(String Args[]){
	
}
//Dont do anything

}
