import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2D {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        System.out.println(spiralOrder1(matrix));
//        System.out.println(Arrays.deepToString(spiral2(3)));
//        List<List<String>> items = Arrays.asList(
//            Arrays.asList("phone", "blue", "pixel"),
//            Arrays.asList("computer", "silver", "lenovo"),
//            Arrays.asList("phone", "gold", "iphone")
//        );
//        String ruleKey = "color";
//        String ruleValue = "silver";
//        System.out.println(countMatches(items, ruleKey, ruleValue));
//        int[] gain = {52,-91,72};
//        System.out.println(largestAltitude(gain));
//        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
//        System.out.println(luckyNumbers(matrix));
//        int[][] mat = {{1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        System.out.println(Arrays.deepToString(transpose(mat)));
//        int[] num = {9,9,9,9,9,9,9,9,9,9};
//        int k = 1;
//        System.out.println(addToArrayForm(num, k));
//        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
//        int[][] target = {{1,1,1},{0,1,0},{0,0,0}};
//        System.out.println(findRotation(mat, target));
//        System.out.println(Arrays.deepToString(generateMatrix(3)));
        System.out.println(Arrays.deepToString(spiralMatrixIII(5, 6, 1, 4)));
    }

    static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rStart = 0;
        int rEnd = matrix.length - 1;
        int cStart = 0;
        int cEnd = matrix[0].length - 1;
        while (rStart <= rEnd && cStart <= cEnd) {
            // 1. Left to Right
            for (int col = cStart; col <= cEnd; col++) {
                ans.add(matrix[rStart][col]);
            }
            rStart++;
            // 2. Top to Bottom
            for (int row = rStart; row <= rEnd; row++) {
                ans.add(matrix[row][cEnd]);
            }
            cEnd--;
            // 3. Right to Left
            if (rStart <= rEnd) {
                for (int col = cEnd; col >= cStart; col--) {
                    ans.add(matrix[rEnd][col]);
                }
                rEnd--;
            }
            // 4. Bottom to Top
            if (cStart <= cEnd) {
                for (int row = rEnd; row >= rStart; row--) {
                    ans.add(matrix[row][cStart]);
                }
                cStart++;
            }
        }
        return ans;
    }

    static public int[][] spiral2(int n) {
        int[][] arr = new int[n][n];
        int value = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = value++;
            }
        }
        return arr;
    }

    static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int counter =0;
        int cvalue = 0;
        if(ruleKey.equals("type")){
            cvalue = 0;
        }else if(ruleKey.equals("color")){
            cvalue = 1;
        }else{
            cvalue = 2;
        }
        for(int i =0; i< items.size(); i++){
            if(ruleValue.equals(items.get(i).get(cvalue))){
                counter++;
            }
        }
        return counter;
    }

    static int largestAltitude(int[] gain) {
        int sum =0;
        int max = 0;
        for(int i = gain.length-2; i >= 0; i--){
            sum += gain[i];
        }
        for(int i = gain.length-1; i >= 0; i--){
            gain[i] += sum;
            if(gain[i] > max){
                max = gain[i];
            }
            if(i> 0) {
                sum -= gain[i - 1];
            }else {
                sum -= gain[0];
            }
        }
        System.out.println(Arrays.toString(gain));
        return max;
    }

    static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int[] rowmin = new int[matrix.length];
        int[] colmax = new int[matrix[0].length];
        for(int i =0; i< matrix.length; i++) {
            int minNumb = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < minNumb) {
                    minNumb = matrix[i][j];
                }
            }
            rowmin[i] = minNumb;
        }
        for(int j =0; j< matrix[0].length; j++) {
            int maxNumb = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] > maxNumb) {
                    maxNumb = matrix[i][j];
                }
            }
            colmax[j] = maxNumb;
        }
        for(int i =0; i<matrix.length; i++){
            for(int j =0; j<matrix[0].length; j++){
            if(rowmin[j] == colmax[i]){
                result.add(rowmin[j]);
            }

            }
        }
        return result;
    }

    static int diagonalSum(int[][] mat) {
        int row =0;
        int leftCol =0;
        int rightCol = mat.length -1;
        int sum =0;
        while(row < mat.length){
            sum += mat[row][leftCol];
            if(leftCol != rightCol){
            sum += mat[row][rightCol];
            }
            row++;
            leftCol++;
            rightCol--;
        }
        return sum;
    }

    static int[][] transpose(int[][] matrix) {
        int[][] ans = new int[matrix[0].length][matrix.length];
        int i =0;
        while(i< ans.length){
            for(int j =0; j < matrix.length; j++){
                ans[i][j] = matrix[j][i];
            }
            i++;
        }
        return ans;
    }

    static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for (int j : num) {
            str.append(j);
        }
        int sum = Integer.parseInt(str.toString()) + k;
        while (sum > 0) {
            ans.add(0, sum % 10);
            sum /= 10;
        }
        return ans;
    }

    static  boolean findRotation(int[][] mat, int[][] target) {
        for (int k = 0; k < 3; k++) {
            rotate(mat);
            if (isEqual(mat, target)) {
                return true;
            }
        }
        return false;
    }

    static boolean isEqual(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void rotate(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int value = 1;
        int rStart = 0;
        int rEnd = arr.length - 1;
        int cStart = 0;
        int cEnd = arr[0].length - 1;
        while (rStart <= rEnd && cStart <= cEnd) {
            // 1. Left to Right
            for (int col = cStart; col <= cEnd; col++) {
                arr[rStart][col] = value++;
            }
            rStart++;
            // 2. Top to Bottom
            for (int row = rStart; row <= rEnd; row++) {
                arr[row][cEnd] = value++;
            }
            cEnd--;
            // 3. Right to Left
            if (rStart <= rEnd) {
                for (int col = cEnd; col >= cStart; col--) {
                    arr[rEnd][col] = value++;
                }
                rEnd--;
            }
            // 4. Bottom to Top
            if (cStart <= cEnd) {
                for (int row = rEnd; row >= rStart; row--) {
                    arr[row][cStart] = value++;
                }
                cStart++;
            }
        }
        return arr;
    }

    static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] arr = new int[rows][cols];
        int value = 1;
        int rEnd = arr.length - 1;
        int cEnd = arr[0].length - 1;
        while (rStart <= rEnd && cStart <= cEnd) {
            // 1. Left to Right
            for (int col = cStart; col <= cEnd; col++) {
                arr[rStart][col] = value++;
            }
            rStart++;
            // 2. Top to Bottom
            for (int row = rStart; row <= rEnd; row++) {
                arr[row][cEnd] = value++;
            }
            cEnd--;
            // 3. Right to Left
            if (rStart <= rEnd) {
                for (int col = cEnd; col >= cStart; col--) {
                    arr[rEnd][col] = value++;
                }
                rEnd--;
            }
            // 4. Bottom to Top
            if (cStart <= cEnd) {
                for (int row = rEnd; row >= rStart; row--) {
                    arr[row][cStart] = value++;
                }
                cStart++;
            }
        }
        return arr;
    }
}

