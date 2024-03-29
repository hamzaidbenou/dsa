package sorting;

import java.util.Stack;

class Solution {

    /**
     * Given a stack, the task is to sort it such that the top of the stack has the greatest element.
     * @param s
     * @return
     */
	public Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> aux = new Stack<Integer>();
        while(!s.isEmpty()) {
            int curr = s.pop();
            while(!aux.isEmpty() && aux.peek() < curr)
                s.push(aux.pop());
            aux.push(curr);
        }
        return aux;
	}
}
