class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int index = nums.length - 1;
        while (index >= 2) {
            if (nums[index - 2] + nums[index - 1] > nums[index]) {
                return nums[index - 2] + nums[index - 1] + nums[index];
            }
            index--;
        }
        return 0;
    }
}