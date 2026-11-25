class Solution {
    public boolean isPowerOfFour(int n) {
        int start = 0;
        int end = 15;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long num = 1L << (2 * mid);
            if (num == n) {
                return true;
            }

            if (num > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}