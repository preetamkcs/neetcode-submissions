class Solution {
      public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq= new HashMap<>();
        for (int num: nums){
            if (freq.containsKey(num)){
                freq.put(num,freq.get(num)+1);
            } else {
                freq.put(num,1);
            }
        }

        return freq.entrySet().stream().sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed()).mapToInt(Map.Entry::getKey).limit(k).toArray();
    }
}
