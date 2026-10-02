class Solution {
    public boolean halvesAreAlike(String s) {
        int count1 = 0;
        int count2 = 0;
        int i = 0;
        int j = s.length() / 2;
        while (i < s.length() / 2 && j < s.length()) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'A') {
                count1++;
            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                count1++;
            } else if (s.charAt(i) == 'i' || s.charAt(i) == 'I') {
                count1++;
            } else if (s.charAt(i) == 'o' || s.charAt(i) == 'O') {
                count1++;
            } else if (s.charAt(i) == 'u' || s.charAt(i) == 'U') {
                count1++;
            }

            if (s.charAt(j) == 'a' || s.charAt(j) == 'A') {
                count2++;
            } else if (s.charAt(j) == 'e' || s.charAt(j) == 'E') {
                count2++;
            } else if (s.charAt(j) == 'i' || s.charAt(j) == 'I') {
                count2++;
            } else if (s.charAt(j) == 'o' || s.charAt(j) == 'O') {
                count2++;
            } else if (s.charAt(j) == 'u' || s.charAt(j) == 'U') {
                count2++;
            }
            i++;
            j++;
        }
        return count1 == count2;
    }
}