class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int cStart = 0;
        int cEnd = mat[0].length - 1;
        while (cStart <= cEnd) {
            int midCol = cStart + (cEnd - cStart) / 2;
            int[] peak2 = findPeak(mat, midCol);
            if (midCol < cEnd && mat[peak2[0]][peak2[1]] < mat[peak2[0]][peak2[1] + 1]) {
                cStart = midCol + 1;
            } else if (midCol > 0 && mat[peak2[0]][peak2[1]] < mat[peak2[0]][peak2[1] - 1]) {
                cEnd = midCol - 1;
            } else {
                return peak2;
            }
        }
        return new int[] { -1, -1 };
    }

    public int[] findPeak(int[][] mat, int col) {
        int maxRow = 0;
        for (int row = 1; row < mat.length; row++) {
            if (mat[row][col] > mat[maxRow][col]) {
                maxRow = row;
            }
        }
        return new int[]{maxRow, col};
    }
}