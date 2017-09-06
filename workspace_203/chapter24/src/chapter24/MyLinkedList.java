package chapter24;

import java.util.Iterator;



public class MyLinkedList<E> extends MyAbstractList<E> {
	  private Node<E> head, tail;

	  /** Create a default list */
	  public MyLinkedList() {
	  }

	  /** Create a list from an array of objects */
	  public MyLinkedList(E[] objects) {
	    super(objects);
	  }

	  /** Return the head element in the list */
	  public E getFirst() {
	    if (size == 0) {
	      return null;
	    }
	    else {
	      return head.element;
	    }
	  }

	  /** Return the last element in the list */
	  public E getLast() {
	    if (size == 0) {
	      return null;
	    }
	    else {
	      return tail.element;
	    }
	  }

	  /** Add an element to the beginning of the list */
	  public void addFirst(E e) {
	    Node<E> newNode = new Node<E>(e); // Create a new node
	    newNode.next = head; // link the new node with the head
	    head = newNode; // head points to the new node
	    size++; // Increase list size

	    if (tail == null) // the new node is the only node in list
	      tail = head;
	  }

	  /** Add an element to the end of the list */
	  public void addLast(E e) {
	    Node<E> newNode = new Node<E>(e); // Create a new for element e

	    if (tail == null) {
	      head = tail = newNode; // The new node is the only node in list
	    }
	    else {
	      tail.next = newNode; // Link the new with the last node
	      tail = tail.next; // tail now points to the last node
	    }

	    size++; // Increase size
	  }


	  /** Add a new element at the specified index in this list
	   * The index of the head element is 0 */
	  public void add(int index, E e) {
	    if (index == 0) {
	      addFirst(e);
	    }
	    else if (index >= size) {
	      addLast(e);
	    }
	    else {
	      Node<E> current = head;
	      for (int i = 1; i < index; i++) {
	        current = current.next;
	      }
	      Node<E> temp = current.next;
	      current.next = new Node<E>(e);
	      (current.next).next = temp;
	      size++;
	    }
	  }

	  /** Remove the head node and
	   *  return the object that is contained in the removed node. */
	  public E removeFirst() {
	    if (size == 0) {
	      return null;
	    }
	    else {
	      Node<E> temp = head;
	      head = head.next;
	      size--;
	      if (head == null) {
	        tail = null;
	      }
	      return temp.element;
	    }
	  }

	  /** Remove the last node and
	   * return the object that is contained in the removed node. */
	  public E removeLast() {
	    if (size == 0) {
	      return null;
	    }
	    else if (size == 1) {
	      Node<E> temp = head;
	      head = tail = null;
	      size = 0;
	      return temp.element;
	    }
	    else {
	      Node<E> current = head;

	      for (int i = 0; i < size - 2; i++) {
	        current = current.next;
	      }

	      Node<E> temp = tail;
	      tail = current;
	      tail.next = null;
	      size--;
	      return temp.element;
	    }
	  }

	  /** Remove the element at the specified position in this list.
	   *  Return the element that was removed from the list. */
	  public E remove(int index) {
	    if (index < 0 || index >= size) {
	      return null;
	    }
	    else if (index == 0) {
	      return removeFirst();
	    }
	    else if (index == size - 1) {
	      return removeLast();
	    }
	    else {
	      Node<E> previous = head;

	      for (int i = 1; i < index; i++) {
	        previous = previous.next;
	      }

	      Node<E> current = previous.next;
	      previous.next = current.next;
	      current.next = null;
	      size--;
	      return current.element;
	    }
	  }

	  @Override /** Override toString() to return elements in the list */
	  public String toString() {
	    StringBuilder result = new StringBuilder("[");

	    Node<E> current = head;
	    for (int i = 0; i < size; i++) {
	      result.append(current.element);
	      current = current.next;
	      if (current != null) {
	        result.append(", "); // Separate two elements with a comma
	      }
	      else {
	        result.append("]"); // Insert the closing ] in the string
	      }
	    }

	    return result.toString();
	  }

	  /** Clear the list */
	  public void clear() {
	    head = tail = null;
	  }

	  /** Return true if this list contains the element o */
	  public boolean contains(E e) {
	    //System.out.println("Implementation left as an exercise");
		  Node<E> current = head;
		  Iterator iterator = this.iterator(); 
		  E element;
		  
		  while(iterator.hasNext()){
			  element = (E) iterator.next();
			  if(((E) iterator.next()).equals(e))
				  return true;
//			  if(element.equals(e)){
//				  return true;
//			  }
		  }
		  
		  
//		  while(current != null){
//			  if(current.element.equals(e))
//				  return true;
//			  current = current.next;
//		  }
	    
	    return false;
	  }

	  /** Return the element from this list at the specified index */
	  public E get(int index) {
//	    System.out.println("Implementation left as an exercise");
	    Node<E> current = head;
	    
	    for(int i = 0; i<index; i++){
	    	current = current.next;
	    }
	    return current.element;
	    
	  }

	  /** Return the index of the head matching element in this list.
	   *  Return -1 if no match. */
	  public int indexOf(E e) {
//	    System.out.println("Implementation left as an exercise");
	    int index = 0;
	    Node<E> curr = head;
	    E element;
		Iterator iterator = this.iterator(); 
		
		while(iterator.hasNext()){
			element = (E) iterator.next();
			if(e.equals(element)){
				return index;
			}
			index++;
		}
		
		/*
		
	    while (curr != null){
	   
	    	if(curr.element.equals(e)){
	    		return index;
	    	}
	    	curr = curr.next;
	    	index++;
	    }*/
		
	    return -1;
	  }

	  /** Return the index of the last matching element in this list
	   *  Return -1 if no match. */
	  public int lastIndexOf(E e) {
	    //System.out.println("Implementation left as an exercise");
		  int index = 0, currIndex = -1;
		  Node<E> current = head;
		  E element;
		  
		  Iterator iterator = this.iterator(); 
		  
		  while(iterator.hasNext()){
			  element = (E) iterator.next();
			  if(e.equals(element)){
				  currIndex = index;
			  }
			  index++;
			  
		  }
		  /*
		  while(current!= null){
			  
			  if((current.element).equals(e)){
				  currIndex = index;
			  }
			  current = current.next;
			  index++;
		  }*/
	    return currIndex;
	  }

	  /** Replace the element at the specified position in this list
	   *  with the specified element. */
	  public E set(int index, E e) {
	    //System.out.println("Implementation left as an exercise");
		Node<E> current = head;
		E temp;
		for(int i=0; i<index; i++){
			current = current.next;
		}
		
		temp = current.element;
		current.element = e;
	    return temp;
	  }

	  @Override 
		public java.util.Iterator<E> iterator() {

			return new LinkedListIterator();
		}
	  /** Define a Node class 
	   * */
	  private static class Node<E> {
		    E element;
		    Node<E> next;

		    public Node(E element) {
		      this.element = element;
		    }
		  }
	  private class LinkedListIterator implements java.util.Iterator<E>{
		 private Node<E> current = head;
		  
		  public boolean hasNext(){
			  return (current != null);
		  }
		  
		  public E next(){
			  E e = current.element;
			  current = current.next;
			  return e;
		  }
		  public void remove(){
			  //System.out.println("Implementation is for exercise");
			  Node<E> temp = head;
			  while(temp != null){
				 if( (temp.next).element.equals(current)){
					 temp.next = current.next;
					 current = null;
					 break;
				 }
				 temp = temp.next;
			  }
			  
			  
		  }
		  
	  }
	}
