class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        if(isPalindrome(a, 0, a.length()-1) || isPalindrome(b, 0, b.length()-1)) return true;
        else return check1(a, b) || check1(b, a);
    }

    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public boolean check1(String a, String b){
        int start =0;
        int end = b.length()-1;
        while(start < end && a.charAt(start) == b.charAt(end)) {
            start++;
            end--;
        }
        return isPalindrome(a, start, end) || isPalindrome(b, start, end);
    }
}