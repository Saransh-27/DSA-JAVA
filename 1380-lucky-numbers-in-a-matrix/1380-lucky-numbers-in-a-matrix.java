class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
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
        for (int min : rowmin) {
            for (int max : colmax) {
                if (min == max) {
                    result.add(min);
                }
            }
        }
        return result;
    }
}