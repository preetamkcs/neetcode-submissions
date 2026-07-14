class Solution {
     public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagram_buckets = new HashMap<>();
        Arrays.stream(strs).forEach(str -> {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            if (anagram_buckets.containsKey(new String(charArray))){
                anagram_buckets.get(new String(charArray)).add(str);
            }else {
                anagram_buckets.put(new String(charArray),new ArrayList<>(List.of(str)));
            }
        });
        return new ArrayList<>(anagram_buckets.values());
    }
}
