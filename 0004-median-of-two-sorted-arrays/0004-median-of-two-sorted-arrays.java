class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
                        .toArray();
        Arrays.sort(merged);
        int n = merged.length;
        int mid = n/2;
        if(n%2 == 1) return merged[mid];
        return ((double)merged[mid] + merged[mid-1])/2;
    }
}