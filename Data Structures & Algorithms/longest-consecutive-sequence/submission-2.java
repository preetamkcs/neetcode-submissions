class Solution {
        public int longestConsecutive(int[] nums) {
        Set<Integer> numSet=new HashSet<>(Arrays.stream(nums).boxed().toList());
        int maxLength=0;

        for (int num : nums) {
            int tempMax=0;
            if (!numSet.contains(num-1)){
                int number=num;
                tempMax++;
                while (numSet.contains(++number)){
                    tempMax++;
                }
                maxLength=Math.max(maxLength,tempMax);
            }
        }
        return maxLength;
    }
}
