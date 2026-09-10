public class Patterns {
    public static void main(String[] args) {
        pattern1(5);
        pattern2(5);
        pattern3(5);
        pattern4(5);
        pattern5(5);
        pattern6(5);
        pattern7(5);
        pattern8(5);
        pattern9(5);
        pattern10(5);
        pattern11(5);
        pattern12(5);
        pattern13(5);
        pattern14(5);
        pattern15(5);
        pattern16(5);
        pattern17(4);
        pattern18(5);
        pattern19(5);
        pattern20(5);
        pattern21(5);
        pattern22(5);
    }

    static void pattern1(int n){
        System.out.println("pattern 1 : ");
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= n; col++){
                System.out.print("*");
            }
            System.out.println();
        }
        /*
             *****
             *****
             *****
             *****
             *****
         */
    }

    static void pattern2(int n){
        System.out.println("pattern 2 : ");
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= row; col++){
                System.out.print("*");
            }
            System.out.println();
        }
        /*
             *
             **
             ***
             ****
             *****
         */
    }

    static void pattern3(int n){
        System.out.println("pattern 3 : ");
        for (int row = 1; row <= n; row++){
            for (int col = n; col >= row; col--){
                System.out.print("*");
            }
            System.out.println();
        }
        /*
             *****
             ****
             ***
             **
             *
         */
    }

    static void pattern4(int n){
        System.out.println("pattern 4 : ");
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= row; col++){
                System.out.print(col);
            }
            System.out.println();
        }
        /*
             1
             12
             123
             1234
             12345
         */
    }

    static void pattern5(int n){
        System.out.println("pattern 5 : ");
        for (int row = 1; row <= 2*n; row++){
            if(row <= n){
                for (int col = 1; col <= n-row; col++){
                    System.out.print(" ");
                }
                for (int col = 1; col <= row; col++){
                    System.out.print("* ");
                }
                System.out.println();
            }else{
                for (int col = 1; col <= row-n; col++){
                    System.out.print(" ");
                }
                for (int col = 1; col <= 2*n-row; col++){
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
        /*
            1               *
           1 2             * *
          1 2 3           * * *
         1 2 3 4         * * * *
        1 2 3 4 5  OR   * * * * *
         1 2 3 4         * * * *
          1 2 3           * * *
           1 2             * *
            1               *
         */
    }

    // Pattern 6: Right-aligned staircase triangle (stars pushed to right with spaces)
    static void pattern6(int n){
        System.out.println("pattern 6 : ");
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= n - row; col++){
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++){
                System.out.print("*");
            }
            System.out.println();
        }
        /*
                 *
                **
               ***
              ****
             *****
         */
    }

    // Pattern 7: Centered pyramid of stars
    static void pattern7(int n){
        System.out.println("pattern 7 : ");
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= n - row; col++){
                System.out.print(" ");
            }
            for (int col = 1; col <= 2 * row - 1; col++){
                System.out.print("*");
            }
            System.out.println();
        }
        /*
                 *
                ***
               *****
              *******
             *********
         */
    }

    // Pattern 8: Inverted centered pyramid of stars
    static void pattern8(int n){
        System.out.println("pattern 8 : ");
        for (int row = n; row >= 1; row--){
            for (int col = 1; col <= n - row; col++){
                System.out.print(" ");
            }
            for (int col = 1; col <= 2 * row - 1; col++){
                System.out.print("*");
            }
            System.out.println();
        }
        /*
             *********
              *******
               *****
                ***
                 *
         */
    }

    // Pattern 9: Hollow rectangle border
    static void pattern9(int n){
        System.out.println("pattern 9 : ");
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= n; col++){
                if (row == 1 || row == n || col == 1 || col == n){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        /*
             *****
             *   *
             *   *
             *   *
             *****
         */
    }

    // Pattern 10: Butterfly pattern (two mirrored triangles)
    static void pattern10(int n){
        System.out.println("pattern 10 : ");
        // Upper half
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= row; col++){
                System.out.print("*");
            }
            for (int col = 1; col <= 2 * (n - row); col++){
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++){
                System.out.print("*");
            }
            System.out.println();
        }
        // Lower half
        for (int row = n; row >= 1; row--){
            for (int col = 1; col <= row; col++){
                System.out.print("*");
            }
            for (int col = 1; col <= 2 * (n - row); col++){
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++){
                System.out.print("*");
            }
            System.out.println();
        }
        /*
             *        *
             **      **
             ***    ***
             ****  ****
             **********
             **********
             ****  ****
             ***    ***
             **      **
             *        *
         */
    }

    // Pattern 11: Right-aligned number triangle
    static void pattern11(int n){
        System.out.println("pattern 11 : ");
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= n - row; col++){
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++){
                System.out.print(col);
            }
            System.out.println();
        }
        /*
                 1
                12
               123
              1234
             12345
         */
    }

    // Pattern 12: Floyd's triangle (consecutive numbers filling rows)
    static void pattern12(int n){
        System.out.println("pattern 12 : ");
        int num = 1;
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= row; col++){
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
        /*
             1
             2 3
             4 5 6
             7 8 9 10
             11 12 13 14 15
         */
    }

    // Pattern 13: 0-1 triangle (alternating 1s and 0s based on row+col)
    static void pattern13(int n){
        System.out.println("pattern 13 : ");
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= row; col++){
                if ((row + col) % 2 == 0){
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        /*
             1
             0 1
             1 0 1
             0 1 0 1
             1 0 1 0 1
         */
    }

    // Pattern 14: Number-palindrome pyramid
    static void pattern14(int n){
        System.out.println("pattern 14 : ");
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= n - row; col++){
                System.out.print(" ");
            }
            // Ascending part: 1 to row
            for (int col = 1; col <= row; col++){
                System.out.print(col);
            }
            // Descending part: row-1 down to 1
            for (int col = row - 1; col >= 1; col--){
                System.out.print(col);
            }
            System.out.println();
        }
        /*
                 1
                121
               12321
              1234321
             123454321
         */
    }

    // Pattern 15: Solid diamond (pyramid + inverted pyramid)
    static void pattern15(int n){
        System.out.println("pattern 15 : ");
        // Upper pyramid
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= n - row; col++){
                System.out.print(" ");
            }
            for (int col = 1; col <= 2 * row - 1; col++){
                System.out.print("*");
            }
            System.out.println();
        }
        // Lower inverted pyramid
        for (int row = n - 1; row >= 1; row--){
            for (int col = 1; col <= n - row; col++){
                System.out.print(" ");
            }
            for (int col = 1; col <= 2 * row - 1; col++){
                System.out.print("*");
            }
            System.out.println();
        }
        /*
                 *
                ***
               *****
              *******
             *********
              *******
               *****
                ***
                 *
         */
    }

    // Pattern 16: Hollow Diamond Pattern
    static void pattern16(int n){
        System.out.println("pattern 16 : ");
        // Upper half
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= n - row; col++){
                System.out.print(" ");
            }
            for (int col = 1; col <= 2 * row - 1; col++){
                if (col == 1 || col == 2 * row - 1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        // Lower half
        for (int row = n - 1; row >= 1; row--){
            for (int col = 1; col <= n - row; col++){
                System.out.print(" ");
            }
            for (int col = 1; col <= 2 * row - 1; col++){
                if (col == 1 || col == 2 * row - 1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        /*
                 *
                * *
               *   *
              *     *
             *       *
              *     *
               *   *
                * *
                 *
         */
    }

    // Pattern 17: Concentric Square Number Grid (Distance from edge formula)
    static void pattern17(int n){
        System.out.println("pattern 17 : ");
        int originalN = n;
        n = 2 * n - 1;
        for (int row = 0; row < n; row++){
            for (int col = 0; col < n; col++){
                int atEveryIndex = originalN - Math.min(Math.min(row, col), Math.min(n - 1 - row, n - 1 - col));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
        /*
             4 4 4 4 4 4 4
             4 3 3 3 3 3 4
             4 3 2 2 2 3 4
             4 3 2 1 2 3 4
             4 3 2 2 2 3 4
             4 3 3 3 3 3 4
             4 4 4 4 4 4 4
         */
    }

    // Pattern 18: Inverted Half Pyramid of Numbers
    static void pattern18(int n){
        System.out.println("pattern 18 : ");
        for (int row = n; row >= 1; row--){
            for (int col = 1; col <= row; col++){
                System.out.print(col + " ");
            }
            System.out.println();
        }
        /*
             1 2 3 4 5
             1 2 3 4
             1 2 3
             1 2
             1
         */
    }

    // Pattern 19: Repeated Row Number Triangle
    static void pattern19(int n){
        System.out.println("pattern 19 : ");
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= row; col++){
                System.out.print(row + " ");
            }
            System.out.println();
        }
        /*
             1
             2 2
             3 3 3
             4 4 4 4
             5 5 5 5 5
         */
    }

    // Pattern 20: Alphabet Right Triangle
    static void pattern20(int n){
        System.out.println("pattern 20 : ");
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= row; col++){
                System.out.print((char)('A' + col - 1) + " ");
            }
            System.out.println();
        }
        /*
             A
             A B
             A B C
             A B C D
             A B C D E
         */
    }

    // Pattern 21: Continuous Alphabet Triangle (Floyd's Character Pattern)
    static void pattern21(int n){
        System.out.println("pattern 21 : ");
        char ch = 'A';
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= row; col++){
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
        /*
             A
             B C
             D E F
             G H I J
             K L M N O
         */
    }

    // Pattern 22: Hollow Hourglass Pattern
    static void pattern22(int n){
        System.out.println("pattern 22 : ");
        // Top half
        for (int row = n; row >= 1; row--){
            for (int col = 1; col <= n - row; col++){
                System.out.print(" ");
            }
            for (int col = 1; col <= 2 * row - 1; col++){
                if (row == n || col == 1 || col == 2 * row - 1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        // Bottom half
        for (int row = 2; row <= n; row++){
            for (int col = 1; col <= n - row; col++){
                System.out.print(" ");
            }
            for (int col = 1; col <= 2 * row - 1; col++){
                if (row == n || col == 1 || col == 2 * row - 1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        /*
             *********
              *     *
               *   *
                * *
                 *
                * *
               *   *
              *     *
             *********
         */
    }

}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Pattern Matrix Layout Strategy:
 *
 *   1. Outer Loop (`row`): Controls line numbers (1 to N or 1 to 2N-1).
 *   2. Inner Loops (`col`):
 *      - Space Loop: Prints leading spaces `n - row` or `n - row` for alignment.
 *      - Symbol Loop: Prints stars `*` or numbers based on `col` / `row` indices.
 *
 *   Concentric Grid Formula (Pattern 17):
 *   At index (row, col) in a (2n-1) x (2n-1) grid:
 *   val = n - min( min(row, col), min(2n-2-row, 2n-2-col) )
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Identify outer loop range for total rows (`row = 1..n` or `row = 1..2n-1`).
 * 2. Identify formula for leading spaces in each row (`n - row` or `row - 1`).
 * 3. Identify formula for columns in each row (`row`, `2*row - 1`, or `n - row + 1`).
 * 4. Print space/symbol inside inner loop without newline (`System.out.print`).
 * 5. Move to next line after inner loops complete (`System.out.println()`).
 *
 * POINTER / INDEX ADJUSTMENT RATIONALE:
 * - 1-based indexing (`row = 1; row <= n`) makes row counts directly equal to line numbers.
 * - Symmetry handling (`row <= n` vs `row > n`) splits diamond/butterfly shapes into clean top and bottom loops.
 *
 * EDGE CASE HANDLING:
 * - Single row / `n = 1`: Ensure loops handle boundary without printing extra spaces or skipping lines.
 *
 * UNIQUE FORMULA & LOGIC:
 * - Min Distance Formula for Concentric Rings: `originalN - min(min(r, c), min(2n-2-r, 2n-2-c))` maps distance from the nearest boundary to concentric matrix values.
 */



