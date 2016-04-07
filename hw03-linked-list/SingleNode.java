/*
 * 
 * DO NOT EDIT/CNAHGE THIS FILE
 *
 *
 */

/*
 * This class composes singly linked lists
 */
public class SingleNode {
	public SingleNode next;
	public String data;
	
	/*
	 * Creates a new SingleNode with the given data
	 */
	public SingleNode(String data) {
		this.next = null;
		this.data = data;
	}
	
	/*
	 * Checks if the given node has equal data
	 * NOTE: can only be used if otherNode is NOT null
	 */
	public boolean equals(SingleNode otherNode) {
		return this.data.equals(otherNode.data);
	}

	public String toString() {
		return data;
	}
}
