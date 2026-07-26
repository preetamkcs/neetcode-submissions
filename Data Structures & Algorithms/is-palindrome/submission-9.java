class Solution {
        public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while (!(left>=right)){
            while (left<s.length()-1 && isNotAlphanumeric(s.charAt(left))){
                left++;
            }
            while (right>0 && isNotAlphanumeric(s.charAt(right))){
                right--;
            }
            if (left>right){
                return true;
            }
            if (Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isNotAlphanumeric(char c) {
        return !(Character.isAlphabetic(c)||Character.isDigit(c));
    }
    }
