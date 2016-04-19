/**
 * 
 * @author [First Name] [Last Name] <Andrew ID>
 * @section [Section Letter]
 * 
 */

import java.util.*;

public class ArrayQueue<E> implements MyQueue<E> {

	private E[] dataArray;
	private int front; //index of first item to remove
	private int back;  //index of last item to remove
	private int numOfElements; // for convenience

	public ArrayQueue() {
		dataArray = (E[])new Object[2];
		front = 0;
		back = 0;
		numOfElements = 0;
	}

	/**
	 * Returns true if this queue no elements.
	 * 
	 * @return true if this queue is empty, false otherwise.
	 * 
	 */
	public boolean isEmpty() {
		if(numOfElements == 0) return true;
		else return false;
	}
	
	

	/**
	 * Returns, but does not remove, the element at the front of this queue.
	 * 
	 * @return The element at the front of this queue.
	 * @throws NoSuchElementException
	 *           if the queue is empty.
	 *           
	 */
	public E peek() {
		try{
			return dataArray[front];
		}catch(NoSuchElementException ex){
			System.out.println(ex);
			return null;
		}
	}
	
	
	/**
	 * Adds the specified element to the back of this queue.
	 * 
	 * @param element
	 *          to add on to the back of this queue.
	 *          
	 */
	public void enqueue(E element) {
		if(numOfElements < dataArray.length){
			dataArray[back] = element;
			back = (back + 1) % dataArray.length;
			numOfElements ++;
		}
		else{
			E[] array = (E[]) new Object[2*dataArray.length];
			int j = 0;
			for(int i = front; i < numOfElements + front; i++){
				array[j] = dataArray[i % dataArray.length];
				j ++;
			}
			dataArray = array;
			dataArray[j++] = element;
			front = 0;
			back = j;
			numOfElements ++;
		}
	}
	
	

	/**
	 * Removes and returns the element at the front of this queue.
	 * 
	 * @return The element removed from the front of this queue.
	 * @throws NoSuchElementException
	 *           if the queue is empty.
	 *           
	 */
	public E dequeue() {
		
		if(numOfElements > 0){
			numOfElements --;
			E res = dataArray[front];
			front = (front + 1) % dataArray.length;
			return res;
		}else throw	new NoSuchElementException();
		
	}


	/**
	 * Returns a String representation of this queue in the format described in
	 * the writeup
	 * 
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("num: ");
		sb.append(numOfElements);
		sb.append("\nfront: ");
		sb.append(front);
		sb.append(" back: ");
		sb.append(back);
		
		sb.append("\nfront [ ");
		for(int i = front; i < numOfElements + front; i++){
			sb.append(dataArray[i % dataArray.length]);
			sb.append(" ");
		}
		sb.append("] back");
		return sb.toString();	
	}

}
