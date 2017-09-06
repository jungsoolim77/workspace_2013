package chapter19;

import java.util.*;

class GenericStack<E> extends ArrayList<E>{

/** Push a new element into the top of the stack */

public void push(E value) {
	add(value);
}

/** Return and remove the top element from the stack */

public E pop() {
	return remove(size()-1);
}

/** Return the top element from the stack */

public E peek() {
	return get(size()-1);
}

/** Check whether the stack is empty */

public boolean isEmpty() {
	return super.isEmpty();
}

/** Return the number of elements in the stack */

public int getSize() {
	return size();
 

}
}