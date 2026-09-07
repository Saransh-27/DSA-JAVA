class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] ans = new int[r][c];
        int current =0;
        if(r*c != mat.length*mat[0].length) return mat;
        for(int i =0; i< mat.length; i++){
            for(int j =0; j < mat[i].length; j++){
                ans[current/c][current%c] = mat[i][j];
                current++;
            }
        }
        return ans;
    }
}