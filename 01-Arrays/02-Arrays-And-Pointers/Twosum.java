package Exersise;

import java.util.Arrays;

public class Twosum {
    public static void main(String[] args) {
        int[] arr = {3,2,3};
        int target = 6;
        int[] result = twoSum(arr, target);
        System.out.println("Indices of the two numbers that add up to " + target + " are: " + Arrays.toString(result));
    }

        static int[] twoSum(int[] nums, int target) {
            for(int i =0; i <= nums.length -1; i++){
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{-1,-1};
        }

}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Outer Pointer i=0 [ 3 ]  (Target = 6)
 *                       |
 *   Inner Pointer j ----+----> j=1 [2] -> 3+2=5 != 6
 *                       +----> j=2 [3] -> 3+3=6 == 6  --> Return {0, 2}
 *
 *   Array:   [ 3,  2,  3 ]
 *   Index:     0   1   2
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Outer loop (`i`) iterates from index `0` to `nums.length - 1`.
 * 2. Inner loop (`j`) iterates from index `i + 1` to `nums.length - 1`.
 * 3. Check if `nums[i] + nums[j] == target`.
 * 4. If true, return `{i, j}` containing the two indices.
 * 5. If no pair adds up to target, return `{-1, -1}`.
 *
 * POINTER ADJUSTMENT RATIONALE:
 * - `j = i + 1`: Starts inner loop from the element right after `i` to avoid comparing an element with itself or re-checking duplicate pairs.
 */

