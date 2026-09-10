import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionArray {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};
//        System.out.println(Arrays.toString(productExceptSelf(nums)));
//        String s = "thequickbrownfoxjumpsoverthelazydog";
//        System.out.println(checkIfPangram(s));
//        int[][] image = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        revese(image);
//        System.out.println(oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
//        System.out.println(Arrays.toString(sumZero(4)));
//        int[] nums = {-2,-1};
//        System.out.println(maxSubArray(nums));
//        int[] nums = {2,0};
//        System.out.println(canJump(nums));
//        int[] nums = {1};
//        rotate(nums, 100000);
//        System.out.println(Arrays.toString(nums));
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

     static public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            res[0] = 1;
            for (int i = 1; i < n; i++) {
                res[i] = res[i - 1] * nums[i - 1];
            }
            int right = 1;
            for (int i = n - 1; i >= 0; i--) {
                res[i] *= right;
                right *= nums[i];
            }
            return res;
        }

   static boolean checkIfPangram(String sentence) {
        int[] str = new int[26];
           if(sentence.length() < 26){
                    return false;
           }
        for(int i =0; i< sentence.length(); i++){
            str[sentence.charAt(i) - 'a']++;
        }
        for(int i =0; i< 26; i++){
            if(str[i] == 0){
                return false;
            }
        }
        return true;
    }

    static int[][] revese(int[][] image){
        for (int[] row : image) {
            int start = 0;
            int end = row.length - 1;
            while (start < end) {
                int temp = row[start];
                row[start] = row[end];
                row[end] = temp;
                start++;
                end--;
            }
        }
        return image;
    }

    static int oddCells(int m, int n, int[][] indices) {
        int[][] arr = new int[m][n];
        for(int i =0; i< indices.length; i++){
            for(int j =0; j < indices[i].length -1; j++){
                int row = indices[i][j];
                int col = indices[i][j+1];
                for(int k = 0; k < n; k++){
                    arr[row][k]++;
                }
                for(int k = 0; k < m; k++){
                    arr[k][col]++;
            }
            }
        }
        int counter =0;
        for(int[] i : arr){
            for(int j : i) {
                if (j % 2 != 0) {
                    counter++;
                }
            }
        }
        return counter;
    }

    static int[] sumZero(int n) {
        int[] ans = new int[n];
        if (n % 2 == 0) {
            for (int i = 0; i < ans.length; i++) {
                    ans[i] = i < n/2 ? i - n/2 : i - n/2 + 1;
            }
        } else {
            for (int i = 0; i < ans.length; i++) {
                ans[i] = i - (n / 2);
            }
        }
        return ans;
    }

    static int maxSubArray(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 1) {
                sum = 0;
            } else {
                if(sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }

    static boolean canJump(int[] nums) {
        int index = 0;
        while(index < nums.length){
            if(index == nums.length -1){
                return true;
            }
            if(nums[index] == 0 && index != nums.length -1){
                return false;
            }
            index += nums[index];
        }
        return false;
    }

    static void rotate(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        for(int i =0; i< nums.length; i++){
            ans.add(nums[i]);
        }
        for(int i =0; i< k; i++){
            ans.add(0, nums[nums.length -1 - i]);
        }
        for(int i =0; i< nums.length; i++){
            nums[i] = ans.get(i);
        }
    }

    static int[] twoSum(int[] numbers, int target) {
        int current = 0;
        while (current < numbers.length) {
            for (int i = current + 1; i < numbers.length; i++) {
                if (numbers[i] + numbers[current] == target) {
                    return new int[]{current, i};
                }
            }
            current++;
        }
        return new int[]{-1,-1};
    }
}

