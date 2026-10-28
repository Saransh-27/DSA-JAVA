class Solution {
    public int steps = 0;
    public int numberOfSteps(int num) {
        if(num==0) return steps;
        steps++;
        if(num%2 == 0) return numberOfSteps(num/2);
        return numberOfSteps(num-1);
    }
}