class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = max(piles);
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (ceil(piles, mid, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int max(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int i : piles) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public boolean ceil(int[] piles, int mid, int h) {
        int sum = 0;
        for (int i : piles) {
             sum += (i + mid - 1) / mid;
        }
        return sum <= h;
    }
}