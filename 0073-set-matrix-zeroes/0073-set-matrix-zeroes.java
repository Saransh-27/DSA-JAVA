class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Boolean[] rowZero = new Boolean[m];
        Arrays.fill(rowZero, false);
        Boolean[] colZero = new Boolean[n];
        Arrays.fill(colZero, false);

        for(int row =0; row < m; row++){
            for(int col =0; col< n; col++){
                if(matrix[row][col] == 0){
                    rowZero[row] = true;
                    colZero[col] = true;
                }
            }
        }

        for(int i =0; i< m; i++){
            for(int j = 0; j < n; j++){
                if(rowZero[i] || colZero[j]){
                    matrix[i][j] = 0;
                }
            }
        }
      
    }
}