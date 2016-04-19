/**
 * 
 * @author [First Name] [Last Name] <Andrew ID>
 * @section [Section Letter]
 *
 */

import java.util.*;

public class ArrayStack<E> implements MyStack<E> {

	private E[] dataArray;
	private int top;

	/**
	 * Creates an empty stack.
	 * 
	 */
	public ArrayStack() {
		dataArray = (E[])new Object[2];
		top = 0;
	}

	/**
	 * Determines if the stack is empty or not.
	 * 
	 * @return true if the stack is empty or false otherwise
	 * 
	 */
	public boolean isEmpty() {
		if(top == 0) return true;
		else return false;
	}
	
	/**
	 * Returns but does not remove the top element of the stack if the stack is
	 * not empty.
	 * 
	 * @return The top element of the stack
	 * @throws NoSuchElementException
	 *           if the stack is empty
	 *           
	 */
	public E peek() {
		if(top > 0)
			return dataArray[top - 1];
		else throw new NoSuchElementException();
	}
	

	/**
	 * Pushes the given element on this stack
	 * 
	 * @param element
	 *          The element of type E to push on the stack.
	 *          
	 */
	public void push(E element) {
		if(top < dataArray.length) dataArray[top++] = element;
		else{
			E[] array = (E[]) new Object[2*dataArray.length];
			for(int i = 0; i < dataArray.length; i++){
				array[i] = dataArray[i];
			}
			dataArray = array;
			dataArray[top++] = element;
		}
	}

	

	/**
	 * Returns and removes the top element of the stack if the stack is not empty.
	 * 
	 * @return The top element of the stack
	 * @throws NoSuchElementException
	 *           if the stack is empty
	 *           
	 */
	public E pop() {
		if(top > 0){
			return dataArray[--top];
		}else throw new NoSuchElementException();
	}

	/**
	 * Returns a String representation of the stack in the following format top [
	 * 3 5 ] bottom
	 * 
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if(top == 0){
			sb.append("top [ ] bottom");
		}else{
			sb.append("top [ ");
			int tmp = top;
			while(tmp != 0){
				sb.append(dataArray[--tmp]);
				sb.append(" ");
			}
			sb.append("] bottom");
		}
		return sb.toString();
	}

}
