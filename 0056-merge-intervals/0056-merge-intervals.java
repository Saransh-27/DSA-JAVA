class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> matrix = new ArrayList<>();
        int row = 0;
        while (row < intervals.length) {
            int start = intervals[row][0];
            int end = intervals[row][1];
            while (row + 1 < intervals.length && intervals[row + 1][0] <= end) {
                end = Math.max(end, intervals[row + 1][1]);
                row++;
            }
            matrix.add(Arrays.asList(start, end));
            row++;
        }
        int[][] ans = new int[matrix.size()][2];
        for (int i = 0; i < matrix.size(); i++) {
            ans[i][0] = matrix.get(i).get(0);
            ans[i][1] = matrix.get(i).get(1);
        }
        return ans;
    }
}