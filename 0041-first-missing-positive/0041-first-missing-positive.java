class Solution {
    public int firstMissingPositive(int[] nums) {
        int i =0;
        while(i< nums.length){
            int correctIndex = nums[i] - 1;
          if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }  
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return nums.length + 1;
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Array:   [ 3,  4, -1,  1 ]   (N=4)
 *   Rule:    Positive number v in range 1..N belongs at index (v - 1)
 *
 *   Cyclic Sort:
 *   i=0: val=3, correctIndex=2 -> nums[0]!=nums[2] -> Swap -> [-1, 4, 3, 1]
 *   i=0: val=-1, -1 <= 0 -> Skip -> i=1
 *   i=1: val=4, correctIndex=3 -> nums[1]!=nums[3] -> Swap -> [-1, 1, 3, 4]
 *   i=1: val=1, correctIndex=0 -> nums[1]!=nums[0] -> Swap -> [1, -1, 3, 4]
 *   i=1: val=-1, -1 <= 0 -> Skip -> i=2
 *   i=2: val=3, correctIndex=2, nums[2]==nums[2] -> Skip -> i=3
 *   i=3: val=4, correctIndex=3, nums[3]==nums[3] -> Skip -> i=4
 *
 *   Sorted:  [ 1, -1,  3,  4 ]
 *   Index:     0   1   2   3
 *                  ^
 *            arr[1] != 1+1=2  --> First Missing Positive = 2!
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Cyclic Sort Phase: Loop `i` from `0` to `nums.length - 1`.
 *    - Calculate `correctIndex = nums[i] - 1`.
 *    - If `nums[i] > 0` AND `nums[i] <= nums.length` AND `nums[i] != nums[correctIndex]`:
 *      Swap `nums[i]` with `nums[correctIndex]` (do NOT increment `i`).
 *    - Else: Skip and increment `i++`.
 * 2. Scan Phase: Loop `j` from `0` to `nums.length - 1`.
 *    - If `nums[j] != j + 1`, return `j + 1` (smallest missing positive).
 * 3. If all positions match, return `nums.length + 1`.
 *
 * EDGE CASE HANDLING:
 * - `nums[i] > 0`: Ignores negative numbers and zero (they cannot be the answer within range 1..N).
 * - `nums[i] <= nums.length`: Ignores numbers larger than N (they are out of placeable range).
 * - `nums[i] != nums[correctIndex]`: Prevents infinite swap loops when duplicates exist (e.g., [1,1]).
 *
 * UNIQUE FORMULA & LOGIC:
 * - `correctIndex = nums[i] - 1`: Maps 1-based values to 0-based indices.
 * - Three-guard condition prevents out-of-bounds access, skips irrelevant values, and handles duplicates.
 */