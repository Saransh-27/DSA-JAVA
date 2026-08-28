package Exersise;

public class GreaterOrEqualTo {
    public static void main(String[] args) {
       int[] arr = {2,3,5,7,9,10,12,14,16,18};
       int target = 11;
        System.out.println("The number which is >= target is : "+arr[ceiling(arr, target)]);
        System.out.println("The number which is <= target is : "+arr[flooring(arr, target)]);
    }


     static int ceiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
         while(start<=end){
            int  mid = start +(end -start )/2;
            if (target == arr[mid]){
                return mid;
            }else if (target < arr[mid]){
                end = mid -1;
            }else if (target > arr[mid]){
                start = mid +1;
            }
         }
         return start;
    }

    static int flooring(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
         while(start<=end){
            int  mid = start +(end -start )/2;
            if (target == arr[mid]){
                return mid;
            }else if (target < arr[mid]){
                end = mid -1;
            }else if (target > arr[mid]){
                start = mid +1;
            }
         }
         return end;
    }

}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *               Target = 11 (Not in array)
 *                     |
 *   Array:   [ 2, 3, 5, 7, 9,  10,   12, 14, 16, 18 ]
 *                              ^     ^
 *                             end   start
 *                              |     |
 *                        Floor(10)  Ceiling(12)
 *
 *   When loop breaks (start > end):
 *   - Flooring returns `end`   (arr[end] <= target)
 *   - Ceiling returns `start`  (arr[start] >= target)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Perform standard binary search while `start <= end`.
 * 2. If `arr[mid] == target`, target itself is both ceiling and floor (return `mid`).
 * 3. When binary search completes without finding `target` (`start > end`):
 *    - `ceiling` returns `start`.
 *    - `flooring` returns `end`.
 *
 * POINTER ADJUSTMENT RATIONALE (`end = mid - 1`, `start = mid + 1`):
 * - Excludes `mid` from search space once evaluated, preventing infinite loops.
 *
 * UNIQUE LOGIC:
 * - Why `ceiling` returns `start`: When loop ends, `start` moves one position past `end` (`start = end + 1`), pointing to the smallest element greater than `target`.
 * - Why `flooring` returns `end`: When loop ends, `end` moves one position before `start` (`end = start - 1`), pointing to the largest element smaller than `target`.
 */




