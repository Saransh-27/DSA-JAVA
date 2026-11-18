class Solution {
    public int reverseBits(int n) {
        StringBuilder binary = new StringBuilder();
        for(int i = 0; i < 32; i++){
            int mask = 1 << i;
            int res = (n & mask) == 0 ? 0 : 1;
            binary.append(res);
        }
        long temp = Long.parseLong(binary.toString(), 2);
        return (int)temp;
    }
}