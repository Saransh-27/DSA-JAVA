class Solution {
    public boolean judgeCircle(String moves) {
        int[] move = new int[2];
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') {
                move[0]++;
            } else if (moves.charAt(i) == 'D') {
                move[0]--;
            } else if (moves.charAt(i) == 'R') {
                move[1]++;
            } else {
                move[1]--;
            }
        }
        return move[0] == 0 && move[1] == 0;
    }
}