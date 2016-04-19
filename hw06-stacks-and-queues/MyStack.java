/** 
 * 
 * Interface to specify operations for a simple unbounded 
 * last-in-last-out (LIFO) stack.
 * 
 * 		DO NOT MODIFY THIS FILE
 * 
 */

public interface MyStack<E> {

	/**
	 * Returns true if this stack has no elements
	 * @return true if this stack is empty, false otherwise
	 *
	 */
	public boolean isEmpty();

	/**
	 * Returns, but does not remove, the top element of this stack.
	 * @return The top element of the stack
	 * @throws NoSuchElementException if this stack is empty
	 */
	public E peek();

	/**
	 * Returns and removes the top element from this stack.
	 * @return The top element of this stack
	 * @throws NoSuchElementException if this stack is empty
	 */
	public E pop();

	/**
	 * Pushes the specified element on this stack
	 * @param element The element of type E to push on the stack.
	 */	
	public void push(E element);



}
