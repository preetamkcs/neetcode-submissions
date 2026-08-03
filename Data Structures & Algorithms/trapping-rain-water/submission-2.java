class Solution {
   public int trap(int[] height) {
        int right=height.length-1;
        int left=0;
        int rightMax=0,leftMax=0,trapped=0;
        while (left<right){
            if (height[left]<=height[right]){
                leftMax=Math.max(height[left],leftMax);
                int trappedAtIndex= leftMax-height[left];
                if (trappedAtIndex>0){
                    trapped+=trappedAtIndex;
                }
                left++;
            } else {
                rightMax=Math.max(height[right],rightMax);
                int trappedAtIndex=rightMax-height[right];
                if (trappedAtIndex>0){
                    trapped+=trappedAtIndex;
                }
                right--;
            }
        }
        return trapped;
    }
}
