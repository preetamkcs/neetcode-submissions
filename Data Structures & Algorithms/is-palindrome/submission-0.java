class Solution {
            public boolean isPalindrome(String s) {
        String filteredStr=s.replaceAll("[^a-zA-Z0-9]","");
        StringBuilder stringBuilder = new StringBuilder(filteredStr);
        return stringBuilder.reverse().toString().equalsIgnoreCase(filteredStr);
    }
    }
