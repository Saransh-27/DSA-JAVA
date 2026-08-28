package Exersise;

import java.util.Scanner;
public class arm{
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the number to check if it is an armstrong number or not");
        int num = sc.nextInt();
        // int original = num;
        // int sum = 0;
        // while(num > 0){
        //     int rem = num % 10;
        //     sum += rem * rem * rem;
        //     num /= 10;
        // }
        if(isArmstrong(num)){
            System.out.println("The number is an armstrong number");
        }else{
            System.out.println("The number is not an armstrong number");
        }
    }


    public static boolean isArmstrong(int num){
        int original = num;
        int sum = 0;
        while(num > 0){
            int rem = num % 10;
            sum += rem * rem * rem;
            num /= 10;
        }
        return sum == original;
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Input num = 153, original = 153, sum = 0
 *
 *   Iteration 1: rem = 153 % 10 = 3  -> sum += 3^3 = 27   -> num = 15
 *   Iteration 2: rem = 15 % 10  = 5  -> sum += 5^3 = 125  -> num = 1
 *   Iteration 3: rem = 1 % 10   = 1  -> sum += 1^3 = 1    -> num = 0
 *
 *   Total sum = 27 + 125 + 1 = 153
 *   sum == original (153 == 153) -> TRUE (Armstrong Number!)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Save `original = num` because `num` will be reduced to 0 during digit processing.
 * 2. Initialize `sum = 0`.
 * 3. While `num > 0`:
 *    - Extract rightmost digit: `rem = num % 10`.
 *    - Cube the digit and add to sum: `sum += rem * rem * rem`.
 *    - Drop rightmost digit: `num /= 10`.
 * 4. Return `sum == original`.
 *
 * UNIQUE FORMULA & LOGIC:
 * - `rem * rem * rem`: Calculates the cube of each extracted digit.
 *
 * EDGE CASE HANDLING:
 * - `original = num` variable copy prevents checking against 0 after the while loop finishes.
 */
