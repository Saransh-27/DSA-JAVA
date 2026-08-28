package Exersise;

import java.util.Arrays;

public class EvenOrNot {
    public static void main(String[] args) {
        int[] arr = {1234, 34, 54, 12342, 1};
        System.out.println("The array have : " +haveEvenNo(arr)+" elements with even number of digits.");
        System.out.println("The array have : " +haveEvenNo2(arr)+" elements with even number of digits (work's with Strings).");
    }


//    Function work's with int and numbers
    static int haveEvenNo(int[] arr){
        if (arr.length == 0){
            return -1;
        }
        int haveEven = 0;
        for (int i : arr){
            int ans = count(i);
            if (ans % 2 == 0) {
                haveEven++;
            }
        }
        return haveEven;
    }
    static int count(int n){
        int count = 0;
        while (n>0){
            count++;
            n = n/10;
        }
        return count;
    }


//function work's with the arrays and string
    static int haveEvenNo2(int[] arr){
        if (arr.length == 0){
            return -1;
        }
        int haveEven = 0;
        for (int j : arr) {
            int ans = String.valueOf(j).length();
            if (ans % 2 == 0) {
                haveEven++;
            }
        }
        return haveEven;
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Array: [ 1234,   34,   54,   12342,   1 ]
 *
 *   Method 1 (Math Division):
 *   1234 -> 1234/10 -> 123 -> 12 -> 1 -> 0  (Count = 4 -> Even) -> Increment count!
 *   34   -> 34/10 -> 3 -> 0                (Count = 2 -> Even) -> Increment count!
 *   12342-> ...                            (Count = 5 -> Odd)  -> Skip
 *
 *   Method 2 (String conversion):
 *   String.valueOf(1234).length() = 4 -> Even!
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Empty check (`arr.length == 0`): return `-1`.
 * 2. Method 1 (`haveEvenNo`):
 *    - For each integer in `arr`, call `count(n)` which divides `n` by 10 continuously until `n == 0` to count digits.
 *    - If `ans % 2 == 0`, increment `haveEven`.
 * 3. Method 2 (`haveEvenNo2`):
 *    - Convert each integer to String using `String.valueOf(j)`.
 *    - Check if string length `% 2 == 0`.
 * 4. Return total count of numbers having even digit lengths.
 *
 * UNIQUE FORMULA & LOGIC:
 * - `n = n / 10`: Removes rightmost digit in base-10 integer representation.
 * - `ans % 2 == 0`: Modulo 2 check determines if digit count is even.
 *
 * EDGE CASE HANDLING:
 * - Empty array check (`arr.length == 0`): Returns `-1`.
 */


