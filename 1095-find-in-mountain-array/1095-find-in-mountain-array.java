/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakElement = peakIndexInMountainArray(mountainArr); 
        int firstTry = BinarySearch(mountainArr, target, 0, peakElement, false);
        if(firstTry!=-1){
            return firstTry;  
        }
        return BinarySearch(mountainArr, target, peakElement+1, mountainArr.length()-1, true);  
    }

    public int peakIndexInMountainArray(MountainArray arr){
        int start = 0;
        int end = arr.length()-1;
        while(start < end){
            int mid = start + (end-start)/2;
            if (arr.get(mid) > arr.get(mid+1)){
                end = mid;
            }else{
                start = mid +1;
            }
        }
        return start;
    }

    public int BinarySearch(MountainArray arr, int target, int start, int end, boolean isDesc) {
            if (isDesc) {
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (target < arr.get(mid)) {
                        start = mid + 1;
                    } else if (target > arr.get(mid)) {
                        end = mid - 1;
                    } else {
                        return mid;
                    }
                }
            } else {
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (target < arr.get(mid)) {
                        end = mid - 1;
                    } else if (target > arr.get(mid)) {
                        start = mid + 1;
                    } else {
                        return mid;
                    }
                }
            }
            return -1;
        }
}