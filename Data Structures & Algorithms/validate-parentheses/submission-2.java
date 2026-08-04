class Solution {
        public boolean isValid(String s) {
        if (s.length()%2!=0){
            return false;
        }
        Stack<Character> bracketStack = new Stack<>();
        Map<Character,Character> bracketMap=new HashMap<>();
        bracketMap.put('[',']');
        bracketMap.put('{','}');
        bracketMap.put('(',')');
        char[] charArray = s.toCharArray();

        for (Character c : charArray) {
            if (isOpenBracket(c, bracketMap)) {
                bracketStack.push(c);
            } else {
                if (bracketStack.isEmpty()) {
                    return false;
                } else {
                    if (!bracketMap.get(bracketStack.pop()).equals(c)) {
                        return false;
                    }
                }
            }
        }
        return bracketStack.isEmpty();
    }
    
    private boolean isOpenBracket(Character c, Map<Character, Character> bracketMap) {
        return bracketMap.containsKey(c);
    }
}
