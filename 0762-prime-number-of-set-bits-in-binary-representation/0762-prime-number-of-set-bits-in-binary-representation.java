class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i = left; i <= right; i++){
            if(bits(i)) count++;
        }
        return count;
    }

    public boolean bits(int n){
        int bits = 0;
        while(n > 0){
            bits++;
            n &= n-1;
        }
        return isPrime(bits);
    }

    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++){
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}