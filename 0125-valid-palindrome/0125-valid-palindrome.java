class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                ans.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        int start = 0;
        int end = ans.length() - 1;
        while (start < end) {
            if (ans.charAt(start) == ans.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}