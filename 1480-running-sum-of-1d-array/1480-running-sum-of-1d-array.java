class Solution {
    public int[] runningSum(int[] arr) {
        int sum = 0;
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            ans[i] = sum;
        }
        return ans;
	}

}
