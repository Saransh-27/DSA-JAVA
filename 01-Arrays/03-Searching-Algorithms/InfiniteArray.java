package Exersise;

public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,14,15,16,17,18,19,20,21,22,23,24};
        int target = 12;
        System.out.println("The number is found at index : " + ans(arr, target));
    }
    static int ans(int[] arr, int target){
        int start = 0;
        int end = 1;
        //we dont use arr.length bcz we assume that we have a infinite array so, using arr.length is not appropriate
        while(target > arr[end]){
            int startnew =  end + 1;
            end = end +(end - start+1)*2;
            start = startnew;
        }
        return BinarySearch(arr, target, start, end);
    }
    static int BinarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start +(end -start) /2;
            if (target < arr[mid]){
                end = mid -1;
            } else if (target > arr[mid]) {
                start = mid +1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Step 1: Size = 2
 *   [ s, e ]
 *   [ 1, 2 ], 3, 4, 5, 6, 7, 8, 9, 10 ...
 *
 *   Step 2: Size doubles -> Size = 4
 *            [ s      e ]
 *     1, 2,  [ 3, 4, 5, 6 ], 7, 8, 9, 10 ...
 *
 *   Step 3: Size doubles -> Size = 8
 *                       [ s                     e ]  (target <= arr[end] -> Bounded!)
 *     1, 2,  3, 4, 5, 6, [ 7, 8, 9, 10, 11, 12, 14, 15 ] ...
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Start with a small search window/chunk of size 2 (`start = 0`, `end = 1`).
 * 2. Exponentially expand the window while `target > arr[end]`:
 *    - Save new start index: `startnew = end + 1`.
 *    - Double the current window size: `end = end + (end - start + 1) * 2`.
 *    - Update `start = startnew`.
 * 3. Once `target <= arr[end]`, perform standard Binary Search within the bounded range `[start, end]`.
 *
 * UNIQUE FORMULA & LOGIC:
 * - Exponential Box Growth (`end = end + (end - start + 1) * 2`): Doubles the chunk size `(end - start + 1)` on each step to find the target's bounding range in O(log N) steps without relying on `arr.length`.
 *
 * POINTER ADJUSTMENT RATIONALE:
 * - `startnew = end + 1`: Stores previous `end` index before calculating the new expanded `end`, ensuring the new `start` begins immediately after the old `end`.
 */


