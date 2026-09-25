class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] ans = new int[nums.length];
        int start =0;
        int end = ans.length-1;
        int index = 0;
        while(index < nums.length){
            if(nums[index]%2!=0){
                ans[end] = nums[index];
                end--;
            }else{
                ans[start] = nums[index];
                start++;
            }
            index++;
        }
        return ans;
    }
}