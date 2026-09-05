class Solution {
    public int findNumbers(int[] nums) {
        int counter = 0;
        for (int j : nums) {
            int digit=0;
            while(j > 0){
                j = j/10;
                digit++;
            }
            if (digit % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }

}