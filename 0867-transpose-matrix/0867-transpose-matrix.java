class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] ans = new int[matrix[0].length][matrix.length];
        int i = 0;
        while (i < ans.length) {
            for (int j = 0; j < matrix.length; j++) {
                ans[i][j] = matrix[j][i];
            }
            i++;
        }
        return ans;
    }
}