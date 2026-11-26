class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return uniquePath(m, n, 0, 0, dp);
    }

    public int uniquePath(int m, int n, int row, int col, int[][] dp) {
        if(m-1 == row && n-1 == col){
            return 1;
        }
        if (m <= row || n <= col) {
            return 0;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int down = uniquePath(m, n, row+1, col, dp);
        int right = uniquePath(m, n, row, col+1, dp);
        down += right;
        return dp[row][col] = down;
    }
}