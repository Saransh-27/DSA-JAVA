package Exersise;

import java.util.Arrays;

public class FindPositiveMissing {
    public static void main(String[] args) {
        int[] arr = {7,8,9,10,11,12};
        int missing = sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(missing);
    }

    static int sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correctIndex]) {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }

        return findMissing(arr);
    }

    static int findMissing(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return arr.length + 1;
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Array:     [ 7, 8, 9, 10, 11, 12 ]   (N=6)
 *   Rule:      Positive number v in 1..N belongs at index (v - 1). Ignore <=0 or >N!
 *
 *   Cyclic Sort pass:
 *   i=0: arr[0]=7 > N (6) -> Skip -> i++
 *   i=1: arr[1]=8 > N (6) -> Skip -> i++
 *   ...
 *   All elements > N -> Array remains [ 7, 8, 9, 10, 11, 12 ]
 *
 *   Scan Phase (i=0..N-1):
 *   i=0: arr[0]=7 != (0+1=1) --> First Missing Positive is 1!
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Cyclic Sort Phase (`sort`):
 *    - Loop `i` from `0` to `arr.length - 1`.
 *    - Calculate `correctIndex = arr[i] - 1`.
 *    - If `arr[i] > 0` AND `arr[i] <= arr.length` AND `arr[i] != arr[correctIndex]`, swap `arr[i]` with `arr[correctIndex]`.
 *    - Else (element is negative, 0, > N, or already in correct place), increment `i++`.
 * 2. Search Phase (`findMissing`):
 *    - Loop `i` from `0` to `arr.length - 1`.
 *    - If `arr[i] != i + 1`, return `i + 1` (the smallest missing positive integer).
 *    - If all 1..N numbers are present, return `arr.length + 1` (N + 1).
 *
 * EDGE CASE HANDLING (`arr[i] > 0 && arr[i] <= arr.length`):
 * - Ignores non-positive numbers (<= 0) and numbers larger than array length (> N) because the first missing positive must lie within range `1` to `N + 1`.
 */

