class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i];
            if (nums[i] != i && nums[i] < nums.length) {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = correctIndex;
            } else {
                i++;
            }
        }
        return findMissing(nums);
    }

    int findMissing(int[] arr) {
        int i = 0;
        while(i< arr.length){
            if(i != arr[i]) {
                return i;
            }else{
                i++;
            }
        }
        return i;
    }
}