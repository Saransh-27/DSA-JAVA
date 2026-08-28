package Exersise;

public class MountainArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,4,3,2};
        int ans = peakIndexInMountainArray(arr);
        System.out.println("The peak element in the array is :"+arr[ans]+" at index :"+ans);
    }
    static int peakIndexInMountainArray(int[] arr){
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
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *               Peak (5)
 *                /  \
 *               /    \
 *             (4)    (4)
 *             /        \
 *           (3)        (3)
 *           /            \
 *   start (1)            (2) end
 *   ---------------------------------
 *   Index:   0  1  2  3  4  5  6  7
 *   Array:  [1, 2, 3, 4, 5, 4, 3, 2]
 *
 *   If arr[mid] > arr[mid+1] -> Decreasing slope -> Peak is at mid or left -> end = mid
 *   If arr[mid] < arr[mid+1] -> Ascending slope  -> Peak is to the right  -> start = mid + 1
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Initialize `start = 0` and `end = arr.length - 1`.
 * 2. Loop while `start < end`:
 *    - Compute `mid = start + (end - start) / 2`.
 *    - Compare `arr[mid]` with `arr[mid + 1]`:
 *      - If `arr[mid] > arr[mid + 1]`: We are in the decreasing part of the array. Set `end = mid` (as `mid` could be the peak).
 *      - Else (`arr[mid] < arr[mid + 1]`): We are in the ascending part of the array. Set `start = mid + 1` (as `mid + 1` is strictly larger).
 * 3. Return `start` (or `end`), as both converge to the peak element index.
 *
 * POINTER / INDEX ADJUSTMENT RATIONALE:
 * - Why `while (start < end)` instead of `start <= end`: The loop terminates when `start == end`, which points directly to the peak index.
 * - Why `end = mid` instead of `mid - 1`: `mid` might be the peak element itself, so we cannot exclude it by doing `mid - 1`.
 * - Why `start = mid + 1`: Since `arr[mid] < arr[mid + 1]`, `mid` cannot be the peak, so we safely skip `mid`.
 */


