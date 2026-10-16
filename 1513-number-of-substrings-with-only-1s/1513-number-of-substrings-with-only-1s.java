class Solution {
    public int numSub(String s) {
        int count = 0;
        int consecutive = 0;
        int mod = 1000000007;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                consecutive++;
            } else {
                consecutive = 0;
            }
            count = (count + consecutive) % mod;
        }
        return count;
    }
}