import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.toIntExact;

public class ArraySolution {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6,7};
//        int k = 8;
//        rotate(nums, k);
//        System.out.println(Arrays.toString(nums));

//        int target = 4;
//        System.out.println(reachNumber(target));

        int[] num = {1,2,0,0};
        int k = 34;
        System.out.println(addToArrayForm(num, k));
    }

    static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    static int reachNumber(int target) {
        target = Math.abs(target);
        int moves =0;
        int sum =0;
        while (sum < target || (sum - target) % 2 != 0) {
            moves++;
            sum += moves;
        }
        return moves;
    }

    static List<Integer> addToArrayForm(int[] num, int k){
        List<Integer> list = new ArrayList<>();
        int i = num.length - 1;
        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
                i--;
            }
            list.add(k % 10);
            k /= 10;
        }
        return list.reversed();
    }

}

/*
 * ============================
 * FUNCTION 1: rotate (LC 189 - Rotate Array)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Input:  [1, 2, 3, 4, 5, 6, 7],  k = 3
 *
 *   Step 1: k = k % n = 3 % 7 = 3
 *
 *   Step 2: Reverse entire array:
 *   [1, 2, 3, 4, 5, 6, 7]  -->  [7, 6, 5, 4, 3, 2, 1]
 *
 *   Step 3: Reverse first k elements (0 to k-1):
 *   [7, 6, 5 | 4, 3, 2, 1]  -->  [5, 6, 7 | 4, 3, 2, 1]
 *
 *   Step 4: Reverse remaining elements (k to end):
 *   [5, 6, 7 | 4, 3, 2, 1]  -->  [5, 6, 7, 1, 2, 3, 4]
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Normalize k: `k = k % nums.length` (handles k > array length).
 * 2. Reverse the entire array [0..n-1].
 * 3. Reverse the first k elements [0..k-1].
 * 4. Reverse the remaining elements [k..n-1].
 *
 * POINTER / INDEX ADJUSTMENT RATIONALE:
 * - `k % nums.length`: If k >= n, rotating n times gives the same array.
 * - Three-reverse trick works because: reversing all then splitting reversal
 *   at k moves the last k elements to the front, in-place, O(1) space.
 *
 * UNIQUE FORMULA & LOGIC:
 * - Three-reverse technique: O(n) time, O(1) space rotation.
 * - `reverse(arr, start, end)`: Two-pointer swap converging inward.
 *
 * ============================
 * FUNCTION 2: reachNumber (LC 754 - Reach a Number)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   target = 3
 *   Number line:    0 ---1---2---3---4---5--->
 *
 *   Step 1: +1 -> sum=1, moves=1  (1 < 3, continue)
 *   Step 2: +2 -> sum=3, moves=2  (3 == 3, (3-3)%2==0 ✓) -> Return 2!
 *
 *   target = 2
 *   Step 1: +1 -> sum=1, moves=1  (1 < 2, continue)
 *   Step 2: +2 -> sum=3, moves=2  (3 >= 2, (3-2)%2==1 ✗, odd)
 *   Step 3: +3 -> sum=6, moves=3  (6 >= 2, (6-2)%2==0 ✓) -> Return 3!
 *   (Flip step 2: go -2 instead of +2 -> 1-2+3 = 2 ✓)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Take `target = Math.abs(target)` (symmetry: reaching -t is same as +t).
 * 2. Keep adding `moves` to `sum` until:
 *    - `sum >= target` AND `(sum - target) % 2 == 0`.
 * 3. Return `moves`.
 *
 * UNIQUE FORMULA & LOGIC:
 * - `(sum - target) % 2 == 0`: The overshoot must be even.
 *   If overshoot = sum - target is even, we can flip one step of size
 *   (overshoot/2) from + to -, reducing sum by exactly overshoot.
 * - If overshoot is odd, keep stepping until it becomes even.
 *
 * ============================
 * FUNCTION 3: addToArrayForm (LC 989 - Add to Array-Form of Integer)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   num = [1, 2, 0, 0],  k = 34
 *
 *   i=3: k += num[3] = 34+0 = 34 -> list.add(34%10=4) -> k=34/10=3
 *   i=2: k += num[2] = 3+0  = 3  -> list.add(3%10=3)  -> k=3/10=0
 *   i=1: k += num[1] = 0+2  = 2  -> list.add(2%10=2)  -> k=2/10=0
 *   i=0: k += num[0] = 0+1  = 1  -> list.add(1%10=1)  -> k=1/10=0
 *
 *   list = [4, 3, 2, 1] -> reversed = [1, 2, 3, 4] = 1200 + 34 = 1234 ✓
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Start from the last digit of `num[]` (index i = num.length - 1).
 * 2. While `i >= 0` OR `k > 0`:
 *    - If `i >= 0`: add `num[i]` into `k`, then decrement `i`.
 *    - Append `k % 10` to the result list (extract last digit).
 *    - `k /= 10` (carry the rest forward).
 * 3. Reverse the list to get the correct order.
 *
 * UNIQUE FORMULA & LOGIC:
 * - Treat `k` as both the number to add AND the carry register.
 *   `k += num[i]` merges digit addition and carry into one variable.
 * - `k % 10` extracts the current digit, `k /= 10` propagates carry.
 */
