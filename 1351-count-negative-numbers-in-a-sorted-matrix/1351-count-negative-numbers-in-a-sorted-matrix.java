class Solution {
    public int countNegatives(int[][] grid) {
        int counter = 0;
        int i = 0;
        int j = grid[0].length - 1;
        while (i < grid.length) {
            if (grid[i][j] < 0) {
                int end = search(grid, i, 0, j)[1];
                counter += (grid[i].length - end);
            }
            i++;
        }
        return counter;
    }

    public int[] search(int[][] matrix, int row, int cStart, int cEnd) {
        while (cStart <= cEnd) {
            int mid = Math.abs(cStart + (cEnd - cStart) / 2);
            if (matrix[row][mid] < 0) {
                cEnd = mid - 1;
            } else {
                cStart = mid + 1;
            }
        }
        return new int[] { row, cStart };
    }
}