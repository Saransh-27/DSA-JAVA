package Exersise;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,3,4,2,1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertionSort(int[] arr){
            for (int i = 0; i < arr.length-1; i++){
                for (int j = i+1; j> 0; j--){
                    if (arr[j] < arr[j-1]){
                        int temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;
                    }else{
                        break;
                    }
                }
            }

    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Array: [ 5, 3, 4, 2, 1 ]
 *
 *   i=0: sorted=[5], insert 3 -> [ 3, 5 | 4, 2, 1 ]
 *   i=1: sorted=[3, 5], insert 4 -> [ 3, 4, 5 | 2, 1 ]
 *   i=2: sorted=[3, 4, 5], insert 2 -> [ 2, 3, 4, 5 | 1 ]
 *   i=3: sorted=[2, 3, 4, 5], insert 1 -> [ 1, 2, 3, 4, 5 ] (Fully Sorted!)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Outer loop `i` runs from `0` to `arr.length - 2` (divides array into sorted LHS `0..i` and unsorted RHS).
 * 2. Inner loop `j` starts at `i + 1` (the new element to insert) and moves backward while `j > 0`:
 *    - Compare `arr[j]` with its left neighbor `arr[j - 1]`.
 *    - If `arr[j] < arr[j - 1]`, swap them to shift element leftward into its correct position.
 *    - Else (if `arr[j] >= arr[j - 1]`), break inner loop immediately because the left sub-array is already sorted.
 *
 * POINTER ADJUSTMENT RATIONALE (`j--` backward loop):
 * - Iterating `j` backwards shifts the element to the left until it reaches its correct sorted position in the sorted sub-array `0..i`.
 *
 * UNIQUE FORMULA & LOGIC:
 * - Adaptive Sorting (`break`): Best-case time complexity is O(N) when array is already sorted, because inner loop breaks on first comparison.
 */

