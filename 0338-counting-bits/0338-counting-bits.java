class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        while(n >= 0){
            int count = 0;
            int current = n;
            while (current > 0) {
                count++;
                current = current & (current - 1);
            }
            ans[n] = count;
            n--;
        }
        return ans;
    }
}