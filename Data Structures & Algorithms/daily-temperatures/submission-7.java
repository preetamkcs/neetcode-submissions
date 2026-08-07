class Solution {
      public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        Deque<Integer>  indexStack=new ArrayDeque<>();
        indexStack.push(0);
        int[] result=new int[length];
        for (int i = 1; i < length; i++) {
            if ( temperatures[i] > temperatures[indexStack.peek()]) {
                while ( temperatures[i] > temperatures[indexStack.peek()]) {
                    result[indexStack.peek()] = i - indexStack.peek();
                    indexStack.pop();
                    if (indexStack.isEmpty()){
                        break;
                    }
                }
                indexStack.push(i);
            } else {
                indexStack.push(i);
            }
        }
        return result;
    }
}
