class Solution {
      public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagram_buckets = new HashMap<>();
        Arrays.stream(strs).forEach(str -> {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (anagram_buckets.containsKey(key)){
                anagram_buckets.get(key).add(str);
            }else {
                anagram_buckets.put(key,new ArrayList<>(List.of(str)));
            }
        });
        return new ArrayList<>(anagram_buckets.values());
    }
}
