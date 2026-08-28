package Exersise;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(Arrays.toString(search(arr, 6)));
    }

    // search in the row provided between the cols provided
    static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            }
            if (matrix[row][mid] < target) {
                cStart = mid + 1;
            } else {
                cEnd = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    static int[] search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length; // be cautious, matrix may be empty
        if (cols == 0){
            return new int[] {-1,-1};
        }
        if (rows == 1) {
            return binarySearch(matrix,0, 0, cols-1, target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

        // run the loop till 2 rows are remaining
        while (rStart < (rEnd - 1)) { // while this is true it will have more than 2 rows
            int mid = rStart + (rEnd - rStart) / 2;
            if (matrix[mid][cMid] == target) {
                return new int[]{mid, cMid};
            }
            if (matrix[mid][cMid] < target) {
                rStart = mid;
            } else {
                rEnd = mid;
            }
        }

        // now we have two rows
        // check whether the target is in the col of 2 rows
        if (matrix[rStart][cMid] == target) {
            return new int[]{rStart, cMid};
        }
        if (matrix[rStart + 1][cMid] == target) {
            return new int[]{rStart + 1, cMid};
        }

        // search in 1st half
        if (target <= matrix[rStart][cMid - 1]) {
            return binarySearch(matrix, rStart, 0, cMid-1, target);
        }
        // search in 2nd half
        if (target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1]) {
            return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
        }
        // search in 3rd half
        if (target <= matrix[rStart + 1][cMid - 1]) {
            return binarySearch(matrix, rStart + 1, 0, cMid-1, target);
        } else {
            return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);
        }
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Step 1: Reduce matrix rows using middle column (cMid) until 2 rows remain.
 *
 *                    cStart        cMid        cEnd
 *                      |            |           |
 *     rStart (0) ----> [ 1,   2,    3,    4 ]   |
 *     rMid   (1) ----> [ 5,   6,   (7),   8 ] --+-- Compare target with matrix[mid][cMid]
 *     rEnd   (2) ----> [ 9,  10,   11,   12 ]   |
 *
 *   Step 2: Split remaining 2 rows into 4 Quadrants around cMid:
 *
 *                      cols: 0 ... cMid-1   cMid   cols: cMid+1 ... cols-1
 *                           +--------------+------+-----------------------+
 *     Row rStart           |  Quadrant 1  | cMid |      Quadrant 2       |
 *                           +--------------+------+-----------------------+
 *     Row rStart + 1       |  Quadrant 3  | cMid |      Quadrant 4       |
 *                           +--------------+------+-----------------------+
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Edge Checks: If matrix has 0 columns, return `{-1, -1}`. If 1 row, run 1D binary search on row 0.
 * 2. Row Reduction (Binary Search on Middle Column `cMid = cols / 2`):
 *    - Loop while `rStart < (rEnd - 1)` (keeps reducing until exactly 2 rows remain).
 *    - Calculate `mid = rStart + (rEnd - rStart) / 2`.
 *    - If `matrix[mid][cMid] == target`, return `{mid, cMid}`.
 *    - If `matrix[mid][cMid] < target`, eliminate rows above by setting `rStart = mid`.
 *    - Else eliminate rows below by setting `rEnd = mid`.
 * 3. Check 2 Center Elements of remaining 2 rows:
 *    - Check `matrix[rStart][cMid] == target` -> return `{rStart, cMid}`.
 *    - Check `matrix[rStart + 1][cMid] == target` -> return `{rStart + 1, cMid}`.
 * 4. Search 4 Quadrants using 1D Binary Search:
 *    - Quad 1: If `target <= matrix[rStart][cMid - 1]`, search row `rStart` from `0` to `cMid - 1`.
 *    - Quad 2: If `target >= matrix[rStart][cMid + 1]` && `target <= matrix[rStart][cols - 1]`, search row `rStart` from `cMid + 1` to `cols - 1`.
 *    - Quad 3: If `target <= matrix[rStart + 1][cMid - 1]`, search row `rStart + 1` from `0` to `cMid - 1`.
 *    - Quad 4: Else (target > `matrix[rStart + 1][cMid]`), search row `rStart + 1` from `cMid + 1` to `cols - 1`.
 *
 * POINTER ADJUSTMENT RATIONALE (`rStart = mid`, `rEnd = mid`):
 * - `rStart < (rEnd - 1)` ensures the loop stops as soon as `rEnd - rStart == 1` (exactly 2 rows left: `rStart` and `rStart + 1`).
 * - Setting `rStart = mid` (not `mid + 1`) preserves `mid` as a candidate row because `target` could be in the right half of row `mid`.
 *
 * QUADRANT SELECTION LOGIC & WHY:
 * - Quad 1 (Top-Left): If target is `<= matrix[rStart][cMid - 1]`, it is smaller than the middle element of row `rStart`, so it must lie in the left half of row `rStart`.
 * - Quad 2 (Top-Right): If target is `>= matrix[rStart][cMid + 1]` and `<= matrix[rStart][cols - 1]`, it falls within the range of the right half of row `rStart`.
 * - Quad 3 (Bottom-Left): If target is `<= matrix[rStart + 1][cMid - 1]`, it lies in the left half of row `rStart + 1`.
 * - Quad 4 (Bottom-Right): If target is greater than `matrix[rStart + 1][cMid]`, it can only be in the right half of row `rStart + 1`.
 */

