package unl.cse.bst;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> {

    private TreeNode<T> root;

    public BinaryTree() {
    	this.root = null;
    }

    public BinaryTree(Collection<T> items) {
		for(T item : items) {
		    addElement(item);
		}
    }

    public boolean containsElement(T item) {
    	return (this.findElement(item) != null);
    }

    /**
     * Finds the specified element in the tree if it exists.  Utilizes a 
     * preorder traversal using a stack
     * @param item
     * @return
     */
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

    /**
     * Finds the depth of the tree by doing a preorder traversal without the
     * use of <i>any</i> separate data structures.  Instead, it keeps track of where it has 
     * been and where it is to gauge an orientation in order to decide where to
     * go next.
     * @return
     */
    public int getMaxDepth() {
		if(root == null) {
			return 0;
		} else if(root.getLeftChild() == null && root.getRightChild() == null) {
		    return 1;
		}
	
		TreeNode<T> curr = root;
		TreeNode<T> prev = null;
		int depth = 1;
		int maxDepth = depth;
		while(curr != null) {
			if(curr.getParent() == prev) { //if we came from curr's parent...
				if(curr.getLeftChild() != null) { //if curr has a left-child, go to it
					prev = curr;
				    curr = curr.getLeftChild();
				    depth++;
				    maxDepth = Math.max(maxDepth, depth);
				} else if(curr.getRightChild() != null) { //else if curr has a right-child, go to it
				    prev = curr;
				    curr = curr.getRightChild();
				    depth++;
				    maxDepth = Math.max(maxDepth, depth);
				} else { //else, return to the parent
				    prev = curr;
				    curr = curr.getParent();
				    depth--;
				}
			} else if(curr.getLeftChild() == prev) { //if we came from curr's left-child
				if(curr.getRightChild() != null) { //if curr has a right-child, go to it
				    prev = curr;
				    curr = curr.getRightChild();
				    depth++;
				    maxDepth = Math.max(maxDepth, depth);
				} else { //else, return to the parent 
					prev = curr;
					curr = curr.getParent();
					depth--;
				}
			} else if(curr.getRightChild() == prev) { //if we came from curr's right-child
				//return to the parent
				prev = curr;
				curr = curr.getParent();
				depth--;
			} else {
				throw new IllegalStateException("Current/Previous: "+curr.getValue()+", "+prev.getValue());
			}
		}
		return maxDepth;
   }

    /**
     * 
     * @return
     */
    public void treeWalk() {
    	
		if(root == null) {
			System.out.println("[empty]");
			return;
		}
	
		TreeNode<T> curr = root;
		TreeNode<T> prev = null;

		while(curr != null) {
			//preorder processing:
//			if(curr.getParent() == prev) {
//				System.out.println(curr);
//			}
			//end preorder processing

			//inorder processing:
//			if(curr.getLeftChild() == prev || curr.getLeftChild() == null) {
//				System.out.println(curr);
//			}
			//end inorder processing

			//postorder processing: still doesn't work for no right child of root
			if( curr.getRightChild() == prev || 
				(curr.getLeftChild() == prev && curr.getRightChild() == null) ||
				(curr.getLeftChild() == null && curr.getRightChild() == null) ){
				System.out.println(curr);
			}
			//end postorder processing
			
			if(curr.getParent() == prev) { //if we came from curr's parent...
				if(curr.getLeftChild() != null) { //if curr has a left-child, go to it
					prev = curr;
				    curr = curr.getLeftChild();
				} else if(curr.getRightChild() != null) { //else if curr has a right-child, go to it
				    prev = curr;
				    curr = curr.getRightChild();
				} else { //else, return to the parent
				    prev = curr;
				    curr = curr.getParent();
				}
			} else if(curr.getLeftChild() == prev) { //if we came from curr's left-child
				if(curr.getRightChild() != null) { //if curr has a right-child, go to it
				    prev = curr;
				    curr = curr.getRightChild();
				} else { //else, return to the parent 
					prev = curr;
					curr = curr.getParent();
				}
			} else if(curr.getRightChild() == prev) { //if we came from curr's right-child
				//return to the parent
				prev = curr;
				curr = curr.getParent();
			} else {
				throw new IllegalStateException("Current/Previous: "+curr.getValue()+", "+prev.getValue());
			}
		}
		return;
   }
    
    /**
     * Computes the depth of the given node in the tree by traversing back to 
     * the root and keeping a counter
     * @param node
     * @return
     */
    private int getDepth(TreeNode<T> node) {
		int depth = 0;
		TreeNode<T> curr = node;
		while(curr != root) {
		    curr = curr.getParent();
		    depth++;
		}
		return depth;
    }

    /**
     * Adds the element to the tree at the shallowest available spot, utilizes a
     * queue data structure to perform a Breadth-First Traversal of the tree to
     * find the shallowest available spot.
     * @param item
     */
    public void addElement(T item) {
		if(item == null)
		    throw new IllegalArgumentException("BinaryTree does not allow null elements");
		if(containsElement(item))
		    return;
		TreeNode<T> newNode = new TreeNode<T>(item);
		if(root == null) {
		    root = newNode;
		    return;
		}
	
		Queue<TreeNode<T>> q = new LinkedList<TreeNode<T>>();
		q.offer(root);
		//BFS
		boolean inserted = false;
		while(!q.isEmpty() && !inserted) {
		    TreeNode<T> curr = q.poll();
		    if(curr.getLeftChild() == null) {
				newNode.setParent(curr);
				curr.setLeftChild(newNode);
				inserted = true;
		    } else if(curr.getRightChild() == null) {
				newNode.setParent(curr);
				curr.setRightChild(newNode);
	            inserted = true;
		    } else {
				q.offer(curr.getLeftChild());
				q.offer(curr.getRightChild());
		    }
		}
    }

    /**
     * Traverses the tree in an preorder traversal using a stack
     */
    @Override
    public String toString() {
    	if(root == null) {
    		return "[empty]";
    	}
	
		StringBuilder sb = new StringBuilder();
		Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
		TreeNode<T> curr = root;
		while(curr != null) {
		    if(curr.getRightChild() != null) {
		    	s.push(curr.getRightChild());
		    }
		    if(curr.getLeftChild() != null) {
	            s.push(curr.getLeftChild());
		    }
	
		    for(int i=0; i<getDepth(curr); i++) {
		    	sb.append(" ");
		    }
		    sb.append("|-"+curr.getValue()+"\n");
		    if(s.isEmpty())  {
		    	curr = null;
		    } else {
		    	curr = s.pop();
		    }
		}
		return sb.toString();
    }

    public void traverse() {
    	traverse(this.root, 0);
    }

    /**
     * Traverses the tree in a recursive, preorder traversal and prints it out 
     * in an ASCII art-style
     * @param node
     * @param depth
     */
    private void traverse(TreeNode<T> node, int depth) {
		if(node == null) return;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<depth; i++) {
		    sb.append(" ");
		}
		sb.append("|-");
		sb.append(node.getValue());
		System.out.println(sb.toString());
		traverse(node.getLeftChild(), depth+1);
		traverse(node.getRightChild(), depth+1);
    }

    public static void main(String args[]) {
		BinaryTree<Integer> bt = new BinaryTree<Integer>(); 
		for(int i=0; i<2; i++) {
		    bt.addElement(i);
		}
		System.out.println("bt = \n"+bt);
		bt.treeWalk();
    }

}