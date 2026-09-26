class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int greedIdx = 0;
        int cookieIdx = 0;
        int counter = 0;
        while (greedIdx < g.length && cookieIdx < s.length) {
            if (s[cookieIdx] >= g[greedIdx]) {
                counter++;
                greedIdx++;
                cookieIdx++;
            } else {
                cookieIdx++;
            }
        }
        return counter;
    }
}