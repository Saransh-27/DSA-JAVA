class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        return findMissing(nums);
    }

    int[] findMissing(int[] arr) {
        int i = 0;
        while(i< arr.length){
            int correctIndex = arr[i] - 1;
            if(i != correctIndex && arr[i] == arr[correctIndex]) {
                return new int[]{arr[i],i+1};
            }else{
                i++;
            }
        }
        return new int[]{-1, -1};
    }
}