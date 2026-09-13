class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length >= nums2.length){
            return find(nums1, nums2);
        }else{
            return find(nums2, nums1);
        }
    }

    public int[] find(int[] arr, int[] target){
        HashSet<Integer> set = new HashSet<>();
        int index = 0;
        while(index < target.length){
        for(int i=0; i < arr.length; i++){
            if(target[index] == arr[i]){
                set.add(target[index]);
            }
        }
        index++;
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}