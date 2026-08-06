class Solution {
public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens){
            if (token.matches("-?\\d+")){
                stack.push(Integer.valueOf(token));
            } else {
                Integer int2 = stack.pop();
                Integer int1 = stack.pop();
                switch (token){
                    case "+": stack.push(int1 + int2); break;
                    case "-": stack.push(int1-int2); break;
                    case "*": stack.push((int1*int2)); break;
                    case "/": stack.push((int1/int2)); break;
                    default: throw new IllegalStateException("Invalid Operator");
                }
            }
        }
        return stack.pop();
    }
}
