class Solution {
        public static Map<Character,Character> BRACKET_MAP=new HashMap<>();
       
        public boolean isValid(String s) {
        Deque<Character> bracketStack = new ArrayDeque<>();
       
        char[] charArray = s.toCharArray();
        BRACKET_MAP.put('[',']');
        BRACKET_MAP.put('{','}');
        BRACKET_MAP.put('(',')');
        for (Character c : charArray) {
            if (isOpenBracket(c)) {
                bracketStack.push(c);
            } else {
                if (bracketStack.isEmpty()) {
                    return false;
                } else {
                    if (!BRACKET_MAP.get(bracketStack.pop()).equals(c)) {
                        return false;
                    }
                }
            }
        }
        return bracketStack.isEmpty();
    }
    
    private boolean isOpenBracket(Character c) {
        return BRACKET_MAP.containsKey(c);
    }
}
