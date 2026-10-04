class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder result = new StringBuilder();
        int isEqual = 0;
        while (isEqual < word.length()) {
            if (word.charAt(isEqual) == ch) {
                result.append(add(word.substring(0, isEqual + 1)));
                int next = isEqual + 1;
                while (next < word.length()) {
                    result.append(word.charAt(next));
                    next++;
                }
                return result.toString();
            }
            isEqual++;
        }
        return word;
    }

    public String add(String word) {
        StringBuilder result = new StringBuilder();
        int end = word.length() - 1;
        while (end >= 0) {
            result.append(word.charAt(end));
            end--;
        }
        return result.toString();
    }
}