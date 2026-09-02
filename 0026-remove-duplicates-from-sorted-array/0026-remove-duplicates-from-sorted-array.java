class Solution {
    public int removeDuplicates(int[] nums) {
        int counter =1;
        for(int i =1; i< nums.length; i++){
            if(nums[i] != nums[counter-1]){
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }
}