import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {9};

        System.out.println(Arrays.toString(plusOne(digits)));
    }

    static public int[] plusOne(int[] digits) {

            for (int i = digits.length - 1; i >= 0; i--) {

                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }

                digits[i] = 0;
            }

            // If we reach here, every digit was 9
            int[] result = new int[digits.length + 1];
            result[0] = 1;

            return result;

    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Case 1: digits = [1, 2, 3]
 *   Scan right-to-left:
 *   i=2: digits[2]=3 < 9 -> digits[2]++ = 4 -> Return [1, 2, 4]  (Done!)
 *
 *   Case 2: digits = [1, 2, 9]
 *   i=2: digits[2]=9 -> digits[2] = 0 -> [1, 2, 0]
 *   i=1: digits[1]=2 < 9 -> digits[1]++ = 3 -> Return [1, 3, 0]  (Done!)
 *
 *   Case 3: digits = [9, 9, 9]
 *   i=2: 9 -> 0 -> [9, 9, 0]
 *   i=1: 9 -> 0 -> [9, 0, 0]
 *   i=0: 9 -> 0 -> [0, 0, 0]
 *   All digits were 9! -> Create new array [1, 0, 0, 0] (length + 1)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Loop `i` from `digits.length - 1` down to `0` (right to left).
 * 2. If `digits[i] < 9`:
 *    - Increment `digits[i]++` and immediately return `digits` (no carry needed).
 * 3. If `digits[i] == 9`:
 *    - Set `digits[i] = 0` (carry propagates to next digit).
 * 4. If loop completes without returning (all digits were 9):
 *    - Create a new array of size `digits.length + 1`.
 *    - Set `result[0] = 1` (rest defaults to 0).
 *    - Return `result`.
 *
 * EDGE CASE HANDLING:
 * - All 9s (e.g., [9,9,9] -> [1,0,0,0]): Handled by creating a new larger array.
 * - Java's `new int[]` initializes all elements to 0, so only `result[0] = 1` is needed.
 *
 * UNIQUE FORMULA & LOGIC:
 * - Early return on first non-9 digit: Avoids unnecessary carry propagation checks.
 */
