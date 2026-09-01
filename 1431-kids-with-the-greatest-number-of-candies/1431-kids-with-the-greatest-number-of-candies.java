class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            if(candy > max) {
                max = candy;
            }
        }
        for(int candy : candies){
            int sum = candy + extraCandies;
            if (sum >= max) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}