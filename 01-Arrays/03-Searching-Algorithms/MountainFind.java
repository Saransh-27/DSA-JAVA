package Exersise;

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

public class MountainFind {
    public static void main(String[] args) {
        int[] mountainArr = {1,5,3,2,1};
        int target = 2;
        MountainFind finder = new MountainFind();
        int index = finder.findInMountainArray(target, mountainArr);
        System.out.println("Index of target " + target + " is: " + index);
    }

    public int findInMountainArray(int target, int[] mountainArr) {
        int peakElement = peakIndexInMountainArray(mountainArr);
//        if(mountainArr[peakElement] > target){
//            return BinarySearch(mountainArr, target, 0, peakElement);
//        }
//        return BinarySearch(mountainArr, target, peakElement+1, mountainArr.length-1);
         int firstTry = BinarySearch(mountainArr, target, 0, peakElement, false);
         if(firstTry!=-1){
             return firstTry;
         }
         return BinarySearch(mountainArr, target, peakElement, mountainArr.length-1, true);
    }

    public int peakIndexInMountainArray(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int mid = start + (end-start)/2;
            if (arr[mid] > arr[mid+1]){
                end = mid;
            }else{
                start = mid +1;
            }
        }
        return start;
    }

        public int BinarySearch(int[] arr, int target, int start, int end, boolean isDesc) {
            if (isDesc) {
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (target < arr[mid]) {
                        start = mid + 1;
                    } else if (target > arr[mid]) {
                        end = mid - 1;
                    } else {
                        return mid;
                    }
                }
            } else {
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (target < arr[mid]) {
                        end = mid - 1;
                    } else if (target > arr[mid]) {
                        start = mid + 1;
                    } else {
                        return mid;
                    }
                }
            }
            return -1;
        }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *                     [PEAK]
 *                      /  \
 *   Ascending Phase   /    \   Descending Phase
 *   (Search 1st)     /      \  (Search 2nd if 1st fails)
 *                   /        \
 *           [0 ... peak]     [peak+1 ... N-1]
 *
 *   1st Search Range:  [0 -------------> peak]  (Ascending Order BS)
 *   2nd Search Range:  [peak + 1 --------> end]   (Descending Order BS)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Find the peak element index of the mountain array using `peakIndexInMountainArray`.
 * 2. Search for the target in the ascending left half (from index `0` to `peakElement`) using binary search.
 * 3. If target is found in the left half (`firstTry != -1`), return `firstTry` (ensuring the minimum index requirement).
 * 4. Otherwise, search for the target in the right half (from index `peakElement` to `mountainArr.length - 1`).
 *
 * UNIQUE FORMULA & LOGIC:
 * - Two-phase Binary Search: Splitting search around `peakElement` allows binary searching on sorted halves.
 *
 * EDGE CASE HANDLING:
 * - Checking left half first: If target exists on both sides of the mountain, searching left first guarantees returning the minimum index as required.
 */


