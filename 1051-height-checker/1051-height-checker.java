class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        int counter = 0;
        Arrays.sort(expected);
        for (int i = 0; i < expected.length; i++) {
            if (heights[i] != expected[i]) {
                counter++;
            }
        }
        return counter;
    }
}