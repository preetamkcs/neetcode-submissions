class Solution {
   public int[] dailyTemperatures(int[] temperatures) {
//        System.out.println("input: \n"+Arrays.toString(temperatures));
        int length = temperatures.length;
        Deque<Integer>  indexStack=new ArrayDeque<>();
        indexStack.push(0);
        int[] result=new int[length];
        for (int i = 1; i < length; i++) {

//            System.out.println("\n--------------------------------");
//            System.out.println("Day " + i + ", Temp = " + temperatures[i]);
//            System.out.println("Current Stack = " + indexStack);

            if ( temperatures[i] > temperatures[indexStack.peek()]) {

//                System.out.println("Current temperature is warmer than stack top.");

                while ( temperatures[i] > temperatures[indexStack.peek()]) {

//                    System.out.println(
//                            "Resolved Day " + indexStack.peek() +
//                                    " (Temp=" + temperatures[indexStack.peek()] + ")" +
//                                    " -> waits " + (i - indexStack.peek()) + " day(s)"
//                    );

                    result[indexStack.peek()] = i - indexStack.peek();
                    indexStack.pop();

//                    System.out.println("Stack after pop: " + indexStack);
                    if (indexStack.isEmpty()){
                        break;
                    }
                }
                indexStack.push(i);
            } else {

//                System.out.println("Current temperature is NOT warmer. Push current day.");

                indexStack.push(i);

//                System.out.println("Stack now: " + indexStack);
            }

//            System.out.println("Result so far: " + Arrays.toString(result));
        }

        return result;
    }
}
