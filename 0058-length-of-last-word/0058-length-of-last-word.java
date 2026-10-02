class Solution {
    public int lengthOfLastWord(String s) {
        String stripped = s.strip();
        int idx = stripped.length() - 1;
        int count = 0;
        while (idx >= 0) {
            if (stripped.charAt(idx) != ' ') {
                count++;
            } else {
                break;
            }
            idx--;
        }
        return count;
    }
}