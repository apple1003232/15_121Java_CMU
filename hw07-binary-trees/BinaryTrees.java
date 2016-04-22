/**
 * 
 * @author [First Name] [Last Name] <[ID]>
 * @section [Section Letter]
 * @date [date]
 *
 */

// You may not import any additional classes and packages.
import java.util.*;

public class BinaryTrees {
    public static int countLeavesAtLevel(TreeNode<Integer> t, int level){
    	int count = 1, curLevel = 0;
    	Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
    	if(t == null) return 0;
    	q.add(t);
    	while(!q.isEmpty()){
    		if(q.size() == count){
    			curLevel ++;
    			if(curLevel == level)
    				return count;
    			count = 0;
    		}
    		TreeNode<Integer> tmp = q.remove();
    		if(tmp.left != null) {
    			q.add(tmp.left);
    			count ++;
    		}
    		if(tmp.right != null){
    			q.add(tmp.right);
    			count ++;
    		}
    		
    	}
    	
      return 0; // remove this line when you are done with this method
    }

    public static boolean isPerfect(TreeNode<Integer> t){
    	if(t == null) return true;
    	Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
    	q.add(t);
    	double count = 1, depth = 0;
    	while(!q.isEmpty()){
    		if(q.size() == count){
    			if(count != Math.pow(2, depth))
    				return false;
    			depth++;
    			count = 0;
    		}
    		TreeNode<Integer> tmp = q.remove();
    		if(tmp.left != null) {
    			q.add(tmp.left);
    			count ++;
    		}
    		if(tmp.right != null){
    			q.add(tmp.right);
    			count ++;
    		}
    	}
    	return true;
    }
    
    
    public static boolean isFull(TreeNode<Integer> t){
    	if(t == null) return true;
    	if(t.left == null && t.right == null) return true;
    	if(t.left == null && t.right != null) return false;
    	if(t.left != null && t.right == null) return false;
    	return (isFull(t.left) && isFull(t.right));
    }

    public static boolean isSubset(TreeNode<String> t1, TreeNode<String> t2){
    	Set<String> s1 = new HashSet<String>();
    	Set<String> s2 = new HashSet<String>();
    	preOrder(t1, s1);
    	preOrder(t2, s2);
    	return s2.containsAll(s1);
    }
    private static void preOrder(TreeNode<String> t, Set<String> s){
    	if(t == null) return;
    	s.add(new String(t.data));
    	preOrder(t.left, s);
    	preOrder(t.right, s);
    }

    public static boolean areEqual(TreeNode<String> t1, TreeNode<String> t2){
    	if(t1 == null && t2 == null) return true;
    	if(t1 == null || t2 == null) return false;
    	if(!t1.data.equals(t2.data)) return false;
    	return areEqual(t1.left, t2.left) && areEqual(t1.right, t2.right);
    }

    public static TreeNode<Integer> mirror(TreeNode<Integer> t){
    	if (t == null)
    		return null;
    	TreeNode<Integer> tmp = copy(t);
    	tmp.right = mirrorRight(t).right;
    	return tmp;
    }
    
    private static TreeNode<Integer> mirrorRight(TreeNode<Integer> t){
    	if(t == null) return null;
    	TreeNode<Integer> tmp = new TreeNode<Integer>(t.data);
    	tmp.right = mirrorRight(t.left);
    	if(t.right != null) tmp.left = new TreeNode<Integer>(t.right.data);
    	return tmp;
    }
    private static TreeNode<Integer> copy(TreeNode<Integer> t){
    	if(t == null) return null;
    	TreeNode<Integer> tmp = new TreeNode<Integer>(t.data);
    	tmp.left = copy(t.left);
    	tmp.right = copy(t.right);
    	return tmp;
    }
    
    public static boolean isBinarySearchTree(TreeNode<Integer> t){
        return validBST(t, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean validBST(TreeNode<Integer> t, int min, int max){
    	if(t == null) return true;
    	if(t.data <= min || t.data >= max) return false;
    	return validBST(t.left, min, t.data) && validBST(t.right, t.data, max);
    }
//    public static void main(String[] args){
////    	System.out.println("ssss");
//    	//TreeDisplay<String> display = new TreeDisplay<String>();
//    	TreeNode<String> root = new TreeNode<String>("0");
//    	TreeNode<String> r1 = new TreeNode<String>("1");
//    	TreeNode<String> r2 = new TreeNode<String>("2");
//    	TreeNode<String> r3 = new TreeNode<String>("3");
//    	TreeNode<String> r4 = new TreeNode<String>("4");
//    	root.left = r1;
//    	root.right = r2;
//    	r1.left = r3;
//    	//r2.right = r4;
//    	
//    	TreeNode<String> root1 = new TreeNode<String>("0");
//    	TreeNode<String> r11 = new TreeNode<String>("1");
//    	TreeNode<String> r21 = new TreeNode<String>("2");
//    	TreeNode<String> r31 = new TreeNode<String>("3");
//    	TreeNode<String> r41 = new TreeNode<String>("4");
//    	root1.left = r11;
//    	root1.right = r21;
//    	r11.left = r41;
//    	r21.right = r31;
//        //display.setRoot(root1); // where <root> is a TreeNode<String>.
////        System.out.println(countLeavesAtLevel(root, 3));
////        System.out.println(areEqual(root,root1));
//        TreeNode<Integer> root2 = new TreeNode<Integer>(0);
//    	TreeNode<Integer> r12 = new TreeNode<Integer>(-1);
//    	TreeNode<Integer> r22 = new TreeNode<Integer>(2);
//    	TreeNode<Integer> r32 = new TreeNode<Integer>(-3);
//    	TreeNode<Integer> r42 = new TreeNode<Integer>(-4);
//    	TreeNode<Integer> r52 = new TreeNode<Integer>(0);
//    	TreeNode<Integer> r62 = new TreeNode<Integer>(3);
//    	root2.left = r12;
//    	root2.right = r22;
//    	r12.left = r32;
//    	r12.right = r42;
////    	r22.left = r52;
////    	r22.right = r62;
//    	TreeDisplay<Integer> td = new TreeDisplay<Integer>();
////    	td.setRoot(root2);
////        System.out.println(isSubset(root,root1));
////        System.out.println(isBinarySearchTree(root2));
////        System.out.println(isFull(root2));
//        td.setRoot(mirror(root2));
//    }
}
