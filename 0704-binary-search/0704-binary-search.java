class Solution {
    public int search(int[] nums, int target) {
        return searchRec(0, nums.length-1, nums, target);
    }

    public int searchRec(int start, int end, int[] nums, int target){
        if(start > end) return -1;
        int mid = start +(end -start)/2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] > target){
           return searchRec(start, mid-1, nums, target);
        }else{
            return searchRec(mid+1, end, nums, target);
        }
    }
}