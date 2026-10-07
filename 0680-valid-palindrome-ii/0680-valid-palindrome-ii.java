class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return palindrome(s, start) || palindrome(s, end);
            }
        }
        return true;
    }

    public boolean palindrome(String s, int p1) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if(start == p1){
                start++;
            }else if(end == p1){
                end--;
            }
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}