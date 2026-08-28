package Exersise;

import java.util.Arrays;

public class Minimum {
    public static void main(String[] args) {
        int[] arr = {12,13,-14,51,-4};
        System.out.println("The minimum number is : " + findMin(arr));

        }



    static int findMin(int[] arr){
        if (arr.length == 0){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Array: [ 12,  13,  -14,  51,  -4 ]
 *   min = Integer.MAX_VALUE (2^31 - 1)
 *
 *   j=12:  12 < 2^31-1  -> min = 12
 *   j=13:  13 < 12      -> min = 12
 *   j=-14: -14 < 12     -> min = -14 (Updated!)
 *   j=51:  51 < -14     -> min = -14
 *   j=-4:  -4 < -14     -> min = -14 (Final Min: -14)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Check if array is empty (`arr.length == 0`); return `-1`.
 * 2. Initialize `min = Integer.MAX_VALUE`.
 * 3. Iterate through each element `j` in `arr`:
 *    - If `j < min`, update `min = j`.
 * 4. Return `min`.
 *
 * EDGE CASE HANDLING:
 * - `arr.length == 0`: Handles empty arrays safely by returning `-1`.
 * - `Integer.MAX_VALUE`: Ensures any valid integer in the array will properly overwrite `min`.
 */


