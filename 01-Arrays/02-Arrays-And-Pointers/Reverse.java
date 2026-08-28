package Exersise;

import java.util.Arrays;

public class Reverse {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 9};
        System.out.println("the reverse array is : " + Arrays.toString(reverse(arr)));
    }
    static int[] reverse(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while (end > start) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            end--;
            start++;
        }
        return arr;
    }
}
/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   start                              end
 *     |                                 |
 *   [ 1,    2,    3,    4,    5,    9 ]
 *     \___________________________/
 *              Swap values
 *                 start++
 *                 end--
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Initialize `start = 0` and `end = arr.length - 1`.
 * 2. Loop while `end > start`:
 *    - Swap values at `arr[start]` and `arr[end]` using a temporary variable `temp`.
 *    - Move `start` forward (`start++`) and `end` backward (`end--`).
 * 3. Return `arr` reversed in place.
 *
 * POINTER ADJUSTMENT RATIONALE:
 * - `start++` and `end--` move the two pointers closer toward the middle of the array until they meet, reversing the array in-place.
 */