/*
 * ============================
 * FUNCTION 1: spiralOrder1 (LC 54 - Spiral Matrix)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   4 Boundary Pointers:
 *
 *              cStart ---------> cEnd
 *                |                 |
 *   rStart -->   [ 1,  2,  3 ]    |  Step 1: Left -> Right (rStart row)
 *                [ 4,  5,  6 ]    |  Step 2: Top -> Bottom (cEnd col)
 *   rEnd --->    [ 7,  8,  9 ]    |  Step 3: Right -> Left (rEnd row)
 *                                    Step 4: Bottom -> Top (cStart col)
 *
 *   Spiral Order: [1, 2, 3, 6, 9, 8, 7, 4, 5]
 *
 *   After each step, shrink the corresponding boundary:
 *   Step 1 done -> rStart++
 *   Step 2 done -> cEnd--
 *   Step 3 done -> rEnd--    (only if rStart <= rEnd)
 *   Step 4 done -> cStart++  (only if cStart <= cEnd)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Initialize 4 boundary pointers: `rStart=0`, `rEnd=rows-1`, `cStart=0`, `cEnd=cols-1`.
 * 2. While `rStart <= rEnd && cStart <= cEnd`:
 *    - Traverse left-to-right along `rStart`, then `rStart++`.
 *    - Traverse top-to-bottom along `cEnd`, then `cEnd--`.
 *    - If `rStart <= rEnd`, traverse right-to-left along `rEnd`, then `rEnd--`.
 *    - If `cStart <= cEnd`, traverse bottom-to-top along `cStart`, then `cStart++`.
 * 3. Return the collected spiral order list.
 *
 * EDGE CASE HANDLING:
 * - `if (rStart <= rEnd)` before step 3: Prevents re-traversing a row in single-row matrices.
 * - `if (cStart <= cEnd)` before step 4: Prevents re-traversing a col in single-col matrices.
 *
 * ============================
 * FUNCTION 2: spiral2 (Fill NxN matrix sequentially)
 * ============================
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Create `n x n` matrix. Fill left-to-right, top-to-bottom with values 1, 2, 3, ...
 * 2. Return the filled matrix.
 *
 * ============================
 * FUNCTION 3: countMatches (LC 1773 - Count Items Matching a Rule)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   items = [["phone","blue","pixel"], ["computer","silver","lenovo"], ...]
 *   Each item: [type (0), color (1), name (2)]
 *   ruleKey = "color" -> cvalue = 1
 *   ruleValue = "silver" -> Check items[i].get(1) == "silver"
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Map `ruleKey` to column index: "type"->0, "color"->1, "name"->2.
 * 2. For each item, check if `items.get(i).get(cvalue)` equals `ruleValue`.
 * 3. Count and return matches.
 *
 * ============================
 * FUNCTION 4: largestAltitude (LC 1732 - Find the Highest Altitude)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   gain = [-5, 1, 5, 0, -7]
 *   Altitudes: [0, -5, -4, 1, 1, -6]
 *   Start at altitude 0, each gain[i] adds/subtracts from current altitude.
 *   Highest altitude = 1
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Compute prefix sums to convert gains into actual altitudes.
 * 2. Track and return the maximum altitude encountered.
 *
 * ============================
 * FUNCTION 5: luckyNumbers (LC 1380 - Lucky Numbers in a Matrix)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Matrix:
 *   [ 3,  7,  8 ]   rowmin = [3, 9, 15]
 *   [ 9, 11, 13 ]   colmax = [15, 16, 17]
 *   [15, 16, 17 ]
 *
 *   Lucky = minimum in its row AND maximum in its column.
 *   15 is min of row 2 (15) and max of col 0 (15) -> Lucky Number!
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Compute `rowmin[i]` = minimum value in each row.
 * 2. Compute `colmax[j]` = maximum value in each column.
 * 3. If any `rowmin[j] == colmax[i]`, add it to the result list.
 * 4. Return the list.
 *
 * ============================
 * FUNCTION 6: diagonalSum (LC 1572 - Matrix Diagonal Sum)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Matrix:
 *   [ 1,  2,  3 ]
 *   [ 4, (5), 6 ]   <- center counted once if N is odd
 *   [ 7,  8,  9 ]
 *
 *   Primary diagonal:   1 + 5 + 9 = 15  (leftCol: 0->1->2)
 *   Secondary diagonal: 3 + 5 + 7 = 15  (rightCol: 2->1->0)
 *   Overlap at center:  5 (counted once via `if (leftCol != rightCol)`)
 *   Total = 1 + 3 + 5 + 7 + 9 = 25
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Use `leftCol` (starts at 0, increments) for primary diagonal.
 * 2. Use `rightCol` (starts at n-1, decrements) for secondary diagonal.
 * 3. Add both diagonal elements per row. Skip secondary if `leftCol == rightCol`
 *    (center element in odd-sized matrix).
 * 4. Return `sum`.
 *
 * ============================
 * FUNCTION 7: transpose (LC 867 - Transpose Matrix)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Input:          Output:
 *   [1, 2, 3]      [1, 4, 7]
 *   [4, 5, 6]  ->  [2, 5, 8]
 *   [7, 8, 9]      [3, 6, 9]
 *
 *   Rule: ans[i][j] = matrix[j][i]  (swap row & col indices)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Create new matrix `ans` with dimensions `[cols][rows]` (swapped).
 * 2. For each `(i, j)`, assign `ans[i][j] = matrix[j][i]`.
 * 3. Return transposed matrix.
 *
 * ============================
 * FUNCTION 8: addToArrayForm (LC 989 - Add to Array-Form of Integer)
 * ============================
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Convert digit array to string, then parse to integer.
 * 2. Add `k` to the parsed integer.
 * 3. Extract digits from result using `sum % 10` and `sum /= 10`.
 * 4. Insert each digit at front of list (`ans.add(0, digit)`).
 * 5. Return the digit list.
 *
 * NOTE: This may overflow for very large arrays. Use BigInteger or
 * digit-by-digit addition with carry for production code.
 *
 * ============================
 * FUNCTION 9: findRotation + rotate (LC 1886 - Determine Whether Matrix Can Be
 *             Obtained By Rotation)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   90° Clockwise Rotation = Transpose + Reverse each row
 *
 *   Step 1 - Transpose:         Step 2 - Reverse rows:
 *   [0, 0, 0]    [0, 0, 1]     [0, 0, 1]    [1, 0, 0]
 *   [0, 1, 0] -> [0, 1, 1] ->  [0, 1, 1] -> [1, 1, 0]
 *   [1, 1, 1]    [0, 0, 1]     [0, 0, 1]    [1, 0, 0]
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. `findRotation`: Try up to 3 rotations (90°, 180°, 270°).
 *    After each rotation, compare with `target` using `isEqual`.
 * 2. `rotate`: Transpose matrix (`swap mat[i][j] <-> mat[j][i]`),
 *    then reverse each row using two pointers.
 * 3. `isEqual`: Element-by-element comparison of two matrices.
 *
 * ============================
 * FUNCTION 10: generateMatrix (LC 59 - Spiral Matrix II)
 * ============================
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Same 4-boundary spiral traversal as `spiralOrder1`, but instead of
 *    reading values, write incrementing values 1, 2, 3, ... into the matrix.
 * 2. Return the filled spiral matrix.
 *
 * ============================
 * FUNCTION 11: spiralMatrixIII (LC 885 - Spiral Matrix III)
 * ============================
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Uses 4-boundary spiral fill starting from custom `(rStart, cStart)`.
 * 2. Same boundary-shrinking logic as spiralOrder1 and generateMatrix.
 * 3. Return the filled matrix.
 */
