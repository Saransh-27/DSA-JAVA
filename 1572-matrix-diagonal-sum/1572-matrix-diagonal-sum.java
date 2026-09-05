class Solution {
    public int diagonalSum(int[][] mat) {
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
}