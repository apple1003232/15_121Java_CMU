/*
 *
 * DO NOT CHANGE/EDIT THIS FILE
 *
 */

public class Node {
	public Node next;
	public String data;
	
	public Node(String data) {
		this.next = null;
		this.data = data;
	}
	
	public boolean equals(Node otherNode) {
		return this.data.equals(otherNode.data);
	}
	
	public String toString() {
		return data;
	}
	
	public String print() {
		StringBuffer sb = new StringBuffer();
		Node nodeRef = this;
		
		sb.append("[HEAD] -> ");
		while(nodeRef != null) {
			sb.append(nodeRef.data);
			sb.append(" -> ");
			nodeRef = nodeRef.next;
		}
		sb.append("[TAIL]");
		
		return sb.toString();
	}
}
