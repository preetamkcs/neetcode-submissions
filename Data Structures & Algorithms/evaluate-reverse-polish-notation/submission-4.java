class Solution {
public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens){
            switch (token){
                case "+": {
                    Integer int2 = stack.pop();
                    Integer int1 = stack.pop();
                    stack.push(int1 + int2);
                    break;
                }
                case "-": {
                    Integer int2 = stack.pop();
                    Integer int1 = stack.pop();stack.push(int1-int2);
                    break;
                }
                case "*": {
                    Integer int2 = stack.pop();
                    Integer int1 = stack.pop();stack.push((int1*int2));
                    break;
                }
                case "/": {
                    Integer int2 = stack.pop();
                    Integer int1 = stack.pop();stack.push((int1/int2));
                    break;
                }
                default:  stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
