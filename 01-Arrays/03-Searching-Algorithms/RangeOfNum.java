package Exersise;

import java.util.Arrays;

public class RangeOfNum {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 7, 7,8, 8, 10};
        int target =7;
        int[] ans = {-1, -1};
        int startIndex = rangeOfNum(arr, target, true);
        int endIndex = rangeOfNum(arr, target, false);
        System.out.println(Arrays.toString((startIndex + "" + endIndex).toCharArray()));
    }

    static int rangeOfNum(int[] arr, int target, boolean findstart) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                result = mid;
                if (findstart) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            }
        }
        return result;
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Index:      0    1    2    3    4    5    6    7
 *   Array:   [  5,   7,   7,   7,   7,   8,   8,  10 ]
 *                    ^              ^
 *              First Occurrence   Last Occurrence
 *                (startIndex)       (endIndex)
 *
 *   For First Occurrence (findstart = true):
 *     When arr[mid] == target -> result = mid, keep searching LEFT  (end = mid - 1)
 *   For Last Occurrence (findstart = false):
 *     When arr[mid] == target -> result = mid, keep searching RIGHT (start = mid + 1)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Initialize `start = 0`, `end = arr.length - 1`, and `result = -1`.
 * 2. Loop while `start <= end`:
 *    - Compute `mid = start + (end - start) / 2`.
 *    - If `arr[mid] == target`, store `result = mid`.
 *      - If `findstart` is true, continue searching left (`end = mid - 1`) to find the first occurrence.
 *      - If `findstart` is false, continue searching right (`start = mid + 1`) to find the last occurrence.
 *    - If `target < arr[mid]`, move left (`end = mid - 1`).
 *    - If `target > arr[mid]`, move right (`start = mid + 1`).
 * 3. Return `result`.
 *
 * POINTER ADJUSTMENT RATIONALE (`end = mid - 1`, `start = mid + 1`):
 * - Once `arr[mid]` is checked, `mid` itself is recorded in `result` or eliminated from consideration.
 * - `end = mid - 1` shifts the right boundary to exclude `mid` and search exclusively in the left sub-array.
 * - `start = mid + 1` shifts the left boundary to exclude `mid` and search exclusively in the right sub-array.
 * - Guarantees progress on every iteration and prevents infinite loops when `start == end`.
 *
 * UNIQUE LOGIC:
 * - Unlike standard binary search which returns immediately upon finding `target`, this function saves `result` and keeps narrowing the search space to find exact boundary occurrences.
 */




