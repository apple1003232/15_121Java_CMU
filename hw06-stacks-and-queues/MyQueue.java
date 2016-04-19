
/** 
 * 
 * Interface to specify operations for a simple unbounded 
 * first-in-first-out (FIFO) queue.
 * 
 * 		DO NOT MODIFY THIS FILE
 * 
 */

public interface MyQueue<E> {
	
	/**
	 * Removes and returns the element at the front of this queue.
	 * @return The element removed from the front of this queue.
	 * @throws NoSuchElementException if the queue is empty.
	 *
	 */
	public E dequeue();
	
	/**
	 * Adds the specified element to the back of this queue.
	 * @param element to add on to the back of this queue.
	 */	
	public void enqueue(E element);
	
	/**
	 * Returns true if this queue no elements.
	 * @return true if this queue is empty, false otherwise.
	 */
	public boolean isEmpty();
		
	/**
	 * Returns, but does not remove, the element at the front of this queue.
	 * @return The element at the front of this queue.
	 * @throws NoSuchElementException if the queue is empty.
	 */
	public E peek();
	    

}
