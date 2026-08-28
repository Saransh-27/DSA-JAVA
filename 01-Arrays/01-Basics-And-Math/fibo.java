package Exersise;

import java.util.Scanner;

public class fibo{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0, b = 1, c;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Term 0: a = 0
 *   Term 1: b = 1
 *   Output: 0 1
 *
 *   Iteration i=2: c = a + b = 0 + 1 = 1  -> Print 1 -> Shift: a = 1, b = 1
 *   Iteration i=3: c = a + b = 1 + 1 = 2  -> Print 2 -> Shift: a = 1, b = 2
 *   Iteration i=4: c = a + b = 1 + 2 = 3  -> Print 3 -> Shift: a = 2, b = 3
 *   Iteration i=5: c = a + b = 2 + 3 = 5  -> Print 5 -> Shift: a = 3, b = 5
 *
 *   Sequence: 0 1 1 2 3 5 ...
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Read input `n` (total number of terms to generate).
 * 2. Initialize first two terms: `a = 0`, `b = 1`.
 * 3. Print `a` and `b` separated by spaces.
 * 4. Loop `i` from `2` to `n - 1`:
 *    - Calculate next term: `c = a + b`.
 *    - Print `c`.
 *    - Shift pointers forward: `a = b`, `b = c`.
 *
 * POINTER ADJUSTMENT RATIONALE:
 * - `a = b` and `b = c`: Slides the 2-variable window forward by one term so that `a` and `b` always represent the last two calculated Fibonacci numbers.
 */
