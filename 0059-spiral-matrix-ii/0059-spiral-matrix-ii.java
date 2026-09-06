class Solution {
    public int[][] generateMatrix(int n) {
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
}