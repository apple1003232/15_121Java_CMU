/**
 * 
 * @author [First Name] [Last Name] <[Andrew ID]>
 * @setion [Section Letter]
 *    
 */

import java.util.*;

public class TwoStackQueue<E> implements MyQueue<E> {

	private MyStack<E> out;
	private MyStack<E> in;

	public TwoStackQueue() {
		out = new ArrayStack<E>();
		in = new ArrayStack<E>();

	}

	/**
	 * Returns true if this queue no elements.
	 * 
	 * @return true if this queue is empty, false otherwise.
	 * 
	 */
	public boolean isEmpty() {
		if(in.isEmpty() && out.isEmpty()) return true;
		else return false;
	}

	/**
	 * Adds the specified element to the end of the queue.
	 * 
	 * @param The
	 *          element to add on to the end of the queue.
	 *          
	 */
	public void enqueue(E element) {
		in.push(element);
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
		if(out.isEmpty()){
			while(!in.isEmpty())
				out.push(in.pop());
		}
		if(out.isEmpty()) throw new NoSuchElementException();
		else return out.pop();
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
		if(out.isEmpty()){
			while(!in.isEmpty())
				out.push(in.pop());
		}
		if(out.isEmpty()) throw new NoSuchElementException();
		else return out.peek();
	}

	/**
	 * Returns a String representation of this queue. If the queue will dequeue
	 * values 5 7 8 in that order, and the out stack contains one value, the
	 * string will have following format.
	 * 
	 * front [ 5 | 7 8 ] back
	 * 
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("front [ ");
		MyStack<E> tmp = new ArrayStack<E>();
		while(!out.isEmpty()){
			sb.append(out.peek());
			sb.append(" ");
			tmp.push(out.pop());
		}
		sb.append("| ");
		while(!tmp.isEmpty()){
			out.push(tmp.pop());
		}
		while(!in.isEmpty()){
			tmp.push(in.pop());
		}
		while(!tmp.isEmpty()){
			sb.append(tmp.peek());
			sb.append(" ");
			in.push(tmp.pop());
		}
		sb.append("] back");
		return sb.toString();
	}

}
