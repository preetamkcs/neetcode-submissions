class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result=new int[length];
        for (int i = 0; i < length; i++) {
            int count=0;
            for (int j = i+1; j < length; j++) {
                if (temperatures[i]>=temperatures[j]){
                    count++;
                } else {
                    result[i]=++count;
                    break;
                }
            }
        }
        return result;
    }
}
