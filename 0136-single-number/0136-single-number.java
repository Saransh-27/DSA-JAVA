class Solution {
    public int singleNumber(int[] nums) {
        int unique = 0;
        for(int a : nums){
            unique ^= a;
        }
        return unique;
    }
}