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

    /**
     * Constructor that accepts a parameterized {@link Comparator} that is used to 
     * determine the relative ordering of elements in this binary search tree.
     * @param comparator
     */
    public BinarySearchTree(Comparator<T> comparator) {
        this(Collections.<T> emptyList(), comparator);
    }

    /**
     * Constructor that accepts both a parameterized {@link Comparator} and a 
     * {@link Collection} of elements to be inserted into this binary search tree
     * at instantiation.  Elements are inserted in a more-or-less optimal order
     * using {@link #addSortedItems(List)} to minimize the overall depth of the
     * tree at instantiation.
     * @param items
     * @param comparator
     */
    public BinarySearchTree(Collection<T> items, Comparator<T> comparator) {
        this.comparator = comparator;
        List<T> sortedItems = new ArrayList<T>(items);
        java.util.Collections.sort(sortedItems, this.comparator);
        addSortedItems(sortedItems);
    }

    /**
     * Adds the given {@link List} of elements to this tree.  
     * @param items
     */
    public void addSortedItems(List<T> items) {
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

    /**
     * Returns <code>true</code> if this tree contains the given <code>item</code>
     * @param item
     * @return
     */
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
    
    /* TODO: redo this method to utilize the comparator, not pre-order traversal */
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

    /**
     * Computes the maximum depth of the tree by traversing the tree using a 
     * tree walk algorithm.
     * @return
     */
    public int getMaxDepth() {
        if(root == null)
            return 0;
        else if(root.getLeftChild() == null && root.getRightChild() == null)
            return 1;

        TreeNode<T> curr = root;
        TreeNode<T> prev = null;
        int depth = 1;
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
    
    public void removeElement(T item) {

        TreeNode<T> curr = this.findElementNode(item);
        if(curr == null) 
        	return;

        if(curr.getRightChild() == null) {
        	if(curr.getLeftChild() == null) {
        		//curr is a leaf, so just get rid of it...
        		if(curr.getParent().getLeftChild() == curr)
        			curr.getParent().setLeftChild(null);
        		else if(curr.getParent().getRightChild() == curr)
        			curr.getParent().setRightChild(null);
        		else
        			throw new IllegalStateException("curr's parent does not have curr as a child; curr = "+curr);
        	} else {
        		//simply promote the left child...
        		TreeNode<T> parent = curr.getParent();
        		TreeNode<T> left = curr.getLeftChild();

        		left.setParent(parent);
        		if(curr.getParent().getLeftChild() == curr)
        			curr.getParent().setLeftChild(left);
        		else if(curr.getParent().getRightChild() == curr)
        			curr.getParent().setRightChild(left);
        		else
        			throw new IllegalStateException("curr's parent does not have curr as a child; curr = "+curr);
        	}
        } else {
        	//ignoring the corner case of curr.left == null
            //find minimal element of larger nodes...
        	TreeNode<T> min = curr.getRightChild();
        	while(min.getLeftChild() != null)
        		min = min.getLeftChild();
        	
        	//promote min.right up to min's spot
        	if(min.getParent().getLeftChild() == min) {
	        	min.getParent().setLeftChild(min.getRightChild());
	        	if(min.getRightChild() != null)
	        		min.getRightChild().setParent(min.getParent());
        	} else if (min.getParent().getRightChild() == min) {
        		min.getParent().setRightChild(min.getRightChild());
        		if(min.getRightChild() != null)
        			min.getRightChild().setParent(min.getParent());
        	}
        	
        	min.setParent(curr.getParent());
        	min.setLeftChild(curr.getLeftChild());
        	min.setRightChild(curr.getRightChild());
        	if(curr.getRightChild() != null)
        		curr.getRightChild().setParent(min);
        	if(curr.getLeftChild() != null)
        		curr.getLeftChild().setParent(min);
    		if(curr != root) {
    			if(curr.getParent().getLeftChild() == curr)
	    			curr.getParent().setLeftChild(min);
	    		else if(curr.getParent().getRightChild() == curr)
	    			curr.getParent().setRightChild(min);
	    		else
	    			throw new IllegalStateException("curr's parent does not have curr as a child; curr = "+curr);
    		} else {
    			root = min;
    		}
        	
        }

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
    
    public String toTikzString() {
    	
        StringBuilder sb = new StringBuilder();
        sb.append("\\begin{tikzpicture}[level distance=1cm,level/.style={sibling distance=2cm/#1}]\n");
        if(this.root == null) {
        	sb.append("\\node{\\texttt{null}};");
        } else {
        	sb.append("\\node{"+root.getValue().toString()+"}\n");
        	this.toTikzStringRec(root.getLeftChild(), sb);
        	this.toTikzStringRec(root.getRightChild(), sb);
        	sb.append(";\n");
        }
        sb.append("\\end{tikzpicture}\n\n");
        return sb.toString();
    }
    
    private void toTikzStringRec(TreeNode<T> curr, StringBuilder sb) {
    	if(curr == null) {
    		sb.append("child[draw opacity=0.0] {}\n");
    	} else {
    		sb.append("child {node {"+curr.getValue().toString()+"} \n");
    		this.toTikzStringRec(curr.getLeftChild(), sb);
    		this.toTikzStringRec(curr.getRightChild(), sb);
    		sb.append("}\n");
    	}
    }
    
    public int getNumLeaves() {
    	//return this.getNumLeavesRec(this.root);
    	return getNumLeavesTraversal();
    }
    
    private int getNumLeavesRec(TreeNode<T> node) {
    	if(node == null) 
    		return 0;
    	else if(node.getLeftChild() == null & node.getRightChild() == null)
    		return 1;
    	else
    		return getNumLeavesRec(node.getLeftChild()) + getNumLeavesRec(node.getRightChild());
    }
    
    private int getNumLeavesTraversal() {

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
    	preOrderTraversalRec(this.root);
    	System.out.print("\n");
    }

    public void inOrderTraverse() {
    	inOrderTraversalRec(this.root);
    	System.out.print("\n");
    }
    
    public void postOrderTraverse() {
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
    

}
