class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result=new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (temperatures[i]<temperatures[j]){
                    result[i]= j-i;
                    break;
                }
            }
        }
        return result;
    }
}
