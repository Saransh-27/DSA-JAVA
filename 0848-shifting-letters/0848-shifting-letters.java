class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int idx = 0;
        StringBuilder ans = new StringBuilder(s.length());
        int shiftLen = 0;
        for (int shift : shifts) {
            shiftLen = (shiftLen + shift % 26) % 26;
        }
        while (idx < s.length()) {
            if (idx > 0)
                shiftLen = (shiftLen - shifts[idx - 1] % 26 + 26) % 26;
            ans.append(shift(s.charAt(idx), shiftLen));
            idx++;
        }
        return ans.toString();
    }

    public char shift(char ch, int shiftLen) {
        shiftLen %= 26;
        return (char) ((ch - 'a' + shiftLen) % 26 + 'a');
    }
}