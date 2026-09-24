class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] ans = new int[rows * cols][2];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[index] = new int[] { i, j };
                index++;
            }
        }
        Arrays.sort(ans, (a, b) -> {
            int distanceA = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int distanceB = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);

            return distanceA - distanceB;
        });
        return ans;
    }
}