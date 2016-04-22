/**
 * 
 * @author [First Name] [Last Name] <[ID]>
 * @section [Section Letter]
 * @date [date]
 *
 */

// You may not import any additional classes and packages.
import java.util.*;

public class Roster {
    public StudentNode root;
    public int numStudents;

    public Roster() {
        root = null;
        numStudents = 0;
    }

    public int size() {
        return numStudents;
    }

    public void addCourse(String name, String course) {
    	if(root == null){
    		root = new StudentNode(name);
    		root.courses.add(course);
    		numStudents ++;
    	}else{
    		StudentNode tmp = root;
    		while(tmp != null){
    			if(tmp.name.equals(name)){
    				tmp.courses.add(course);
    				return;
    			}else if(tmp.name.compareTo(name) > 0){
    				if(tmp.left != null)
    					tmp = tmp.left;
    				else{
    					tmp.left = new StudentNode(name);
    					tmp.left.courses.add(course);
    					numStudents ++;
    					return;
    				}
    			}else{
    				if(tmp.right != null)
    					tmp = tmp.right;
    				else{
    					tmp.right = new StudentNode(name);
    					tmp.right.courses.add(course);
    					numStudents ++;
    					return;
    				}
    			}
    		}
    		
    	}
    }

    public void dropCourseFromAll(String course) {
    	dropCourseHelper(root, course);
    }
    private void dropCourseHelper(StudentNode node, String course){
    	if(node == null) return;
    	if(node.courses.contains(course)) node.courses.remove(course);
    	dropCourseHelper(node.left, course);
    	dropCourseHelper(node.right, course);
    }

    private static void deleteHelper(StudentNode parent, StudentNode tmp, StudentNode next){
    	if(parent.left == tmp){
			parent.left = next;
			return;
		}
		if(parent.right == tmp){
			parent.right = next;
			return;
		}
    }
    public void deleteStudent(String aName) {
    	if(root == null) return;
    	if(root.name.equals(aName)){
    		if(root.left == null && root.right == null)
    			root = null;
    		else if(root.left == null)
    			root = root.right;
    		else
    			root = root.left;
    		return;
    	}
    	
    	StudentNode tmp = root;
    	StudentNode parent = root;
    	while(tmp != null){
    		if(tmp.name.equals(aName)){
    			if(tmp.left == null && tmp.right == null){
    				deleteHelper(parent, tmp, null);
    				return;
    			}else if(tmp.right == null){
    				deleteHelper(parent, tmp, tmp.left);
    				return;
    			}else if(tmp.left == null){
    				deleteHelper(parent, tmp, tmp.right);
    				return;
    			}
    			else{
    				deleteHelper(parent, tmp, inorderSuccessor(tmp));
    				return;
    			}
    			
    		}else if(tmp.name.compareTo(aName) > 0){
    			parent = tmp;
    			tmp = tmp.left;
    		}else{
    			parent = tmp;
    			tmp = tmp.right;
    		}	
    	}
    }
    private static StudentNode inorderSuccessor(StudentNode node){
    	StudentNode parent = node;
    	StudentNode tmp = node;
    	while(tmp.left != null){
    		parent = tmp;
    		tmp = tmp.left;
    	}
    	parent.left = null;
    	tmp.left = node.left;
    	tmp.right = node.right;
    	return tmp;	
    }

    public String toString() {
    	if(root == null) return "There are no students registered.";
    	StringBuffer sb = new StringBuffer();
    	toStringHelper(root, sb);
    	return sb.toString();
    }
    private static void toStringHelper(StudentNode node, StringBuffer sb){
    	if(node == null) return;
    	toStringHelper(node.left, sb);
    	
    	String name = node.name;
    	name = name.substring(0, 1).toUpperCase() + name.substring(1);
    	sb.append(name);
    	if(node.courses.isEmpty()){
    		sb.append(": no courses taken\n");
    	}else{
	    	sb.append(" has taken: ");
	    	Iterator it = node.courses.iterator();
	    	while(it.hasNext()){
	    		sb.append(it.next());
	    		sb.append(", ");
	    	}
	    	sb.delete(sb.length() - 2, sb.length());
	    	sb.append("\n");
    	}
    	toStringHelper(node.right, sb);
    }
    
    public static void main(String[] args){
    	Roster r = new Roster();
    	r.addCourse("li","cs249");
    	r.addCourse("li", "cs32");
    	r.addCourse("xing", "cs143");
    	r.addCourse("luan", "cs32");
    	r.addCourse("xing", "ee262");
    	r.addCourse("lii", "cs249");
    	r.addCourse("andy", "cs249");
    	r.addCourse("zach", "cs249");
    	r.addCourse("berry", "cs249");
    	r.addCourse("candy", "cs249");
    	r.addCourse("beat", "cs249");
    	System.out.println(r.numStudents);
    	r.dropCourseFromAll("cs32");
    	r.deleteStudent("berry");
    	r.display();
    	System.out.println(r.toString());
    }


    // Do not change anything below this line.
    
    public void display() {
        new TreeDisplay<String>().setRoot(copy(root));
    }

    private static TreeNode<String> copy(StudentNode node) {
        if (node == null) return null;
        return new TreeNode<String>(node.name + ":" + node.courses,
                                    copy(node.left),
                                    copy(node.right));
    }
}
