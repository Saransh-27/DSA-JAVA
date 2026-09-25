class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int Even = 0;
        int Odd = 1;
        while (Even < nums.length && Odd < nums.length) {
            if (nums[Even] % 2 == 0) {
                Even += 2;
            } else if (nums[Odd] % 2 != 0) {
                Odd += 2;
            } else {
                int temp = nums[Even];
                nums[Even] = nums[Odd];
                nums[Odd] = temp;
                Even += 2;
                Odd += 2;
            }
        }
        return nums;
    }
}