class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);

//        System.out.println("Sorted Array: " + Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

//            System.out.println("\n--------------------------------");
//            System.out.println("i = " + i + ", nums[i] = " + nums[i] + ", target = " + target);

            while (left < right) {
                int sum = nums[left] + nums[right];

                System.out.println(
//                        "left = " + left + " (" + nums[left] + "), " +
//                                "right = " + right + " (" + nums[right] + "), " +
//                                "sum = " + sum
                );

                if (sum > target) {
//                    System.out.println("Sum > target, moving right--");
                    right--;
                } else if (sum < target) {
//                    System.out.println("Sum < target, moving left++");
                    left++;
                } else {
//                    System.out.println("Found Triplet: [" +
//                            nums[i] + ", " + nums[left] + ", " + nums[right] + "]");

                    List<Integer> threeSumSet = new ArrayList<>();
                    threeSumSet.add(nums[i]);
                    threeSumSet.add(nums[left]);
                    threeSumSet.add(nums[right]);
                    ans.add(threeSumSet);
                    left++;
                }
            }
        }

//        System.out.println("\nFinal Answer: " + ans);

        return new ArrayList<>(ans);
    }
}
