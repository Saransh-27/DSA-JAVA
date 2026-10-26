class Solution {
    public char findTheDifference(String s, String t) {
        char unique = 0;
        for(char c : s.toCharArray()){
            unique ^= c;
        }
        for(char c : t.toCharArray()){
            unique ^= c;
        }
        return unique;
    }
}