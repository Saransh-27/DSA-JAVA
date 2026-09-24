class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int index = ans.length-1;
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int leftSquare = nums[left]*nums[left];
            int rightSquare = nums[right]*nums[right];
            if(leftSquare > rightSquare){
                ans[index] = leftSquare;
                left++;
            }else{
                ans[index] = rightSquare;
                right--;
            }
            index--;
        }
        return ans;
    }
}