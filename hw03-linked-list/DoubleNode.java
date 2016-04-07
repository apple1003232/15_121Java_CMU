/*
 * 
 * DO NOT CHANGE/EDIT THIS FILE
 *
 */

/*
 * This class composes doubly linked lists
 */
public class DoubleNode<E> {
	public DoubleNode<E> prev;
	public E data;
	public DoubleNode<E> next;

	/*
	 * Creates a new DoubleNode with the given data
	 */
	public DoubleNode(E data) {
		this.data = data;
	}
	
	/*
	 * Checks if the given node has equal data
	 * NOTE: can only be used if otherNode is NOT null
	 */
	public boolean equals(DoubleNode<E> otherNode) {
		return this.data.equals(otherNode.data);
	}
}
