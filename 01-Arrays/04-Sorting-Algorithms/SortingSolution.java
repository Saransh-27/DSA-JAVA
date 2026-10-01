import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class SortingSolution {
    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
//        int m = 0;
//        int[] nums2 = {1};
//        int n = 1;
//        merge(nums1, m, nums2, n);
//        System.out.println("Merged array: " + java.util.Arrays.toString(nums1));

//        int[] arr = {2,2,2,3,1};
//        System.out.println(bubbleSort(arr));

//        int[] arr = {0,4,3,0,4};
//        System.out.println(specialArray(arr));

//        int[] arr = {1,2,4};
//        System.out.println(canMakeArithmeticProgression(arr));

//        int[] salary = {4000,3000,1000,2000};
//        System.out.println(average(salary));

//        int[] nums = {3,5,4,2};
//        System.out.println(maxProduct(nums));

//        int[] arr = {7,3,1,0,0,6};
//        System.out.println(maximumProduct(arr));

//        int[] arr = {40,11,26,27,-20};
//        System.out.println(minimumAbsDifference(arr));

//        int rows = 2, cols = 3, rCenter = 1, cCenter = 2;
//        System.out.println(Arrays.deepToString(allCellsDistOrder(rows, cols, rCenter, cCenter)));

//        int[] arr = {3,1,2,4};
//        System.out.println(Arrays.toString(sortArrayByParity(arr)));

//        int[] arr = {4,2,6,5,7,9};
//        System.out.println(Arrays.toString(sortArrayByParityII(arr)));

//        int[] arr = {1,2};
//        System.out.println(thirdMax(arr));

//        int[] arr = {3,3};
//        System.out.println(containsDuplicate(arr));

//        int[][] arr = {{4,7},{1,4}};
//        System.out.println(Arrays.deepToString(merge(arr)));

//        int[] arr = {3,2,3,1,2,4,5,5,6};
//        int k = 4;
//        System.out.println(findKthLargest(arr, k));

//        int[] arr = {0,0,0};
//        System.out.println(threeSum(arr));

//        int[] arr = {3,30,34,5,9};
//        System.out.println(largestNumber(arr));

        int[] arr = {0,1,2};
        System.out.println(threeSumClosest(arr, 3));

    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        while(m < nums1.length){
            nums1[m] = nums2[m%n];
            for(int i=m; i>0; i--){
                if(nums1[i] < nums1[i-1]){
                    int temp = nums1[i];
                    nums1[i] = nums1[i-1];
                    nums1[i-1] = temp;
                }
            }
            m++;
        }
    }

    static int bubbleSort(int[] nums){
        for(int i=0; i< nums.length; i++){
            for(int j=1; j< nums.length-i; j++){
                if(nums[j] < nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
            if(nums.length < 3){
                return nums[nums.length-1];
            }else if(i == 3 && nums[nums.length-2] != nums[nums.length-3]){
                return nums[nums.length-3];
            }
        }
        return 0;
    }

    static public int specialArray(int[] nums) {
        int x = 0;
        while (x <= nums.length) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= x) {
                    count++;
                }
            }
            if(count == x){
                return x;
            }
            x++;
        }
        return -1;
    }

    static boolean canMakeArithmeticProgression(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j =1; j < arr.length - i; j++) {
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        int diff = arr[1] - arr[0];
        for(int i =2; i<arr.length; i++){
            if(arr[i] - arr[i-1] != diff) return false;
        }
        return true;
    }

    static double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = MAX_VALUE;
        double sum =0;
        for(int num: salary){
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
            sum += num;
        }
        sum -= (min+max);
        return sum / (salary.length - 2);
    }

    static int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int num : nums){
            if (num > max1) {
                max2 = max1;
                max1 = num;
            }
            else if (num > max2) {
                max2 = num;
            }
        }
        return (max1-1)*(max2-1);
    }

    static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = MAX_VALUE;
        int min2 = MAX_VALUE;
        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1){
                min2 = min1;
                min1 = num;
            }else if( num < min2){
                min2 = num;
            }
        }
        return Math.max(max1 * max2 * max3, min1*min2*max1);
    }

    static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int low =0, high=1;
        int diff = MAX_VALUE;
        while(high < arr.length){
            if(arr[high] - arr[low] < diff){
                diff = arr[high] - arr[low];
            }
            low++;
            high++;
        }
        for(int i=0; i< arr.length-1; i++){
            for (int j =1; j < arr.length; j++){
                if(arr[j]-arr[i] == diff){
                    ans.add(Arrays.asList(arr[i],arr[j]));
                }
            }
        }
        return ans;
    }

    static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] ans = new int[rows*cols][2];
        int index =0;
        for(int i =0; i< rows; i++){
            for(int j =0; j < cols; j++){
                ans[index] = new int[]{Math.abs(i-rCenter), Math.abs(j-cCenter)};
                index++;
            }
        }
        return ans;
    }

    static int[] sortArrayByParity(int[] nums) {
        int[] ans = new int[nums.length];
        int start =0;
        int end = ans.length-1;
        int index = 0;
        while(index < nums.length){
            if(nums[index]%2!=0){
                ans[end] = nums[index];
                end--;
            }else{
                ans[start] = nums[index];
                start++;
            }
            index++;
        }
        return ans;
    }

    static int[] sortArrayByParityII(int[] nums) {
        int Even = 0;
        int Odd = 1;
        while (Even < nums.length && Odd < nums.length) {
            if(nums[Even] % 2 == 0){
                Even += 2;
            }else if(nums[Odd] % 2 != 0){
                Odd += 2;
            }else{
                int temp = nums[Even];
                nums[Even] = nums[Odd];
                nums[Odd] = temp;
                Even += 2;
                Odd += 2;
            }
        }
        return nums;
    }

    static int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        for (int num : nums) {
            if (num == max1 || num == max2 || num == max3) {
                continue;
            }
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        if (max3 == Long.MIN_VALUE) {
            return (int)max1;
        }
        return (int)max3;
    }

    static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int index =0;
        while(index < nums.length-1){
            if(nums[index] == nums[index+1]) return true;
            else index++;
        }
        return false;
    }

    static public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> matrix = new ArrayList<>();
        int row = 0;
        while (row < intervals.length) {
            int start = intervals[row][0];
            int end = intervals[row][1];
            while (row + 1 < intervals.length && intervals[row + 1][0] <= end) {
                end = Math.max(end, intervals[row + 1][1]);
                row++;
            }
            matrix.add(Arrays.asList(start, end));
            row++;
        }
        int[][] ans = new int[matrix.size()][2];
        for (int i = 0; i < matrix.size(); i++) {
            ans[i][0] = matrix.get(i).get(0);
            ans[i][1] = matrix.get(i).get(1);
        }
        return ans;
    }

    static int findKthLargest(int[] nums, int k) {
            int[] ans = new int[k];
            int index = 0;
            int max2 = Integer.MIN_VALUE;
            while(index < ans.length){
                int max = Integer.MIN_VALUE;
                for (int num : nums) {
                    if (num > max && num != max2) {
                        max = num;
                    }
                }
                ans[index] = max;
                max2 = max;
                index++;
            }
            return ans[k-1];
    }

    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i =0; i< nums.length-2; i++) {
                int left =i+1;
                int right = nums.length-1;
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    right--;
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
       return ans;
    }

    static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int closest =0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int currentDiff = Math.abs(sum - target);
                if (currentDiff < diff) {
                    diff = currentDiff;
                    closest = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                }else {
                    return sum;
                }
            }
        }
        return closest;
    }
}

