/**
 * 
 * @author [First Name] [Last Name] <[Andrew ID]>
 * @section [Section Letter]
 * @date [date]
 * 
 */


// You may not import any additional classes or packages.
import java.util.ArrayList;

public class Recursion {

    public static int count(Node head, String findData) {
    	if(head == null) return 0;
    	if(head.data.equals(findData)) return 1 + count(head.next, findData);
    	return count(head.next, findData);
    }

    public static boolean isReverse(String string1, String string2) {
    	if(string1.length() != string2.length()) return false;
    	if(string1.length() < 2 && string1.equals(string2)) return true;
    	if(string1.charAt(0) != string2.charAt(string2.length() - 1)) return false;
    	return isReverse(string1.substring(1), string2.substring(0, string2.length()-1));
    }

    public static void insertAfter(Node head, String insertData,
                                   String findData) {
    	if(head == null) return;
    	if(head.data == findData) {
    		Node tmp = new Node(insertData);
    		tmp.next = head.next;
    		head.next = tmp;
    		return;
    	}
    	insertAfter(head.next, insertData, findData);
    }

    public static boolean itAddsUp(ArrayList<Integer> list, Integer target) {
    	if(list.size() == 0 && target == 0) return true;
    	if(list.size() == 0 && target != 0) return false;
    	ArrayList<Integer> list1 = new ArrayList<Integer>(list);
    	int tmp = list1.remove(0);
        return itAddsUp(list1, target - tmp); // remove this line when you are done
    }

    public static String removeDuplicates(String string) {
    	if(!string.contains("|")) return removeDuplicates(string.concat("|"));
    	if(string.indexOf('|') == 0) return string.substring(1);
    	if(string.charAt(0) == string.charAt(string.length() - 1)) return removeDuplicates(string.substring(1));
    	return removeDuplicates(string.substring(1) + string.charAt(0));
    }

    public static String stringNumbers(Integer n) {
    	if(n == 0) return "";
    	if(n == 1) return "1";
    	if(n % 2 == 0) return Integer.toString(n) + "-" + stringNumbers(n-1);
        return stringNumbers(n-1) + "-" + Integer.toString(n); // remove this line when you are done
    }

    public static Node removeAll(Node head, Integer length) {
    	if(head == null) return null;
    	if(head.data.length() == length){
    		head = removeAll(head.next, length);
    		return head;
    	}
    	head.next = removeAll(head.next, length);
        return head; // remove this line when you are done
    }

    public static ArrayList<Integer> mirrorList(ArrayList<Integer> list) {
    	if(list.isEmpty()) return list;
    	int fir = list.get(0);
    	list.remove(0);
    	mirrorList(list).add(fir);
    	list.add(0, fir);
    	return list; // remove this line when you are done
    }

    public static int sumDigits(int n) {
    	try{
    		if(n / 10 < 1) return n;
    		return n%10 + sumDigits(n/10);
    	}catch( IllegalArgumentException ex){
    		System.out.println(ex);
    	}
        return -1;
    }

    public static int countBinary(int n) {
        if(n < 3) return n+1;
        return countBinary(n - 1) + countBinary(n - 2);
    }

    /**
    * Use the main method to write your tests. Delete this method when you're
    * done.
    */
    public static void main(String args[]) {
//    	int result = countBinary(5); // result = 8
//
//    	System.out.println(result);
    }
}
