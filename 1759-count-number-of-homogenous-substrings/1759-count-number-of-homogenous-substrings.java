class Solution {
    public int countHomogenous(String s) {
        int count =0;
        int consecutive = 0;
        char prev = ' ';
        int mod = 1000000007;
        for(int i =0; i< s.length(); i++){
            char curr = s.charAt(i);
            if(curr == prev){
                consecutive++;
            }else{
                consecutive =1;
                prev = curr;
            }
            count = (count+consecutive)%mod;
        }
        return count;
    }
}