/*
 * ============================
 * FUNCTION 1: merge (LC 88 - Merge Sorted Array)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums1 = [1, 2, 3, 0, 0, 0], m=3    nums2 = [2, 5, 6], n=3
 *
 *   Insert nums2[0]=2 at index 3 -> [1,2,3,2,0,0] -> bubble-sort-insert -> [1,2,2,3,0,0]
 *   Insert nums2[1]=5 at index 4 -> [1,2,2,3,5,0] -> already sorted
 *   Insert nums2[2]=6 at index 5 -> [1,2,2,3,5,6] -> already sorted
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Start from index `m` in `nums1`.
 * 2. Place `nums2[m % n]` at `nums1[m]`.
 * 3. Insertion-sort the newly placed element backward to maintain order.
 * 4. Increment `m`, repeat until `nums1` is full.
 *
 * UNIQUE FORMULA & LOGIC:
 * - Uses insertion-sort approach: each new element is placed and bubbled left.
 * - `nums2[m % n]` maps the index correctly when iterating beyond n.
 *
 * ============================
 * FUNCTION 2: bubbleSort (used for Third Max - LC 414 variant)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums = [2, 2, 2, 3, 1]
 *   After sorting: [1, 2, 2, 2, 3]
 *   3rd max = nums[n-3] = 2  (if distinct from nums[n-2])
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Bubble sort the array in ascending order.
 * 2. If length < 3: return the max (last element).
 * 3. After 3 passes (i==3): if nums[n-2] != nums[n-3], return nums[n-3].
 *
 * ============================
 * FUNCTION 3: specialArray (LC 1608 - Special Array With X Elements >= X)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums = [0, 4, 3, 0, 4]
 *
 *   x=0: count(>=0) = 5 -> 5!=0
 *   x=1: count(>=1) = 3 -> 3!=1
 *   x=2: count(>=2) = 3 -> 3!=2
 *   x=3: count(>=3) = 3 -> 3==3 ✓ -> Return 3!
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Try each x from 0 to nums.length.
 * 2. Count how many elements in nums are >= x.
 * 3. If count == x, return x (array is "special" with x).
 * 4. If no x found, return -1.
 *
 * ============================
 * FUNCTION 4: canMakeArithmeticProgression (LC 1502)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   arr = [1, 2, 4]  -> Sort -> [1, 2, 4]
 *   diff = arr[1]-arr[0] = 1
 *   Check: arr[2]-arr[1] = 2 != 1 -> FALSE
 *
 *   arr = [3, 5, 1]  -> Sort -> [1, 3, 5]
 *   diff = 2
 *   Check: 5-3 = 2 == 2 -> TRUE
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Bubble sort the array.
 * 2. Compute common difference: `diff = arr[1] - arr[0]`.
 * 3. Check all consecutive pairs: if any `arr[i]-arr[i-1] != diff`, return false.
 * 4. If all match, return true.
 *
 * ============================
 * FUNCTION 5: average (LC 1491 - Average Salary Excluding Min and Max)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   salary = [4000, 3000, 1000, 2000]
 *   sum = 10000, min = 1000, max = 4000
 *   sum -= (1000+4000) = 5000
 *   avg = 5000 / (4-2) = 2500.0
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Single pass: find min, max, and total sum.
 * 2. Subtract min + max from sum.
 * 3. Divide by (salary.length - 2).
 *
 * ============================
 * FUNCTION 6: maxProduct (LC 1464 - Max Product of Two Elements)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums = [3, 5, 4, 2]
 *   max1=5, max2=4 -> (5-1)*(4-1) = 4*3 = 12
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Track top 2 maximums in a single pass.
 * 2. Return `(max1-1) * (max2-1)`.
 *
 * UNIQUE FORMULA & LOGIC:
 * - When a new max1 is found, old max1 cascades to max2.
 *
 * ============================
 * FUNCTION 7: maximumProduct (LC 628 - Maximum Product of Three Numbers)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums = [7, 3, 1, 0, 0, 6]
 *   max1=7, max2=6, max3=3, min1=0, min2=0
 *   Option A: 7*6*3 = 126
 *   Option B: 0*0*7 = 0
 *   Answer: max(126, 0) = 126
 *
 *   With negatives: [-4, -3, 1, 2, 7]
 *   max1=7, max2=2, max3=1, min1=-4, min2=-3
 *   Option A: 7*2*1 = 14
 *   Option B: (-4)*(-3)*7 = 84
 *   Answer: max(14, 84) = 84
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Single pass: track top 3 maximums AND bottom 2 minimums.
 * 2. Return max(max1*max2*max3, min1*min2*max1).
 *
 * UNIQUE FORMULA & LOGIC:
 * - Two negative minimums multiplied give a positive product.
 *   So `min1 * min2 * max1` could exceed `max1 * max2 * max3`.
 *
 * ============================
 * FUNCTION 8: minimumAbsDifference (LC 1200 - Minimum Absolute Difference)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   arr = [40, 11, 26, 27, -20]
 *   Sorted: [-20, 11, 26, 27, 40]
 *
 *   Adjacent diffs: 31, 15, 1, 13 -> min diff = 1
 *   Pairs with diff=1: [26, 27]
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Sort the array.
 * 2. Sliding window (low, high) finds minimum adjacent difference.
 * 3. Second pass collects all pairs with that minimum difference.
 *
 * ============================
 * FUNCTION 9: allCellsDistOrder (LC 1030 - Matrix Cells in Distance Order)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   rows=2, cols=3, rCenter=1, cCenter=2
 *   Generate all (row, col) pairs with Manhattan distance |r-rCenter| + |c-cCenter|.
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Generate all cell coordinates as [|row-rCenter|, |col-cCenter|].
 * 2. Store in result array.
 *
 * ============================
 * FUNCTION 10: sortArrayByParity (LC 905 - Sort Array By Parity)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums = [3, 1, 2, 4]
 *   ans:  start->  [2, 4, _, _]    end->  [_, _, 1, 3]
 *   Result: [2, 4, 1, 3]  (evens first, odds last)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Two pointers: `start` at 0, `end` at last index.
 * 2. Scan each element: if odd -> place at `end--`, if even -> place at `start++`.
 *
 * ============================
 * FUNCTION 11: sortArrayByParityII (LC 922 - Sort Array By Parity II)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums = [4, 2, 5, 7]
 *   Even pointer (0,2,4...) checks even indices for even values.
 *   Odd pointer (1,3,5...) checks odd indices for odd values.
 *   Swap when even index has odd value AND odd index has even value.
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. `Even=0`, `Odd=1`. Both increment by 2.
 * 2. If `nums[Even]` is even -> skip (Even+=2).
 * 3. If `nums[Odd]` is odd -> skip (Odd+=2).
 * 4. Otherwise: swap `nums[Even]` and `nums[Odd]`, advance both.
 *
 * ============================
 * FUNCTION 12: thirdMax (LC 414 - Third Maximum Number)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums = [3, 2, 1]
 *   max1=3, max2=2, max3=1 -> Return max3 = 1
 *
 *   nums = [1, 2]  (less than 3 distinct)
 *   max3 stays Long.MIN_VALUE -> Return max1 = 2
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Track top 3 distinct maximums using `long` (to handle Integer.MIN_VALUE edge case).
 * 2. Skip duplicates: if num equals any of max1/max2/max3, continue.
 * 3. If max3 was never updated (still Long.MIN_VALUE), return max1.
 * 4. Otherwise return max3.
 *
 * EDGE CASE HANDLING:
 * - Using `long` prevents collision with Integer.MIN_VALUE being a valid input.
 * - Duplicate skip ensures only distinct values are tracked.
 *
 * ============================
 * FUNCTION 13: containsDuplicate (LC 217 - Contains Duplicate)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums = [3, 3]  -> Sort -> [3, 3]
 *   index=0: nums[0]==nums[1] -> TRUE (duplicate found!)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Sort the array.
 * 2. Scan adjacent pairs: if `nums[i] == nums[i+1]`, return true.
 * 3. If no match found, return false.
 *
 * ============================
 * FUNCTION 14: merge intervals (LC 56 - Merge Intervals)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   intervals = [[1,3],[2,6],[8,10],[15,18]]
 *   Sorted by start: [[1,3],[2,6],[8,10],[15,18]]
 *
 *   row=0: start=1, end=3 -> next[0]=2 <= 3 -> merge -> end=max(3,6)=6 -> [1,6]
 *   row=2: start=8, end=10 -> next[0]=15 > 10 -> no merge -> [8,10]
 *   row=3: start=15, end=18 -> end of array -> [15,18]
 *   Result: [[1,6],[8,10],[15,18]]
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Sort intervals by start time.
 * 2. For each interval, try to extend `end` by merging overlapping intervals.
 * 3. When no more overlap, store the merged interval and move to next.
 *
 * POINTER / INDEX ADJUSTMENT RATIONALE:
 * - `intervals[row+1][0] <= end`: Next interval starts before current ends -> overlap.
 * - `end = Math.max(end, intervals[row+1][1])`: Take the larger end point.
 *
 * ============================
 * FUNCTION 15: findKthLargest (LC 215 - Kth Largest Element)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums = [3,2,3,1,2,4,5,5,6], k=4
 *   Find max repeatedly, excluding previously found maxes:
 *   Pass 1: max=6, Pass 2: max=5, Pass 3: max=4, Pass 4: max=3
 *   Return ans[3] = 3
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Repeat k times: find the current maximum (excluding previously found max).
 * 2. Store each max in `ans[index]`.
 * 3. Return `ans[k-1]`.
 *
 * ============================
 * FUNCTION 16: threeSum (LC 15 - 3Sum)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums = [-1, 0, 1, 2, -1, -4]
 *   Sorted: [-4, -1, -1, 0, 1, 2]
 *
 *   i=0 (-4): left=1, right=5 -> -4+(-1)+2=-3 < 0 -> left++
 *             left=2, right=5 -> -4+(-1)+2=-3 < 0 -> left++
 *             ...no triplet sums to 0
 *   i=1 (-1): left=2, right=5 -> -1+(-1)+2=0 ✓ -> add [-1,-1,2]
 *             left=3, right=4 -> -1+0+1=0 ✓ -> add [-1,0,1]
 *   i=2 (-1): skip (nums[2]==nums[1], duplicate)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Sort the array.
 * 2. Fix element `i`, use two-pointer (left, right) on remaining subarray.
 * 3. If sum > 0: right--. If sum < 0: left++. If sum == 0: record triplet.
 * 4. Skip duplicate values for both `i`, `left`, and `right`.
 *
 * POINTER / INDEX ADJUSTMENT RATIONALE:
 * - `if (i > 0 && nums[i] == nums[i-1]) continue`: Skip duplicate `i` values.
 * - After finding a triplet, skip duplicate `left` and `right` to avoid repeats.
 *
 * ============================
 * FUNCTION 17: threeSumClosest (LC 16 - 3Sum Closest)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums = [-1, 2, 1, -4], target = 1
 *   Sorted: [-4, -1, 1, 2]
 *
 *   i=0(-4): L=1,R=3: sum=-4+(-1)+2=-3, diff=|(-3)-1|=4, closest=-3
 *            L=2,R=3: sum=-4+1+2=-1, diff=2, closest=-1
 *   i=1(-1): L=2,R=3: sum=-1+1+2=2, diff=1, closest=2
 *   Return 2 (closest sum to target 1)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Sort the array.
 * 2. Fix element `i`, use two-pointer (left, right).
 * 3. Track minimum `|sum - target|` and update `closest`.
 * 4. If sum > target: right--. If sum < target: left++. If sum == target: return sum.
 *
 * UNIQUE FORMULA & LOGIC:
 * - Same two-pointer pattern as 3Sum but tracks closest instead of exact match.
 * - Early return when exact match `sum == target` is found.
 */
