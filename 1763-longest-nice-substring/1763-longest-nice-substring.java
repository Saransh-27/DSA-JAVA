class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2)
            return "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            boolean isNice = s.indexOf(Character.toLowerCase(ch)) != -1 && s.indexOf(Character.toUpperCase(ch)) != -1;
            if (!isNice) {
                String leftAns = longestNiceSubstring(s.substring(0, i));
                String rightAns = longestNiceSubstring(s.substring(i + 1, s.length()));
                return leftAns.length() >= rightAns.length() ? leftAns : rightAns;
            }
        }
        return s;
    }
}