/*
 * ============================
 * FUNCTION 1: productExceptSelf (LC 238 - Product of Array Except Self)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums = [1, 2, 3, 4]
 *
 *   Pass 1 (Left Products -> stored in res):
 *   res[0] = 1          (nothing to the left of index 0)
 *   res[1] = 1 * 1 = 1
 *   res[2] = 1 * 2 = 2
 *   res[3] = 2 * 3 = 6
 *   res = [1, 1, 2, 6]
 *
 *   Pass 2 (Right Products -> multiply into res):
 *   right = 1
 *   i=3: res[3] = 6 * 1 = 6,   right = 1 * 4 = 4
 *   i=2: res[2] = 2 * 4 = 8,   right = 4 * 3 = 12
 *   i=1: res[1] = 1 * 12 = 12, right = 12 * 2 = 24
 *   i=0: res[0] = 1 * 24 = 24, right = 24 * 1 = 24
 *   res = [24, 12, 8, 6]
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Initialize `res[0] = 1`. Forward pass: `res[i] = res[i-1] * nums[i-1]` (left product).
 * 2. Initialize `right = 1`. Backward pass: `res[i] *= right`, then `right *= nums[i]`.
 * 3. Return `res` — each element is the product of all elements except itself.
 *
 * UNIQUE FORMULA & LOGIC:
 * - O(N) time, O(1) extra space (output array doesn't count as extra space).
 * - Two-pass approach avoids division and handles zeros correctly.
 *
 * ============================
 * FUNCTION 2: checkIfPangram (LC 1832 - Check if the Sentence Is Pangram)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Input: "thequickbrownfoxjumpsoverthelazydog"
 *   Frequency array: int[26] -> index 0='a', 1='b', ..., 25='z'
 *   After scan: all 26 slots > 0 -> TRUE (Pangram!)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. If string length < 26, return false immediately (can't contain all 26 letters).
 * 2. Create `int[26]` frequency array. Increment `str[ch - 'a']++` for each char.
 * 3. If any slot is `0`, return false. Otherwise return true.
 *
 * UNIQUE FORMULA & LOGIC:
 * - `sentence.charAt(i) - 'a'`: Maps lowercase letter to index 0..25.
 *
 * ============================
 * FUNCTION 3: revese (LC 832 - Flipping an Image — row reversal step)
 * ============================
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. For each row, use two pointers (`start`, `end`) to swap elements inward.
 * 2. Continue until `start >= end`. Return the reversed image.
 *
 * ============================
 * FUNCTION 4: oddCells (LC 1252 - Cells with Odd Values in a Matrix)
 * ============================
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Create `m x n` matrix initialized to 0.
 * 2. For each pair `(row, col)` in `indices`:
 *    - Increment all elements in `row` by 1.
 *    - Increment all elements in `col` by 1.
 * 3. Count elements with odd values (`j % 2 != 0`) across the matrix.
 * 4. Return the count.
 *
 * ============================
 * FUNCTION 5: sumZero (LC 1304 - Find N Unique Integers Sum up to Zero)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   n=5: Generate [-2, -1, 0, 1, 2]  (symmetric around 0)
 *   n=4: Generate [-2, -1, 1, 2]     (skip 0 for even N)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. If `n` is odd: assign `ans[i] = i - (n/2)` -> generates symmetric range centered at 0.
 * 2. If `n` is even: similar logic but skips 0 using ternary offset.
 * 3. Return the array.
 *
 * ============================
 * FUNCTION 6: maxSubArray (LC 53 - Maximum Subarray / Kadane's Algorithm)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Array: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *
 *   sum tracking:
 *   -2 -> sum=-2 < 1 -> reset to 0
 *    1 -> sum=1 -> max=1
 *   -3 -> sum=-2 -> reset to 0
 *    4 -> sum=4 -> max=4
 *   -1 -> sum=3 -> max=4
 *    2 -> sum=5 -> max=5
 *    1 -> sum=6 -> max=6
 *   -5 -> sum=1 -> max=6
 *    4 -> sum=5 -> max=6
 *
 *   Maximum Subarray Sum = 6 (subarray [4, -1, 2, 1])
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Initialize `sum = 0` and `max = 0`.
 * 2. For each element, add it to `sum`.
 * 3. If `sum < 1`, reset `sum = 0` (discard negative running sum).
 * 4. Else, update `max = Math.max(max, sum)`.
 * 5. Return `max`.
 *
 * NOTE: This version returns 0 for all-negative arrays. Standard Kadane's
 * initializes max to arr[0] and uses `currentSum = max(arr[i], currentSum + arr[i])`.
 *
 * ============================
 * FUNCTION 7: canJump (LC 55 - Jump Game)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums = [2, 3, 1, 1, 4]
 *   index=0: jump 2 -> index=2
 *   index=2: jump 1 -> index=3
 *   index=3: jump 1 -> index=4 (== length-1) -> TRUE!
 *
 *   nums = [3, 2, 1, 0, 4]
 *   index=0: jump 3 -> index=3
 *   index=3: nums[3]=0 and not at end -> FALSE (stuck!)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Start at `index = 0`.
 * 2. While `index < nums.length`:
 *    - If `index == nums.length - 1`, return true (reached the end).
 *    - If `nums[index] == 0`, return false (stuck, can't move forward).
 *    - Jump forward by `nums[index]` positions: `index += nums[index]`.
 * 3. Return false if `index` overshoots past the end.
 *
 * NOTE: This greedy jump approach always takes the maximum jump. Standard
 * approach tracks `maxReach` to handle all possible paths.
 *
 * ============================
 * FUNCTION 8: rotate (LC 189 - Rotate Array)
 * ============================
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Copy all elements from `nums` into an ArrayList `ans`.
 * 2. For `k` iterations, insert last elements at the front using `ans.add(0, ...)`.
 * 3. Copy the first `nums.length` elements back into `nums`.
 *
 * NOTE: This approach has O(N*K) time. Optimal approach uses array reversal (O(N)).
 *
 * ============================
 * FUNCTION 9: twoSum (LC 1 - Two Sum)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   numbers = [2, 7, 11, 15], target = 9
 *
 *   current=0: i=1 -> 2+7=9 == target -> Return {0, 1}
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Outer loop `current` from 0 to `numbers.length - 1`.
 * 2. Inner loop `i` from `current + 1` to `numbers.length - 1`.
 * 3. If `numbers[i] + numbers[current] == target`, return `{current, i}`.
 * 4. Return `{-1, -1}` if no pair found.
 *
 * POINTER ADJUSTMENT RATIONALE:
 * - `i = current + 1`: Avoids comparing an element with itself and prevents duplicate pairs.
 */
