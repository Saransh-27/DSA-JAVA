class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        double n = x;
        while (true) {
            double root = 0.5 * (n + (x / n));
            if (Math.abs(root - n) < 0.000001) {
                break;
            }
            n = root;
        }

        return (int)n;
    }
}