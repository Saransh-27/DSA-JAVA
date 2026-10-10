class Solution {
    public List<String> printVertically(String s) {
        String[] str = s.split(" ");
        int cols = maxLe(str);
        String[] ans = new String[cols];
        Arrays.fill(ans, "");
        int start = 0;
        int idx = 0;
        while (start < cols) {
            for (String el : str) {
                if (start < el.length()) {
                    ans[idx] += String.valueOf(el.charAt(start));
                } else {
                    ans[idx] += " ";
                }
            }
            ans[idx] = ans[idx].stripTrailing();
            start++;
            idx++;
        }
        return Arrays.asList(ans);
    }

    public int maxLe(String[] strs){
        int maxLen = Integer.MIN_VALUE;
        for(String s : strs){
            if(s.length() > maxLen){
                maxLen = s.length();
            }
        }
        return maxLen;
    }
}