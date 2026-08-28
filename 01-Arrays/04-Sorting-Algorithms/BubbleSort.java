package Exersise;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j =1; j < arr.length - i; j++) {
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Pass 1 (i=0):
 *   [ 5,  4,  3,  2,  1 ]
 *     \--/ -> Swap -> [ 4,  5,  3,  2,  1 ]
 *         \--/ -> Swap -> [ 4,  3,  5,  2,  1 ]
 *             \--/ -> Swap -> [ 4,  3,  2,  5,  1 ]
 *                 \--/ -> Swap -> [ 4,  3,  2,  1, (5) ]  <-- Largest element (5) bubbled to end!
 *
 *   Pass 2 (i=1):
 *   [ 4,  3,  2,  1, | (5) ]
 *     \--/ \--/ \--/  -> [ 3,  2,  1, (4), (5) ]       <-- Next largest (4) placed!
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Outer loop `i` runs from `0` to `arr.length - 1`.
 * 2. Set boolean flag `swapped = false` before each inner pass.
 * 3. Inner loop `j` compares adjacent elements from `1` to `arr.length - i - 1`:
 *    - If `arr[j] < arr[j - 1]`, swap them using temporary variable `temp` and set `swapped = true`.
 * 4. After each pass `i`, the largest unsorted element "bubbles up" to its correct sorted position at the end.
 * 5. Early Exit Check: If `!swapped` after an inner pass, no swaps occurred (array is sorted), break early.
 *
 * POINTER / INDEX ADJUSTMENT RATIONALE (`arr.length - i`):
 * - After `i` passes, the last `i` elements are guaranteed to be sorted at the end.
 * - Restricting inner loop to `arr.length - i` avoids re-checking already sorted trailing elements.
 *
 * EDGE CASE & OPTIMIZATION HANDLING:
 * - `swapped` flag: Optimizes best-case time complexity to O(N) when array is already sorted.
 */

