package Exersise;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,4,6,8,10,13,15,17,18,19,21,23,25,27};
//        int[] arr = {27,25,23,21,19,18,17,15,13,10,8,6,4,1};
        int target = 13;
//        System.out.println(arr.length);
        System.out.println("The target element : "+target+" is found at index : " +binarySearch(arr, target));
    }

    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length -1;
//        System.out.println(end);
        if (arr[start] < arr[end]) {
            System.out.println("This is an ascending order array.");

//            this is an ascending order array
            while(start <= end){
                int mid = start +(end -start) /2;
//                System.out.println("mid is " +arr[mid]);
                if (target < arr[mid]){
                    end = mid -1;
                } else if (target > arr[mid]) {
                    start = mid +1;
                }else{
                    return mid;
                }
            }
            return -1;
        }else{
            System.out.println("This is a descending order array.");
//            this means that is a descending order array
            while(start <= end){
                int mid = start +(end -start) /2;
                if (target > arr[mid]){
                    end = mid -1;
                } else if (target < arr[mid]) {
                    start = mid +1;
                }else{
                    return mid;
                }
            }
            return -1;
        }
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   start                                 mid                                   end
 *     |                                    |                                     |
 *   [ 1,   4,   6,   8,   10,   13,   15,   17,   18,   19,   21,   23,   25,   27 ]
 *                                      ^
 *                                target (13) < arr[mid] (17) -> end = mid - 1
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. The binarySearch function performs search on a sorted array by maintaining start and end pointers.
 * 2. It first determines if the array is sorted in ascending or descending order by comparing arr[start] and arr[end].
 * 3. In a loop while start <= end, it computes the middle index mid = start + (end - start) / 2.
 * 4. If target equals arr[mid], the index mid is returned.
 * 5. Depending on the sorting order (ascending or descending), it adjusts either start = mid + 1 or end = mid - 1 to eliminate half of the remaining array.
 * 6. If start exceeds end and target is not found, it returns -1.
 *
 * WHY `mid = start + (end - start) / 2` INSTEAD OF `mid = (start + end) / 2`:
 * - If start and end are large numbers (close to Integer.MAX_VALUE), (start + end) can overflow integer limits and turn negative.
 * - `start + (end - start) / 2` is mathematically equivalent to `(start + end) / 2`, but avoids calculating (start + end) directly, safely preventing integer overflow.
 *
 * WHY WE ADD/SUBTRACT 1 (`start = mid + 1`, `end = mid - 1`):
 * - Since we already checked arr[mid] and confirmed it is NOT the target, mid is eliminated from the search space.
 * - Adding or subtracting 1 excludes the mid index from further checks and prevents infinite loops when start and end converge.
 */



