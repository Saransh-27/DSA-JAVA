class Solution {
    public String mergeAlternately(String word1, String word2) {
        int index1 = 0;
        int index2 = 0;
        StringBuilder result = new StringBuilder();
        while (index1 < word1.length() || index2 < word2.length()) {
            if (index1 < word1.length()) {
                result.append(word1.charAt(index1));
                index1++;
            }
            if (index2 < word2.length()) {
                result.append(word2.charAt(index2));
                index2++;
            }
        }
        return result.toString();
    }
}