class Solution {
    public int trap(int[] height) {
        if (height.length<3){
            return 0;
        }
        int[] maxLeftCompute = maxLeftCompute(height);
        int[] maxRightCompute = maxRightCompute(height);
        int trapped=0;
        for (int i = 0; i < height.length ; i++) {
            int trapperAtIndex=Math.min(maxLeftCompute[i],maxRightCompute[i])- height[i];
            if (trapperAtIndex>0){
                trapped+=trapperAtIndex;
            }
        }
        return trapped;
    }
    private int[] maxLeftCompute(int[] heights){
        int[] maxLeft=new int[heights.length];
        maxLeft[1]=heights[0];
        for (int i = 2; i < heights.length; i++) {
            maxLeft[i]=Math.max(heights[i-1],maxLeft[i-1]);
        }
        return maxLeft;
    }

    private int[] maxRightCompute(int[] heights){
        int[] maxRight=new int[heights.length];
        maxRight[heights.length-2]=heights[heights.length-1];
        for (int i = heights.length-3; i >= 0; i--) {
            maxRight[i]=Math.max(heights[i+1],maxRight[i+1]);
        }
        return maxRight;
    }
}
