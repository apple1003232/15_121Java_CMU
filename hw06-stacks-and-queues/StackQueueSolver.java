/**
 * 
 * @author [First Name] [Last Name] <Andrew ID>
 * @section [Section Letter]
 * 
 */

public class StackQueueSolver {
	/**
	 * O()
	 * Number the customers 1, 2, ..., m, 1 <= n <= m
	 * @param numPersons the number of customers initially in line (m)
	 * @param numToBack the number of customers sent to the back of the line each time (n)
	 * @return the number of the customer that is served LAST
	 */
	public static int lastCustomer(int numPersons, int numToBack) {
		MyQueue<Integer> q = new ArrayQueue<Integer>();
		for(int i = 1; i <= numPersons; i ++){
			q.enqueue(i);
		}
		int res = 0;
		while(!q.isEmpty()){
			for(int i = 0; i < numToBack; i++){
				q.enqueue(q.dequeue());
			}
			res = q.dequeue();
		}
		return res;
	}

	// Runtime O(n) 4*n
	public static boolean areEqual(MyStack<String> stack1, MyStack<String> stack2) {
		MyStack<String> s = new ArrayStack<String>();
		boolean res = true;
		while(!stack1.isEmpty() && !stack2.isEmpty()){
			if(stack1.peek().equals(stack2.peek())){
				s.push(stack1.pop());
				s.push(stack2.pop());
			}else{
				res = false;
				break;
			}
		}
		if(res){
			if(stack1.isEmpty() && stack2.isEmpty());
			else{
				res = false;
			}
		}
		while(!s.isEmpty()){
			stack2.push(s.pop());
			stack1.push(s.pop());
		}
		return res;
	}

	// Runtime O(n) 6*n
	public static MyStack<Integer> duplicateStack(MyStack<Integer> original) {
		MyStack<Integer> out = new ArrayStack<Integer>();
		MyQueue<Integer> tmp = new ArrayQueue<Integer>();
		while(!original.isEmpty()){
			out.push(original.peek());
			tmp.enqueue(original.pop());
		}
		while(!out.isEmpty())
			original.push(out.pop());
		while(!tmp.isEmpty())
			out.push(tmp.dequeue());
		while(!out.isEmpty())
			tmp.enqueue(out.pop());
		while(!tmp.isEmpty())
			out.push(tmp.dequeue());
		return out;
	}

	public static void main(String[] args) {
//		MyQueue<Integer> s = new TwoStackQueue<Integer>();
//		s.enqueue(1);
//		System.out.println(s.peek());
//		s.dequeue();
//		System.out.println(s.toString());
//		s.enqueue(2);
//		System.out.println(s.toString());
//		s.enqueue(3);
//		System.out.println(s.toString());
//		s.dequeue();
//		System.out.println(s.toString());
//		s.enqueue(4);
//		System.out.println(s.toString());
		
//		MyStack<Integer> s = new ArrayStack<Integer>();
//		s.push(1);
//		s.push(2);
//		s.push(3);
//		
//		System.out.println(duplicateStack(s).toString());
//		System.out.println(s);
		
//		MyStack<String> s1 = new ArrayStack<String>();
//		MyStack<String> s2 = new ArrayStack<String>();
//		s1.push("a");
//		s1.push("b");
//		s1.push("c");
//		s2.push("a");
//		s2.push("b");
//		s2.push("c");
//		System.out.println(areEqual(s1,s2));
//		System.out.println(s1.toString());
//		System.out.println(s2.toString());
		
		System.out.println(lastCustomer(3, 2));
	}

}