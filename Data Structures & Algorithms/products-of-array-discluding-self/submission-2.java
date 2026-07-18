class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod=1;
        int zeroCount=0;
        for (int i = 0; i < nums.length; i++) {

                if (nums[i]==0){
                    zeroCount++;
                } else {
                    prod*=nums[i];
                }
        }
        if (zeroCount>1){
            prod=0;
        }
        int [] prodArr=new int [nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount==0){
                prodArr[i] = prod/nums[i];
            } else if (zeroCount==1){
                prodArr[i] = nums[i]==0?prod:0;
            } else {
                prodArr[i]=0;
            }
        }
        return prodArr;
    }
}  
