class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(m < nums1.length){
            nums1[m] = nums2[m%n];
            for(int i=m; i>0; i--){
                if(nums1[i] < nums1[i-1]){
                    int temp = nums1[i];
                    nums1[i] = nums1[i-1];
                    nums1[i-1] = temp;
                }
            }
            m++;
        }
    }
}