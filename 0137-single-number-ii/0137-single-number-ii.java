class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int idx = 0;
        while(idx < nums.length){
            if(idx == nums.length-1) return nums[idx];
            if(nums[idx] == nums[idx+1]) idx += 3;
            else break;
        }
        return nums[idx];
    }
}