class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < word.length()) {
            if (word.charAt(index) == ch) {
                result.append(reverseString(word.substring(0, index + 1)));
                int next = index + 1;
                while (next < word.length()) {
                    result.append(word.charAt(next));
                    next++;
                }
                return result.toString();
            }
            index++;
        }
        return word;
    }

    public String reverseString(String word) {
        StringBuilder result = new StringBuilder();
        int end = word.length() - 1;
        while (end >= 0) {
            result.append(word.charAt(end));
            end--;
        }
        return result.toString();
    }
}