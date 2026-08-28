package Exersise;

import java.util.Arrays;
import java.util.Scanner;

public class Multiarray {
    public static void main(String[] args) {
        int[][] arr= new int[3][3];
        Scanner sc=new Scanner(System.in);
        for (int row=0;row<arr.length;row++){    //arr.ength give the numbers of rows and each row is itself is an independent arr
            for (int col=0;col<arr[row].length;col++){  //arr[row] -> arr[1] is an indepedent itself and arr[row ].lenght give the number of columns or the number of elements  in that row
                System.out.println("Enter the value for row "+row+" and column "+col);
                arr[row][col] = sc.nextInt();
            }
        }

        for (int[] ints : arr) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
            System.out.println(Arrays.toString(ints)); //Arrays.toString() give the arr in the correct format [1,2,3]
        }
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   2D Matrix Input/Output (3x3):
 *
 *           col 0    col 1    col 2
 *   row 0 [ arr[0][0], arr[0][1], arr[0][2] ]  --> Printed via Arrays.toString(ints)
 *   row 1 [ arr[1][0], arr[1][1], arr[1][2] ]  --> Printed via Arrays.toString(ints)
 *   row 2 [ arr[2][0], arr[2][1], arr[2][2] ]  --> Printed via Arrays.toString(ints)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Initialize a 3x3 2D array `int[][] arr = new int[3][3]`.
 * 2. Outer loop `row` runs from 0 to `arr.length - 1` (number of rows).
 * 3. Inner loop `col` runs from 0 to `arr[row].length - 1` (number of columns in row).
 * 4. Read integers using `sc.nextInt()` and assign to `arr[row][col]`.
 * 5. Iterate through each row (`ints`) using an enhanced for-each loop and print using `Arrays.toString(ints)`.
 *
 * UNIQUE FORMULA & LOGIC:
 * - `arr.length`: Gives total number of rows.
 * - `arr[row].length`: Gives number of columns in row `row` (allowing jagged/ragged arrays).
 * - `Arrays.toString(ints)`: Formats 1D array row into a human-readable string like `[1, 2, 3]`.
 */


