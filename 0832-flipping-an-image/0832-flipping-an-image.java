class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            int start = 0;
            int end = row.length - 1;
            while (start <= end) {
                int temp = row[start];
                row[start] = row[end] ^ 1;
                row[end] = temp ^ 1;
                start++;
                end--;
            }
        }
        return image;
    }

}