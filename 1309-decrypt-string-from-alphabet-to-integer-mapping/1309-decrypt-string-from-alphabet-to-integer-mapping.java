class Solution {
    public String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();
        int index = s.length() - 1;
        while (index >= 0) {
            StringBuilder temp = new StringBuilder(2);
            if (s.charAt(index) == '#') {
                temp.append(s.charAt(index - 2));
                temp.append(s.charAt(index - 1));
                result.append(check(temp));
                index -= 3;
            } else {
                temp.append(s.charAt(index));
                result.append(check(temp));
                index--;
            }
        }
        return result.reverse().toString();
    }

    public char check(StringBuilder s) {
        int number = Integer.parseInt(s.toString());
        return (char) ('a' + number - 1);
    }
}