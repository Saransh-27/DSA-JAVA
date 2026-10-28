class Solution {
    public int rev = 0;
    public boolean isPalindrome(int x) {
        rev(x);
       return rev==x;
    }

    public void rev(int num){
        if(num <= 0) return ;
        rev = Math.abs((rev*10)+num%10);
        rev(num/10);
    }
}