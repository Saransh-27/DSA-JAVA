package Exersise;

import java.util.Arrays;

public class FindRepeated {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicate(arr));
        System.out.println(Arrays.toString(arr));
    }


    static int findDuplicate(int[] nums) {
        int i = 0;
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
        return nums[nums.length-1];
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Array:   [ 4, 3, 2, 7, 8, 2, 3, 1 ]   (Range 1..N)
 *
 *   Cyclic Sort places each number v at index (v - 1):
 *   Sorted Array: [ 1, 2, 3, 4, 7, 8, 3, 2 ]
 *                   ^  ^  ^  ^        ^  ^
 *          Index:   0  1  2  3        6  7  -> Duplicates pushed to trailing indices!
 *
 *   Result:  nums[nums.length - 1] contains the duplicate number.
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Initialize `i = 0`.
 * 2. Loop while `i < nums.length`:
 *    - Compute `correctIndex = nums[i] - 1`.
 *    - If `nums[i] != nums[correctIndex]`, swap `nums[i]` with `nums[correctIndex]` (do NOT increment `i`).
 *    - Else (element is already at correct index or duplicate detected at `correctIndex`), increment `i++`.
 * 3. After the loop, duplicate elements get pushed to trailing positions. Return `nums[nums.length - 1]`.
 *
 * POINTER ADJUSTMENT RATIONALE (`i++` only when `nums[i] == nums[correctIndex]`):
 * - If `nums[i] == nums[correctIndex]` and `i != correctIndex`, we have encountered a duplicate! Since `correctIndex` already holds `nums[i]`, we skip `i++` to move forward.
 */

