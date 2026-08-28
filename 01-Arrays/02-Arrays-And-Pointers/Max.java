package Exersise;

import java.util.Scanner;

public class Max {
    public static void main(String[] args) {
//        int[] arr = {14, 67, 87, 100, 154};
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.print("Enter 5 numbers to find the maximum number : ");
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("The max of the numbers is : " + maxnum(arr));
    }

     static int maxnum(int[] arr) {
        int max1 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
           if (arr[i] > max1){
               max1 = arr[i];
           }
        }
        return max1;
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Array: [ 14,  67,  87,  100,  154 ]
 *   max1 = Integer.MIN_VALUE (-2^31)
 *
 *   i=0: 14 > -2^31  -> max1 = 14
 *   i=1: 67 > 14     -> max1 = 67
 *   i=2: 87 > 67     -> max1 = 87
 *   i=3: 100 > 87    -> max1 = 100
 *   i=4: 154 > 100   -> max1 = 154  (Final Max)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Read input numbers from user and populate array `arr`.
 * 2. Initialize `max1 = Integer.MIN_VALUE` (lowest possible 32-bit integer).
 * 3. Iterate through each element in `arr`:
 *    - If `arr[i] > max1`, update `max1 = arr[i]`.
 * 4. Return `max1`.
 *
 * EDGE CASE HANDLING:
 * - `Integer.MIN_VALUE` initialization: Ensures the function correctly handles arrays containing all negative numbers (e.g. `[-50, -10, -2]`).
 */



