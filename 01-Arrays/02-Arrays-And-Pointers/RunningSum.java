import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunningSum {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4};
//        int[] ans = runningSum(arr);
//        System.out.println(Arrays.toString(ans));
//        int[][] accounts = {{2,8,7},{7,1,3}};
//        System.out.println(maximumWealth(accounts));
//        int[][] points = {{-17,5},{-10,-8},{-5,-13},{-2,7},{8,-14}};
//        System.out.println(findMaxValueOfEquation(points, 4));
//        int[] candies = {2,3,5,1,3};
//        System.out.println(kidsWithCandies(candies, 3));
//        int[] nums = {0,1,2,3,4};
//        int[] index = {0,1,2,2,1};
//        System.out.println(Arrays.toString(createTargetArray(nums, index)));
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        System.out.println(spiralOrder(matrix));
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
}

    static int[] runningSum(int[] arr) {
        int sum = 0;
        int[] ans = new int[arr.length];
        for(int i = ans.length -1; i >= 0; i--){
            for(int j = i; j>= 0; j--){
                sum += arr[j];
            }
            ans[i] = sum;
            sum = 0;
        }
        return ans;
    }

    static int maximumWealth(int[][] accounts) {
        int sum = 0;
        int[] ans = new int[accounts.length];
        for(int i = 0; i< accounts.length; i++){
            for(int j = 0; j< accounts[i].length; j++){
                sum += accounts[i][j];
            }
            ans[i] = sum;
            sum = 0;
        }
        int max = ans[0];
        for(int i: ans){
            if(i > max){
                max = i;
            }
        }
        return max;
    }

    static int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        for(int i =0; i < points.length - 1; i++){
            int sum =0;
            for(int j = 0; j < points[i].length -1 ; j++){
                if(Math.abs(points[i][j] - points[i+1][j]) <= k){
                    sum = points[i][j+1] + points[i+1][j+1] + Math.abs(points[i][j] - points[i+1][j]);
                }
                if(sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }

    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            if(candy > max) {
                max = candy;
            }
        }
        for(int candy : candies){
            int sum = candy + extraCandies;
            if (sum >= max) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>();
        for(int i =0; i< nums.length; i++){
            target.add(index[i], nums[i]);
        }
        int[] ans = new int[target.size()];
        for(int i  =0; i<target.size(); i++){
            ans[i] = target.get(i);
        }
        return ans;
    }



    static int removeDuplicates(int[] nums) {
        int counter =0;
        for(int i =1; i< nums.length; i++){
            if(nums[i] == nums[i-1]){
                counter++;
            }
        }
        return counter;
    }
}

/*
 * ============================
 * FUNCTION 1: runningSum (LC 1480 - Running Sum of 1D Array)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Input:   [ 1,  2,  3,  4 ]
 *   Output:  [ 1,  3,  6,  10 ]
 *
 *   ans[3] = arr[0]+arr[1]+arr[2]+arr[3] = 1+2+3+4 = 10
 *   ans[2] = arr[0]+arr[1]+arr[2]         = 1+2+3   = 6
 *   ans[1] = arr[0]+arr[1]                = 1+2     = 3
 *   ans[0] = arr[0]                       = 1
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Create output array `ans` of same length.
 * 2. Outer loop `i` iterates from last index to 0 (right to left).
 * 3. Inner loop `j` sums all elements from index `i` down to `0`.
 * 4. Store the cumulative sum in `ans[i]`, reset `sum = 0` for next position.
 * 5. Return `ans`.
 *
 * ============================
 * FUNCTION 2: maximumWealth (LC 1672 - Richest Customer Wealth)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   accounts = [[2, 8, 7],    -> Customer 0: 2+8+7 = 17
 *               [7, 1, 3]]    -> Customer 1: 7+1+3 = 11
 *
 *   Wealth array: [17, 11]  -> Max = 17
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. For each customer (row), sum all bank account balances (columns).
 * 2. Store each customer's total wealth in `ans[i]`.
 * 3. Find the maximum value in the `ans` array.
 * 4. Return the maximum wealth.
 *
 * ============================
 * FUNCTION 3: findMaxValueOfEquation (LC 1499)
 * ============================
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Iterate through consecutive point pairs `(points[i], points[i+1])`.
 * 2. For each pair, check if `|x_i - x_{i+1}| <= k`.
 * 3. If valid, compute `sum = y_i + y_{i+1} + |x_i - x_{i+1}|`.
 * 4. Track and return the maximum `sum` found.
 *
 * ============================
 * FUNCTION 4: kidsWithCandies (LC 1431 - Kids With the Greatest Number of Candies)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   candies = [2, 3, 5, 1, 3], extraCandies = 3
 *   max in array = 5
 *
 *   Kid 0: 2+3=5 >= 5 -> true
 *   Kid 1: 3+3=6 >= 5 -> true
 *   Kid 2: 5+3=8 >= 5 -> true
 *   Kid 3: 1+3=4 >= 5 -> false
 *   Kid 4: 3+3=6 >= 5 -> true
 *
 *   Result: [true, true, true, false, true]
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Find the maximum element in the `candies` array.
 * 2. For each kid, check if `candies[i] + extraCandies >= max`.
 * 3. Add `true` or `false` to the result list accordingly.
 * 4. Return the Boolean list.
 *
 * ============================
 * FUNCTION 5: createTargetArray (LC 1389 - Create Target Array in the Given Order)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums  = [0, 1, 2, 3, 4]
 *   index = [0, 1, 2, 2, 1]
 *
 *   Step 0: insert 0 at pos 0 -> [0]
 *   Step 1: insert 1 at pos 1 -> [0, 1]
 *   Step 2: insert 2 at pos 2 -> [0, 1, 2]
 *   Step 3: insert 3 at pos 2 -> [0, 1, 3, 2]  (shifts right)
 *   Step 4: insert 4 at pos 1 -> [0, 4, 1, 3, 2]
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Create an ArrayList `target`.
 * 2. For each `i`, call `target.add(index[i], nums[i])` which inserts at the
 *    specified position, shifting existing elements right.
 * 3. Convert the ArrayList back to an `int[]` array.
 * 4. Return the result array.
 *
 * UNIQUE FORMULA & LOGIC:
 * - `ArrayList.add(index, value)`: Inserts at a specific index with automatic shifting.
 *
 * ============================
 * FUNCTION 6: removeDuplicates (LC 26 - Remove Duplicates from Sorted Array)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Input:  [1, 1, 2]   (sorted)
 *
 *   i=1: nums[1]==nums[0] (1==1) -> counter++ = 1
 *   i=2: nums[2]!=nums[1] (2!=1) -> skip
 *
 *   Result: 1 duplicate found
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Loop `i` from `1` to `nums.length - 1`.
 * 2. If `nums[i] == nums[i-1]` (adjacent duplicate), increment `counter`.
 * 3. Return total count of duplicates.
 *
 * NOTE: This counts duplicates, not unique elements. Standard LC 26 returns
 * the count of unique elements using a write-pointer approach.
 */
