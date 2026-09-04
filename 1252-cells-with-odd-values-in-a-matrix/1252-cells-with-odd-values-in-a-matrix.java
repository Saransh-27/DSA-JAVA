class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] arr = new int[m][n];
        for(int i =0; i< indices.length; i++){
            for(int j =0; j < indices[i].length -1; j++){
                int row = indices[i][j];
                int col = indices[i][j+1];
                for(int k = 0; k < n; k++){
                    arr[row][k]++;
                }
                for(int k = 0; k < m; k++){
                    arr[k][col]++;
                }
            }
        }
        int counter =0;
        for(int[] i : arr){
            for(int j : i) {
                if (j % 2 != 0) {
                    counter++;
                }
            }
        }
        return counter;
    }

}