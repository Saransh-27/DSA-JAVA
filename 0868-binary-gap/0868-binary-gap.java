class Solution {
    public int binaryGap(int n) {
        boolean found = false;
        int maxDist = 0;
        int currDist = 0;
        while(n > 0){
            int curr = n&1;
            if(curr == 1){ 
                if(found){
                    maxDist = Math.max(maxDist, currDist);
                }
                currDist = 1;
                found = true;
            }else{
                if(found) currDist++;
            }
            n >>= 1;
        }
        return maxDist;
    }
}