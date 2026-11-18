class Solution {
    public int findComplement(int num) {
        int n = num;
        int bits = 0;
        while (n > 0) {
            bits++;
            n = n >> 1;
        }
        int mask = (1 << bits) - 1;
        return num^mask;
    }
}