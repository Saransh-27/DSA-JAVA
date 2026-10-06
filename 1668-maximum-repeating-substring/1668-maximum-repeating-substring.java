class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder words = new StringBuilder(word);
        while (sequence.contains(words.toString())) {
            count++;
            words.append(word);
        }
        return count;
    }
}