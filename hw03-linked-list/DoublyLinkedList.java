/**
 * 
 * @author [First Name] [Last Name] <[Andrew ID]>
 * @section [Section Letter]
 * @date [date]
 * 
 * 
 */

import java.util.*;

public class DoublyLinkedList<E> {
	// Do not change these fields.
	public DoubleNode<E> currNode;
	public int numElements;

	public DoublyLinkedList() {
		currNode = null;
		numElements = 0;
	}

	/**
	 * Complete the size method, which returns the number of data values in 
	 * the DoublyLinkedList in O(1) time.
	 */
	public int size() {
		//write your code for the size method here
		return numElements; //remove this line when you are done
	}

	/**
	 * Complete the get method, which returns the current data value in 
	 * O(1) time. If the DoublyLinkedList is empty, this method should 
	 * throw a NoSuchElementException.
	 */
	public E get() {
		//write your code for the get method here
		try{
			return currNode.data;
		}catch(NoSuchElementException ex){
			System.out.println(ex);
		}
		return null;
	}

	/**
	 * Complete the add method, which adds the given element after the 
	 * current data value (if any). After this method executes, currNode 
	 * should refer to the node with the new element, and currNode.prev 
	 * should refer to the node that used to be currNode (if any) in O(1) time.
	 * 
	 */
	public void add(E item) {
		//write your code for the add method here
		numElements ++;
		if(currNode == null){
			DoubleNode<E> ele = new DoubleNode<E>(item);
			ele.prev = ele;
			ele.next = ele;
			currNode = ele;
			return;
		}
		
		DoubleNode<E> ele = new DoubleNode<E>(item);
		currNode.next.prev = ele;
		ele.next = currNode.next;
		ele.prev = currNode;
		currNode.next = ele;
		currNode = ele;
		
	}

	/**
	 * Complete the toList method, which should return a List (an instance 
	 * of a class that implements Java's List interface) containing all 
	 * the data values in the DoublyLinkedList, ending with the current 
	 * data value in O(n) time.
	 */
	public List<E> toList() {
		//write your code for the toList method here
		List<E> list = new ArrayList<E>();
		
		for(int i = 0; i < numElements; i++){
			list.add(currNode.next.data);
			currNode = currNode.next;
		}
		return list; //remove this line when you are done
	}

	/**
	 * Complete the contains method, which returns true if the given element 
	 * appears in the DoublyLinkedList, and returns false otherwise. This 
	 * method must run in worst-case O(n) time and best-case O(1) time.
	 * This method should not remove any elements from the DoublyLinkedList.
	 */
	public boolean contains(E item) {
		//write your code for the contains method here
		DoubleNode<E> tmp = currNode;
		for(int i = 0; i < numElements; i++){
			if(tmp.data == item)
				return true;
			else
				tmp = tmp.next;
		}
		return false; //remove this line when you are done
	}

	/**
	 * Complete the scroll method, which should advance currNode forward 
	 * (following "next" references) by the given number of nodes. 
	 * If the given number is negative, then scroll will scroll backward 
	 * (following "prev" references) in the cycle. If the DoublyLinkedList is 
	 * empty, this method should throw a NoSuchElementException. Otherwise, 
	 * this method must run in O(n) time, where n is the absolute value 
	 * of the argument value.
	 */
	public void scroll(Integer n) {
		//write your code for the scroll method here
		while(n < 0)
			n += numElements;
		while(n != 0){
			currNode = currNode.next;
			n -- ;
		}
	}

	/**
	 * Complete the remove method, which removes and returns the current data 
	 * value (if any). After the method has executed, currNode should refer 
	 * to the node before the removed one (if any). Thus, if any nodes remain 
	 * after remove has executed, currNode.next will refer to the node that 
	 * used to be currNode. If the DoublyLinkedList is empty (and therefore 
	 * there is no element to remove), then remove should throw a 
	 * NoSuchElementException. Otherwise this method must run in O(1) time.
	 */
	public E remove() {
		//write your code for the remove method here
		try{
			currNode.prev.next = currNode.next;
			currNode.next.prev = currNode.prev;
			E data = currNode.data;
			currNode = currNode.prev;
			numElements --;
			return data;
		}catch(NoSuchElementException ex){
			System.out.println(ex);
		}
		return null;
		
		
	}
	
	
//	public static void main(String[] args){
//		DoublyLinkedList<String> cycle = new DoublyLinkedList<String>();
//	    cycle.add("E");
//	    cycle.add("A");
//	    cycle.add("T");
//
//	    int n = cycle.size();   // returns 3
//	    System.out.println(n);
//
//	    String s = cycle.get(); // returns T
//	    System.out.println(s);
//	    cycle.scroll(1);        // scrolls forward 1 position (wrapping around)
//	    s = cycle.get();        // returns E
//	    System.out.println(s);
//
//	    cycle.scroll(-5);       // scrolls backward 5 positions (wrapping around twice)
//	    s = cycle.get();        // returns A
//	    System.out.println(s);
//	}
}
