class Solution {
    public String interpret(String command) {
        StringBuilder str = new StringBuilder();
        int index = 0;
        while (index < command.length()) {
            if (command.charAt(index) == 'G') {
                str.append('G');
                index++;
            } else if (command.charAt(index) == '(' && command.charAt(index + 1) == ')') {
                str.append('o');
                index += 2;
            } else if (command.charAt(index) == '(' && command.charAt(index + 1) == 'a') {
                str.append("al");
                index += 4;
            }
        }
        return str.toString();
    }
}