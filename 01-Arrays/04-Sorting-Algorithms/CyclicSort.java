package Exersise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr ={4,3,2,7,8,2,3,1};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(findMissing(arr));
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    static List<Integer> findMissing(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int correctIndex = arr[i] - 1;
            if (i != correctIndex && arr[i] == arr[correctIndex]) {
                list.add(arr[i]);
            }
        }
        return list;
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Original Array:  [ 4, 3, 2, 7, 8, 2, 3, 1 ]
 *   Target Pattern:  Values 1 to N belong at index (value - 1)
 *
 *   Step 1 (i=0, val=4): Correct Index for 4 is (4 - 1) = 3 -> Swap arr[0] and arr[3]
 *   Swap: [ 7, 3, 2, 4, 8, 2, 3, 1 ]  (i stays 0!)
 *   Step 2 (i=0, val=7): Correct Index for 7 is (7 - 1) = 6 -> Swap arr[0] and arr[6]
 *   Swap: [ 3, 3, 2, 4, 8, 2, 7, 1 ]  (i stays 0!)
 *   ...
 *   Sorted Array:    [ 1, 2, 3, 4, 2, 3, 7, 8 ]
 *                      ^  ^  ^  ^  ^  ^  ^  ^
 *             Indices: 0  1  2  3  4  5  6  7  -> Duplicates placed at mismatched indices 4 & 5!
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Initialize pointer `i = 0`.
 * 2. Cyclic Sorting Phase: While `i < arr.length`:
 *    - Calculate `correctIndex = arr[i] - 1`.
 *    - If `arr[i] != arr[correctIndex]`, swap `arr[i]` with `arr[correctIndex]` (do NOT increment `i`).
 *    - Else (element is already at its correct index or duplicate is in place), increment `i++`.
 * 3. Finding Duplicates Phase (`findMissing`):
 *    - Iterate through the sorted array. If `i != correctIndex` and `arr[i] == arr[correctIndex]`, collect `arr[i]` into the list.
 *
 * POINTER ADJUSTMENT RATIONALE (`i++` only when element is in correct place):
 * - We do NOT increment `i` when a swap occurs because the newly swapped element at `arr[i]` may also be out of place and needs to be moved to its own correct index.
 *
 * UNIQUE FORMULA & LOGIC:
 * - `correctIndex = arr[i] - 1`: Maps 1-based element values (1..N) to 0-based array indices (0..N-1) in O(N) linear time.
 */


