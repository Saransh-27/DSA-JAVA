class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] sen1 = sentence1.split(" ");
        String[] sen2 = sentence2.split(" ");
        if (sen1.length < sen2.length) {
            String[] temp = sen1;
            sen1 = sen2;
            sen2 = temp;
        }
        int left = 0;
        int s1End = sen1.length - 1;
        int s2End = sen2.length - 1;
        while (left <= s2End && sen1[left].equals(sen2[left])) {
            left++;
        }

        while (left <= s2End && sen1[s1End].equals(sen2[s2End])) {
            s1End--;
            s2End--;
        }
        return left > s2End;
    }
}