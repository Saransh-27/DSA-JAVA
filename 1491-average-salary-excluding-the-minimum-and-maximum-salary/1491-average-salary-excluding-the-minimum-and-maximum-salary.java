class Solution {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double sum =0; 
        for(int num: salary){
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
            sum += num;
        }
        sum -= (min+max);
        return sum / (salary.length - 2);
    }
}