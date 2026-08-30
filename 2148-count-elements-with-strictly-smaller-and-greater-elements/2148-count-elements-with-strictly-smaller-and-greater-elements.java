class Solution {
    public int countElements(int[] nums) {
       int len = nums.length;
       int min = Integer.MIN_VALUE;
       int max = Integer.MAX_VALUE;
       int counter = 0;
       for(int i = 0; i < len; i++){
            if(min<nums[i]){
                min=nums[i];
            }
            if(max>nums[i]){
                max=nums[i];
            }
       }
            for(int i = 0;i < len; i++){
                if(nums[i] < min && nums[i] > max){
                    counter++;
            }
        }
    return counter;       
    }
}