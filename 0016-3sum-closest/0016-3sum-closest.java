class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int closest = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int currentDiff = Math.abs(sum - target);
                if (currentDiff < diff) {
                    diff = currentDiff;
                    closest = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return sum;
                }
            }
        }
        return closest;
    }
}