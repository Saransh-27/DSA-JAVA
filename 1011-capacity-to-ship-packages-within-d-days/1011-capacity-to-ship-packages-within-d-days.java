class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = max(weights);
        int high = sum(weights);
        while(low < high){
            int mid = low + (high - low)/2;
            if(isWorked(weights, mid, days)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public boolean isWorked(int[] weights, int mid, int days){
        int currentWeight =0;
        int dayUsed = 1;
        for(int i=0; i< weights.length; i++){
            if(currentWeight + weights[i] <= mid){
                currentWeight += weights[i];
            }else{
                dayUsed++;
                currentWeight = weights[i];
            }
        }
        return dayUsed <= days;
    }

    public int max(int[] weights){
        int max = Integer.MIN_VALUE;
        for(int i: weights){
            if(i > max){
                max = i;
            }
        }
        return max;
    } 

    public int sum(int[] weights){
        int sum = 0;
        for(int i: weights){
            sum += i;
        }
        return sum;
    }
}