class Solution {
    public int diagonalSum(int[][] mat) {
        int i1 = 0;
        int j1 = 0;
        int j2 = mat.length - 1;
        int sum = 0;
        while (i1 < mat.length) {
            sum += mat[i1][j1];
            if (j1 != j2) {
                sum += mat[i1][j2];
            }
            i1++;
            j1++;
            j2--;
        }
        return sum;
    }
}