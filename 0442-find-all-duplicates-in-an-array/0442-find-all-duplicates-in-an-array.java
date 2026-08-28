class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i =0;
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }else{
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int j =0; j< nums.length; j++){
            int correctIndex = nums[j] - 1;
            if(j != correctIndex && nums[j] == nums[correctIndex]){
                ans.add(nums[j]);
            }
        }
        return ans;
    }
}