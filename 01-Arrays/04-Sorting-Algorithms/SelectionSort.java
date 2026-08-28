package Exersise;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selection(int[] arr){
        for (int i=0;i<arr.length;i++){
            int last = arr.length-i-1;
            int max = findMax(arr, 0, last);
            swap(arr, max, last);
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    } 

    static int findMax(int[] arr, int start, int last) {
        int max = start;
        for (int i = start; i <= last; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Pass 1 (i=0): last = index 4 (value 1)
 *   Unsorted range [0..4]: [ 5,  4,  3,  2,  1 ]
 *                            ^
 *                   maxIndex = 0 (value 5)
 *   Swap arr[max] with arr[last] -> [ 1,  4,  3,  2, (5) ]  <-- 5 placed at correct end index!
 *
 *   Pass 2 (i=1): last = index 3 (value 2)
 *   Unsorted range [0..3]: [ 1,  4,  3,  2 | (5) ]
 *                                ^
 *                       maxIndex = 1 (value 4)
 *   Swap arr[max] with arr[last] -> [ 1,  2,  3, (4), (5) ] <-- 4 placed at correct index!
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Outer loop `i` runs from `0` to `arr.length - 1`.
 * 2. Calculate target end position for unsorted range: `last = arr.length - i - 1`.
 * 3. Find index of maximum element in unsorted range `[0, last]` using `findMax(arr, 0, last)`.
 * 4. Swap element at `max` index with element at `last` index using `swap(arr, max, last)`.
 * 5. Repeat process until the array is completely sorted.
 *
 * POINTER / INDEX ADJUSTMENT RATIONALE (`last = arr.length - i - 1`):
 * - After each pass `i`, one maximum element is placed at index `last`, shrinking the unsorted range by 1 on each step.
 *
 * UNIQUE FORMULA & LOGIC:
 * - Select & Place: Selection Sort performs at most 1 swap per pass (O(N) total swaps), minimizing array mutations compared to Bubble Sort.
 */

