package Exersise;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
//        System.out.println("Enter 5 numbers for array");
//        // Use an index-based loop to fill the array
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = sc.nextInt();
//        }
        System.out.println("The numbers is found at index : " + search(arr, 1, 4));
        System.out.println("The numbers is found at index : " + search(arr));

        int[][] arr2D = {
                {1,2,3,4},
                {5,6,7,8,9},
                {11, 13, 12, 14, 15}
        };
        int target2D = 2;
        int[] ans = search2D(arr2D, target2D);
        System.out.println("The number in 2D array is : " + Arrays.toString(ans));

    }

    static int search(int[] arr) {
        if(arr.length == 0){
            return -1;
        }
        System.out.println("Enter the number to search");
        int target = sc.nextInt();
        // Use a for-each to examine values directly
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int search(int[] arr, int start, int end) {
        if(arr.length == 0){
            return -1;
        }
        System.out.println("Enter the number to search");
        int target = sc.nextInt();
        // Use a for-each to examine values directly
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int[] search2D(int[][] arr2D, int target) {
        if (arr2D.length == 0) {
            return new int[]{-1, -1};
        }
//        int min = arr2D[0][0];
        for (int row = 1; row < arr2D.length; row++) {
            for (int col = 0; col < arr2D[row].length; col++) {
                int num = arr2D[row][col];
                if (num == target) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   1D Array Linear Search:
 *   Index:   0    1    2    3    4
 *   Array: [ 1,   2,   3,   4,   5 ]
 *            ^    ^    ^
 *            i=0  i=1  i=2 (arr[i] == target -> Return index 2)
 *
 *   2D Array Linear Search:
 *   Row 0: [ 1,  2,  3,  4 ]
 *   Row 1: [ 5,  6,  7,  8,  9 ]
 *   Row 2: [ 11, 13, 12, 14, 15 ]
 *            ^
 *            (row=2, col=0 -> arr2D[row][col] == target -> Return {2, 0})
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. 1D Full Search: Loop `i` from index 0 to `arr.length - 1`. If `arr[i] == target`, return `i`.
 * 2. 1D Range Search: Loop `i` from `start` to `end`. If `arr[i] == target`, return `i`.
 * 3. 2D Search: Outer loop iterates through each `row`, inner loop iterates through each `col`. If `arr2D[row][col] == target`, return `{row, col}`.
 * 4. If target is not found in any function, return `-1` (or `{-1, -1}`).
 *
 * POINTER ADJUSTMENT RATIONALE:
 * - `i++` / `col++`: Moves sequentially element-by-element through the search space in O(N) time for 1D and O(N * M) time for 2D.
 *
 * EDGE CASE HANDLING:
 * - Empty array check (`arr.length == 0`): Immediately returns `-1` or `{-1, -1}` to avoid ArrayIndexOutOfBoundsException.
 */


