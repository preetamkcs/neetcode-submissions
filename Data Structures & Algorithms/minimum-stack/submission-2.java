public class MinStack {
   protected Deque<Integer> stack;
    protected Deque<Integer> minStack;
    public MinStack() {
        stack=new ArrayDeque<>();
        minStack=new ArrayDeque<>();

    }

    public void push(int val) {
        if (stack.isEmpty() && minStack.isEmpty()){
            minStack.push(val);
        } else {
            if (val <= minStack.peek()){
               minStack.push(val);
            }
        }

        stack.push(val);
    }

    public void pop() {
        if (!stack.isEmpty()){
            if (stack.peek() <= minStack.peek()){
                minStack.pop();
            }
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
       return minStack.peek();
    }
}
