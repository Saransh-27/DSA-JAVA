package Exersise;

import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 6},
                {7, 1},
                {5, 2},
                {4, 8}
        };

        System.out.println("Lucky numbers in the matrix: " + luckyNumbers(matrix));
    }
    static List<Integer> luckyNumbers(int[][] matrix) {
        int[] min = new int[matrix.length];
        for(int i =0; i <matrix.length; i++){
            min[i] = find(matrix[i], true);
        }
        return List.of(find(min, false));
    }

    static int find(int[] arr, boolean isMin){
        if (arr.length == 0){
            return -1;
        }
        if (isMin) {
            int min = Integer.MAX_VALUE;
            for (int j : arr) {
                if (j < min) {
                    min = j;
                }
            }
            return min;
        }else{
            int max = Integer.MIN_VALUE;
            for(int j : arr){
                if(j > max){
                    max = j;
                }
            }
            return max;
        }
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Matrix:
 *           Col 0   Col 1
 *   Row 0 [   3,      6   ]  --> Row Min = 3
 *   Row 1 [   7,      1   ]  --> Row Min = 1
 *   Row 2 [   5,      2   ]  --> Row Min = 2
 *   Row 3 [   4,      8   ]  --> Row Min = 4
 *
 *   Row Mins Array = [ 3, 1, 2, 4 ]
 *   Max of Row Mins = 4  <-- Lucky Number Candidate
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Iterate through each row of the matrix to find the minimum element of that row.
 * 2. Store the minimum value of each row `i` into an array `min[i]`.
 * 3. Find the maximum element among all row minimums stored in `min[]`.
 * 4. Return the result wrapped in a List (`List.of(...)`).
 *
 * UNIQUE FORMULA & LOGIC:
 * - A Lucky Number in a matrix is minimum in its row and maximum in its column.
 * - `find(matrix[i], true)` finds the minimum value in a row, while `find(min, false)` finds the maximum among all row minimums.
 */