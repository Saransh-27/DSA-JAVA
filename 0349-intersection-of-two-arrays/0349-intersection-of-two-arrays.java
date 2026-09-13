class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length >= nums2.length){
            return find(nums1, nums2);
        }else{
            return find(nums2, nums1);
        }
    }

    public int[] find(int[] arr, int[] target){

        HashSet<Integer> result = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i: target){
            set.add(i);
        }
        
        for(int i: arr){
            if(set.contains(i)){
                result.add(i);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}