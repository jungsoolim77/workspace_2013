package chapter25;

import java.util.LinkedList;
import java.util.Queue;

import chapter25.BSTExcersize.BST.TreeNode;

public class BST<E extends Comparable<E>>
extends AbstractTree<E> implements Cloneable {
protected TreeNode<E> root;
protected int size = 0;

/** Create a default binary tree */
public BST() {
}

/** Create a binary tree from an array of objects */
public BST(E[] objects) {
for (int i = 0; i < objects.length; i++)
  insert(objects[i]);
}

/** Returns true if the element is in the tree */
public boolean search(E e) {
TreeNode<E> current = root; // Start from the root

while (current != null) {
  if (e.compareTo(current.element) < 0) {
    current = current.left;
  }
  else if (e.compareTo(current.element) > 0) {
    current = current.right;
  }
  else // element matches current.element
    return true; // Element is found
}

return false;
}

/** Insert element o into the binary tree
* Return true if the element is inserted successfully */
public boolean insert(E e) {
if (root == null)
  root = createNewNode(e); // Create a new root
else {
  // Locate the parent node
  TreeNode<E> parent = null;
  TreeNode<E> current = root;
  while (current != null)
    if (e.compareTo(current.element) < 0) {
      parent = current;
      current = current.left;
    }
    else if (e.compareTo(current.element) > 0) {
      parent = current;
      current = current.right;
    }
    else
      return false; // Duplicate node not inserted

  // Create the new node and attach it to the parent node
  if (e.compareTo(parent.element) < 0)
    parent.left = createNewNode(e);
  else
    parent.right = createNewNode(e);
}

size++;
return true; // Element inserted
}

protected TreeNode<E> createNewNode(E e) {
return new TreeNode<E>(e);
}

/** Inorder traversal from the root*/
public void inorder() {
inorder(root);
}

/** Inorder traversal from a subtree */
protected void inorder(TreeNode<E> root) {
if (root == null) return;
inorder(root.left);
System.out.print(root.element + " ");
inorder(root.right);
}

/** Postorder traversal from the root */
public void postorder() {
postorder(root);
}

/** Postorder traversal from a subtree */
protected void postorder(TreeNode<E> root) {
if (root == null) return;
postorder(root.left);
postorder(root.right);
System.out.print(root.element + " ");
}

/** Preorder traversal from the root */
public void preorder() {
preorder(root);
}

/** Preorder traversal from a subtree */
protected void preorder(TreeNode<E> root) {
if (root == null) return;
System.out.print(root.element + " ");
preorder(root.left);
preorder(root.right);
}

/** Inner class tree node */
public static class TreeNode<E extends Comparable<E>> {
E element;
TreeNode<E> left;
TreeNode<E> right;

public TreeNode(E e) {
  element = e;
}
}

/** Get the number of nodes in the tree */
public int getSize() {
return size;
}

/** Returns the root of the tree */
public TreeNode<E> getRoot() {
return root;
}

/** Returns a path from the root leading to the specified element */
public java.util.ArrayList<TreeNode<E>> path(E e) {
java.util.ArrayList<TreeNode<E>> list =
  new java.util.ArrayList<TreeNode<E>>();
TreeNode<E> current = root; // Start from the root

while (current != null) {
  list.add(current); // Add the node to the list
  if (e.compareTo(current.element) < 0) {
    current = current.left;
  }
  else if (e.compareTo(current.element) > 0) {
    current = current.right;
  }
  else
    break;
}

return list; // Return an array of nodes
}

/** Delete an element from the binary tree.
* Return true if the element is deleted successfully
* Return false if the element is not in the tree */
public boolean delete(E e) {
// Locate the node to be deleted and also locate its parent node
TreeNode<E> parent = null;
TreeNode<E> current = root;
while (current != null) {
  if (e.compareTo(current.element) < 0) {
    parent = current;
    current = current.left;
  }
  else if (e.compareTo(current.element) > 0) {
    parent = current;
    current = current.right;
  }
  else
    break; // Element is in the tree pointed by current
}

if (current == null)
  return false; // Element is not in the tree

// Case 1: current has no left children
if (current.left == null) {
  // Connect the parent with the right child of the current node
  if (parent == null) {
    root = current.right;
  }
  else {
    if (e.compareTo(parent.element) < 0)
      parent.left = current.right;
    else
      parent.right = current.right;
  }
}
else {
  // Case 2: The current node has a left child
  // Locate the rightmost node in the left subtree of
  // the current node and also its parent
  TreeNode<E> parentOfRightMost = current;
  TreeNode<E> rightMost = current.left;

  while (rightMost.right != null) {
    parentOfRightMost = rightMost;
    rightMost = rightMost.right; // Keep going to the right
  }

  // Replace the element in current by the element in rightMost
  current.element = rightMost.element;

  // Eliminate rightmost node
  if (parentOfRightMost.right == rightMost)
    parentOfRightMost.right = rightMost.left;
  else
    // Special case: parentOfRightMost == current
    parentOfRightMost.left = rightMost.left;     
}

size--;
return true; // Element inserted
}

/** Obtain an iterator. Use inorder. */
public java.util.Iterator iterator() {
return inorderIterator();
}

/** Obtain an inorder iterator */
public java.util.Iterator inorderIterator() {
return new InorderIterator();
}

// Inner class InorderIterator
class InorderIterator implements java.util.Iterator {
// Store the elements in a list
private java.util.ArrayList<E> list =
  new java.util.ArrayList<E>();
private int current = 0; // Point to the current element in list

public InorderIterator() {
  inorder(); // Traverse binary tree and store elements in list
}

/** Inorder traversal from the root*/
private void inorder() {
  inorder(root);
}

/** Inorder traversal from a subtree */
private void inorder(TreeNode<E> root) {
  if (root == null)return;
  inorder(root.left);
  list.add(root.element);
  inorder(root.right);
}

/** Next element for traversing? */
public boolean hasNext() {
  if (current < list.size())
    return true;

  return false;
}

/** Get the current element and move cursor to the next */
public Object next() {
  return list.get(current++);
}

/** Remove the current element and refresh the list */
public void remove() {
  delete(list.get(current)); // Delete the current element
  list.clear(); // Clear the list
  inorder(); // Rebuild the list
}
}

/** Remove all elements from the tree */
public void clear() {
root = null;
size = 0;
}

public Object clone() {
BST<E> tree1 = new BST<E>();

copy(root, tree1);

return tree1;
}

private void copy(TreeNode<E> root, BST<E> tree) {
if (root != null) {
  tree.insert(root.element);
  copy(root.left, tree);
  copy(root.right, tree);
}
}

public void breadthFirstSearch(){
	breadthFirstSearch(root);
}

protected void breadthFirstSearch(TreeNode<E> root){
	Queue<TreeNode<E>> queue = new LinkedList<>();
	
	if(root == null){
		System.out.println("Empty tree.");
		return;
	}
		
	queue.add(root);
	
	while(!queue.isEmpty()){
		TreeNode<E> temp = queue.poll();
		System.out.println(temp.element.toString());
		if(temp.left!= null)	queue.add(temp.left);
		if(temp.right!= null)	queue.add(temp.right);
	}
	
}

public int height(){
	return height(root);
}

private int height(TreeNode<E> root) {
    if (root == null) {
      return 0;
    } else {
      return 1 + Math.max(height(root.left), height(root.right));
    }
  }

public int getNumberOfLeaves(){
	return getNumberOfLeaves(root);
}

protected int getNumberOfLeaves(TreeNode<E> root){
     if (root == null)
        return 0;
      else if (root.left == null && root.right == null)
        return 1;
      else
        return getNumberOfLeaves(root.left) 
        		+ getNumberOfLeaves(root.right);
}

public int getNumberOfNonLeaves(){
	return getNumberOfNonLeaves(root);
}

protected int getNumberOfNonLeaves(TreeNode<E> root){
     if (root == null)
        return 0;
      else if (root.left != null || root.right != null)
        return 1 + getNumberOfNonLeaves(root.left) 
        	+ getNumberOfNonLeaves(root.right);
      else
        return 0;
}

protected int nonRecursiveGetNumberOfNonLeaves(TreeNode<E> root){
	Queue<TreeNode<E>> queue = new LinkedList<>();
	int total = 0;
	
	if(root == null){
//		System.out.println("Empty tree.");
		return 0;
	}
		
	queue.add(root);
	
	while(!queue.isEmpty()){
		TreeNode<E> temp = queue.poll();
		if(temp.left != null || temp.right!= null) total++;
		if(temp.left!= null)	queue.add(temp.left);
		if(temp.right!= null)	queue.add(temp.right);
	}
	return total;
}

protected int nonRecursiveGetNumberOfLeaves(TreeNode<E> root){
	Queue<TreeNode<E>> queue = new LinkedList<>();
	int total = 0;
	
	if(root == null){
//		System.out.println("Empty tree.");
		return 0;
	}
		
	queue.add(root);
	
	while(!queue.isEmpty()){
		TreeNode<E> temp = queue.poll();
		if(temp.left == null & temp.right == null) total++;
		if(temp.left!= null)	queue.add(temp.left);
		if(temp.right!= null)	queue.add(temp.right);
	}
	return total;
}

/** Inorder traversal from the root non-recursive*/

public String nonRecursiveInorder() {
	java.util.List<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
    nonRecursiveInorder(root, list);
    
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    
    for (int i = 0; i < list.size(); i++){
    	sb.append(((TreeNode<E>) (list.get(i))).element + ", ");
        //System.out.print(((TreeNode<E>) (list.get(i))).element + " ");
    }
    sb.append("]");
    return sb.toString();
  }

public java.util.List<TreeNode<E>> nonRecursiveInorder(TreeNode<E> root, java.util.List<TreeNode<E>> list)  {
	//java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
    java.util.Stack<TreeNode<E>> stack = new java.util.Stack<TreeNode<E>>();

    if (root == null)
      return null;
    
    stack.push(root);
    
    while (!stack.isEmpty()) {
        TreeNode<E> node = (TreeNode<E>) (stack.peek());
        if (node.left != null && !list.contains(node.left)) {
          stack.push(node.left); // Add the left node to the stack
        } else {
          stack.pop(); // Remove the node from the stack
          list.add(node);
          if (node.right != null) {
            stack.push(node.right); // Add the right node to the stack
          }
        }
      }
  for (int i = 0; i < list.size(); i++)
  System.out.print(((TreeNode<E>) (list.get(i))).element + " ");
   return list;

    
}

/** Preorder traversal from the root non-recursive*/

public String nonRecursivePreorder() {
	java.util.List<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
    nonRecursivePreorder(root, list);
    
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    
    for (int i = 0; i < list.size(); i++){
    	sb.append(((TreeNode<E>) (list.get(i))).element + ", ");
        //System.out.print(((TreeNode<E>) (list.get(i))).element + " ");
    }
    sb.append("]");
    return sb.toString();
  }

public java.util.List<TreeNode<E>> nonRecursivePreorder(TreeNode<E> root, java.util.List<TreeNode<E>> list)  {
	//java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
    java.util.Stack<TreeNode<E>> stack = new java.util.Stack<TreeNode<E>>();

    if (root == null)
      return null;
    
    stack.push(root);
    
    while (!stack.isEmpty()) {
        TreeNode<E> node = (TreeNode<E>) (stack.pop());
        list.add(node);
        
        if (node.right != null && !list.contains(node.right)) {
          stack.push(node.right); // Add the right node to the stack
        }  
        if(node.left != null && !list.contains(node.left)) {
          stack.push(node.left); // Add the right node to the stack
        }
      }
  for (int i = 0; i < list.size(); i++)
  System.out.print(((TreeNode<E>) (list.get(i))).element + " ");
   return list;

    
}

/** Postorder traversal from the root non-recursive*/

public String nonRecursivePostorder() {
	java.util.List<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
    nonRecursivePostorder(root, list);
    
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    
    for (int i = 0; i < list.size(); i++){
    	sb.append(((TreeNode<E>) (list.get(i))).element + ", ");
        //System.out.print(((TreeNode<E>) (list.get(i))).element + " ");
    }
    sb.append("]");
    return sb.toString();
  }

public java.util.List<TreeNode<E>> nonRecursivePostorder(TreeNode<E> root, java.util.List<TreeNode<E>> list)  {
	//java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
    java.util.Stack<TreeNode<E>> stack = new java.util.Stack<TreeNode<E>>();

    if (root == null)
      return null;
    
    stack.push(root);
    
    while (!stack.isEmpty()) {
        TreeNode<E> node = (TreeNode<E>) (stack.peek());
        if (node.left != null && !list.contains(node.left)) {
          stack.push(node.left); // Add the left node to the stack
        } else if (node.right != null && 
        		!list.contains(node.right)){
        	stack.push(node.right);
        }
        else {
        	stack.pop();
        	list.add(node); 
          }
        }
  for (int i = 0; i < list.size(); i++)
  System.out.print(((TreeNode<E>) (list.get(i))).element + " ");
   return list;

    
}
}
