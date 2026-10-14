class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int start = 0;
        int end = removable.length;
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            Boolean[] mark = new Boolean[s.length()];
            Arrays.fill(mark, false);
            for (int i = 0; i < mid; i++) {
                mark[removable[i]] = true;
            }
            if (checkMark(s, p, mark)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public boolean checkMark(String s, String p, Boolean[] mark) {
        int start = 0;
        int pIdx = 0;
        while (start < s.length() && pIdx < p.length()) {
            if (!mark[start] && s.charAt(start) == p.charAt(pIdx)) {
                pIdx++;
            }
            start++;
        }
        return pIdx == p.length();
    }
}