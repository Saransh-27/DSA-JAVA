import java.util.ArrayList;
import java.util.HashSet;

public class BinarySolution {
    public static void main(String[] args) {
//        int[][] grid = {
//                {4, 3, 2, 0},
//                {3, 2, 1, -1},
//                {1, 1, -1, -2},
//                {-1, -1, -2, -3}
//        };
//        System.out.println(BinarySolution.countNegatives(grid));

//        int[] nums1 = {4,9,5};
//        int[] nums2 = {9,4,9,8,4};
//        System.out.println(Arrays.toString(BinarySolution.intersection(nums1, nums2)));

//        int[] arr = {2,3,4,7,11};
//        int k = 5;
//        System.out.println(BinarySolution.findKthPositive(arr, k));

//        int[] nums1 = {4,9,5};
//        int[] nums2 = {9,4,9,8,4};
//        System.out.println(Arrays.toString(BinarySolution.intersect(nums1, nums2)));

//        int[] nums = {1,0,1,1,1};
//        int target = 0;
//        System.out.println(BinarySolution.search(nums, target));
//
//        int[] nums = {11,13, 15, 17};
//        System.out.println(findMin(nums));

//        int[][] matrix = {
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}
//        };
//        int target = 253;
//        System.out.println(BinarySolution.searchMatrix(matrix, target));


//        int[][] mat = {
//                {10,20,15,13,35,36,37,14},
//                {9,21,20,1,34,3,38,2},
//                {7,22,23,24,33,6,5,4}
//        };
//        System.out.println(Arrays.toString(BinarySolution.findPeakGrid(mat)));

//        int[] piles = {3,6,7,11};
//        int h = 8;
//        System.out.println(BinarySolution.minEatingSpeed(piles, h));

