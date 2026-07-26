class Solution {
        public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while (!(left>=right)){
            while (left<s.length()-1 && isNotAlphanumeric(s.charAt(left))){
                System.out.printf("Skipping from left: %c\n",s.charAt(left));
                left++;
            }
            while (left<s.length()-1 && isNotAlphanumeric(s.charAt(right))){
                System.out.printf("Skipping from right: %c\n",s.charAt(right));
                right--;
            }
            if (left>right){
                return true;
            }
            System.out.printf("Comparing %c at %d with %c at %d\n",s.charAt(left),left,s.charAt(right),right);
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
