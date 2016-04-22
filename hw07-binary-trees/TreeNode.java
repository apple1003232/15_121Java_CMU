/*

	DO NOT CHANGE THIS CLASS!
	
	
*/

public class TreeNode<E> {
    public E data;
    public TreeNode<E> left;
    public TreeNode<E> right;

    public TreeNode(E data) {
        this.data = data;
        left = null;
        right = null;
    }

    public TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