        int[] nums = {2,2,2,2,2,0,2,2,2,2};
        System.out.println(BinarySolution.findMinWithDuplicates(nums));
    }
    static int countNegatives(int[][] grid) {
        int counter = 0;
        int i =0;
        int j = grid[0].length -1;
        while(i<grid.length){
                if(grid[i][j]<0){
                    int start = search(grid, i, 0, j);
                    counter += (grid[i].length - start);
                }
            i++;
        }
        return counter;
    }

    static int search(int[][] matrix, int row, int cStart, int cEnd){
        while(cStart <= cEnd){
            int mid = Math.abs(cStart + (cEnd - cStart)/2);
            if(matrix[row][mid] < 0){
                cEnd = mid -1;
            }else{
                cStart = mid+1;
            }
        }
        return cStart;
    }

    static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length <= nums2.length){
            return search(nums2, nums1);
        }else{
            return search(nums1, nums2);
        }
    }

    static int[] search(int[] arr, int[] target){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < target.length; i++){
            int element = target[i];
            if(binarySearch(arr, element)){
                set.add(element);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    static boolean binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return true;
            }else if(arr[mid] < target){
                start = mid +1;
            }else{
                end = mid -1;
            }
        }
        return false;
    }



    static int findKthPositive(int[] arr, int k) {
        int start =0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return k+start;
    }

    static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length >= nums2.length){
            return find(nums1, nums2);
        }else{
            return find(nums2, nums1);
        }
    }

    static int[] find(int[] arr, int[] target){
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i: target){
            set.add(i);
        }

        for(int i =0; i< arr.length; i++){
            if(set.contains(arr[i])){
                ans.add(arr[i]);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            
            // Left half is sorted
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                // Right half is sorted
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;
        while(row < col){
            if(matrix[row][col] >= target && target > matrix[row][0]){
                return binarySearch(matrix, row, 0, col, target);
            }
            row++;
        }
        return false;
    }

    static boolean binarySearch(int[][] matrix,int row, int cStart, int cEnd, int target){
        while(cStart <= cEnd){
            int mid = cStart + (cEnd - cStart)/2;
            if(matrix[row][mid] < target){
                cStart = mid +1;
            }else if(matrix[row][mid] > target){
                cEnd = mid -1;
            }else{
                return true;
            }
        }
        return false;
    }


    static int[] findPeakGrid(int[][] mat){
        int cStart =0;
        int cEnd = mat[0].length-1;
        while(cStart <= cEnd){
            int midCol = cStart + (cEnd - cStart)/2;
            int[] peak2 = findPeak(mat, midCol);
//            int row = peak2[0];
            if(midCol < cEnd && mat[peak2[0]][peak2[1]] < mat[peak2[0]][peak2[1]+1]){
               cStart = midCol + 1;
           }else if(midCol > 0 && mat[peak2[0]][peak2[1]] < mat[peak2[0]][peak2[1]-1]){
                cEnd = midCol - 1;
           }else{
                return peak2;
           }
        }
        return new int[]{-1,-1};
    }

    static int[] findPeak(int[][] mat, int col) {
        int maxRow = 0;
        for (int row = 1; row < mat.length; row++) {
            if (mat[row][col] > mat[maxRow][col]) {
                maxRow = row;
            }
        }
        return new int[]{maxRow, col};
    }

    static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = max(piles);
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (ceil(piles, mid, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int max(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int i : piles) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    static boolean ceil(int[] piles, int mid, int h) {
        int sum = 0;
        for (int i : piles) {
            sum += (i + mid - 1) / mid; // This is equivalent to Math.ceil((double) i / mid)
        }
        return sum <= h;
    }

    static int findMinWithDuplicates(int[] nums) {
        int start =0;
        int end = nums.length-1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(mid < nums.length-1 && nums[mid] > nums[end]){
                start = mid +1;
            }else if(mid > 0 && nums[mid] < nums[end]){
                end = mid;
            }else{
                end--;
            }
        }
        return nums[start];
    }

}

/*
 * ============================
 * FUNCTION 1: countNegatives (LC 1351 - Count Negative Numbers in Sorted Matrix)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   grid = [[ 4,  3,  2,  0],
 *           [ 3,  2,  1, -1],
 *           [ 1,  1, -1, -2],
 *           [-1, -1, -2, -3]]
 *
 *   Row 0: last col=0 (non-negative) -> no negatives
 *   Row 1: last col=-1 (negative) -> binary search -> negatives start at col 3 -> 1
 *   Row 2: last col=-2 -> binary search -> negatives start at col 2 -> 2
 *   Row 3: last col=-3 -> binary search -> negatives start at col 0 -> 4
 *   Total = 0+1+2+4 = 7
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. For each row, check if the last element is negative.
 * 2. If yes, binary search for the first negative element's index.
 * 3. Count = (row length - first negative index).
 * 4. Sum counts across all rows.
 *
 * UNIQUE FORMULA & LOGIC:
 * - Binary search helper `search(grid, row, cStart, cEnd)` finds the first
 *   negative position by searching where values flip from non-negative to negative.
 *
 * ============================
 * FUNCTION 2: intersection (LC 349 - Intersection of Two Arrays)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums1 = [4, 9, 5],  nums2 = [9, 4, 9, 8, 4]
 *   Iterate smaller array, binary search each element in larger.
 *   4 found, 9 found, 5 not found
 *   HashSet eliminates duplicates -> Result: [4, 9]
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Choose the smaller array as `target`, larger as `arr`.
 * 2. For each element in `target`, binary search in `arr`.
 * 3. If found, add to HashSet (auto-dedup).
 * 4. Convert HashSet to int array.
 *
 * EDGE CASE HANDLING:
 * - HashSet ensures duplicate intersections are counted only once.
 * - Smaller array is iterated to minimize binary search calls.
 *
 * ============================
 * FUNCTION 3: findKthPositive (LC 1539 - Kth Missing Positive Number)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   arr = [2, 3, 4, 7, 11],  k = 5
 *
 *   Index:    0  1  2  3  4
 *   Value:    2  3  4  7  11
 *   Expected: 1  2  3  4  5   (if no missing)
 *   Missing:  1  1  1  3  6   (arr[mid] - (mid+1))
 *                     ^
 *               missing[3]=3 < 5 -> start = 4
 *               missing[4]=6 >= 5 -> end = 3
 *   Answer = k + start = 5 + 4 = 9
 *
 *   Verification: missing positives = 1, 5, 6, 8, 9 -> 5th = 9
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Binary search on `missing = arr[mid] - (mid + 1)`.
 * 2. If `missing < k`: start = mid + 1 (kth missing is further right).
 * 3. If `missing >= k`: end = mid - 1 (kth missing is at or before mid).
 * 4. Return `k + start`.
 *
 * UNIQUE FORMULA & LOGIC:
 * - `arr[mid] - (mid + 1)` = count of missing numbers before index mid.
 * - Answer = `k + start`: start tells where in the array to "insert" the kth missing.
 *
 * ============================
 * FUNCTION 4: intersect (Intersection with duplicates)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums1 = [4, 9, 5],  nums2 = [9, 4, 9, 8, 4]
 *   Put smaller into HashSet: {4, 9, 5}
 *   Scan larger: 9 yes, 4 yes, 9 yes, 8 no, 4 yes -> [9, 4, 9, 4]
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Put smaller array elements into a HashSet.
 * 2. Scan larger array: if element exists in set, add to result.
 * 3. (Note: includes duplicates from the larger array.)
 *
 * ============================
 * FUNCTION 5: search (LC 33 - Search in Rotated Sorted Array)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums = [4, 5, 6, 7, 0, 1, 2],  target = 0
 *
 *   start=0, end=6, mid=3 (nums[3]=7)
 *   Left half [4,5,6,7] is sorted (nums[0]=4 <= nums[3]=7)
 *   target=0 NOT in [4..7) -> search right: start=4
 *
 *   start=4, end=6, mid=5 (nums[5]=1)
 *   Left half [0,1] is sorted (nums[4]=0 <= nums[5]=1)
 *   target=0 in [0..1) -> search left: end=4
 *
 *   start=4, end=4, mid=4 (nums[4]=0) == target -> Return 4!
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Binary search with `start`, `end`, `mid`.
 * 2. Check if left half [start..mid] is sorted (`nums[start] <= nums[mid]`).
 *    - If target is in sorted left range -> end = mid - 1.
 *    - Else -> start = mid + 1.
 * 3. If right half is sorted:
 *    - If target is in sorted right range -> start = mid + 1.
 *    - Else -> end = mid - 1.
 *
 * POINTER / INDEX ADJUSTMENT RATIONALE:
 * - At least one half is always sorted in a rotated array.
 * - We check the sorted half first to determine which side target falls on.
 *
 * ============================
 * FUNCTION 6: findMin (LC 153 - Find Minimum in Rotated Sorted Array)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums = [3, 4, 5, 1, 2]
 *
 *   start=0, end=4, mid=2: nums[2]=5 > nums[4]=2 -> min is RIGHT -> start=3
 *   start=3, end=4, mid=3: nums[3]=1 <= nums[4]=2 -> min is LEFT or AT -> end=3
 *   start==end==3 -> Return nums[3] = 1
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Binary search while `start <= end`.
 * 2. If `nums[mid] > nums[end]`: rotation point is right -> start = mid + 1.
 * 3. Else: mid could be the min -> end = mid.
 * 4. Return `nums[start]`.
 *
 * POINTER / INDEX ADJUSTMENT RATIONALE:
 * - `start = mid + 1`: mid is larger than end, so mid cannot be the minimum.
 * - `end = mid`: mid could be the minimum, so we don't skip it.
 *
 * ============================
 * FUNCTION 7: searchMatrix (LC 74 - Search a 2D Matrix)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   matrix = [[1,  3,  5,  7],
 *             [10, 11, 16, 20],
 *             [23, 30, 34, 60]]   target = 3
 *
 *   Row 0: matrix[0][3]=7 >= 3 AND 3 > matrix[0][0]=1 -> binary search row 0
 *   Binary search [1,3,5,7]: mid=5 > 3 -> end=1, mid=3 == 3 -> TRUE
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. For each row, check if target falls within [row[0], row[last]].
 * 2. If yes, binary search that row for the target.
 * 3. Return true if found, false otherwise.
 *
 * ============================
 * FUNCTION 8: findPeakGrid (LC 1901 - Find a Peak Element II)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   mat = [[10, 20, 15, 13, 35, 36, 37, 14],
 *          [ 9, 21, 20,  1, 34,  3, 38,  2],
 *          [ 7, 22, 23, 24, 33,  6,  5,  4]]
 *
 *   Binary search on COLUMNS:
 *   cStart=0, cEnd=7, midCol=3
 *   Find max in col 3: row=2 (val=24)
 *   mat[2][3]=24 < mat[2][4]=33 -> peak is RIGHT -> cStart=4
 *
 *   cStart=4, cEnd=7, midCol=5
 *   Find max in col 5: row=0 (val=36)
 *   mat[0][5]=36 < mat[0][6]=37 -> peak is RIGHT -> cStart=6
 *
 *   cStart=6, cEnd=7, midCol=6
 *   Find max in col 6: row=0 (val=37)
 *   mat[0][6]=37 > mat[0][7]=14 AND mat[0][6]=37 > mat[0][5]=36 -> PEAK at [0,6]
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Binary search on columns: cStart, cEnd.
 * 2. For midCol, find the row with the maximum value (column maximum).
 * 3. Compare peak with left and right neighbors:
 *    - If right neighbor is larger -> cStart = midCol + 1.
 *    - If left neighbor is larger -> cEnd = midCol - 1.
 *    - Else -> current position is the peak.
 *
 * UNIQUE FORMULA & LOGIC:
 * - Column-wise binary search reduces 2D peak finding to O(N log M).
 * - Finding column max ensures vertical neighbors are already smaller.
 *
 * ============================
 * FUNCTION 9: minEatingSpeed (LC 875 - Koko Eating Bananas)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   piles = [3, 6, 7, 11],  h = 8
 *
 *   Binary search on speed k: low=1, high=11
 *   mid=6: hours = ceil(3/6)+ceil(6/6)+ceil(7/6)+ceil(11/6) = 1+1+2+2 = 6 <= 8 -> high=6
 *   mid=3: hours = 1+2+3+4 = 10 > 8 -> low=4
 *   mid=5: hours = 1+2+2+3 = 8 <= 8 -> high=5
 *   mid=4: hours = 1+2+2+3 = 8 <= 8 -> high=4
 *   low==high==4 -> Return 4
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Binary search on speed: low=1, high=max(piles).
 * 2. For each mid speed, calculate total hours: sum of ceil(pile/mid) for all piles.
 * 3. If total hours <= h: speed is feasible -> try slower (high = mid).
 * 4. Else: too slow -> need faster (low = mid + 1).
 * 5. Return low.
 *
 * UNIQUE FORMULA & LOGIC:
 * - `ceil(pile/mid) = (pile + mid - 1) / mid` avoids floating-point division.
 * - Binary search on answer: instead of searching the array, search the solution space.
 *
 * ============================
 * FUNCTION 10: findMinWithDuplicates (LC 154 - Find Min in Rotated Sorted Array II)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums = [2, 2, 2, 2, 2, 0, 2, 2, 2, 2]
 *
 *   start=0, end=9, mid=4: nums[4]=2 == nums[9]=2 -> can't decide -> end--
 *   start=0, end=8, mid=4: nums[4]=2 == nums[8]=2 -> end--
 *   ... (shrink end until duplicates are gone)
 *   Eventually: nums[mid] > nums[end] -> start = mid + 1 -> finds 0
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Binary search while `start < end`.
 * 2. If `nums[mid] > nums[end]`: min is right -> start = mid + 1.
 * 3. If `nums[mid] < nums[end]`: min is left or at mid -> end = mid.
 * 4. Else (nums[mid] == nums[end]): can't decide -> end-- (shrink).
 *
 * POINTER / INDEX ADJUSTMENT RATIONALE:
 * - `end--` is the key difference from LC 153 (no duplicates).
 *   When mid == end, we can't determine which side has the min,
 *   so we safely shrink end by 1 (worst case O(n), but usually O(log n)).
 *
 * EDGE CASE HANDLING:
 * - All duplicates: [2,2,2,2] degrades to O(n) linear scan via end--.
 * - Already sorted: [1,2,3] -> nums[mid] < nums[end] always -> end converges to 0.
 */
