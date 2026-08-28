package Exersise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MisMatched {

    public static void main(String[] args) {
        int[] arr = {2,2};
        int[] Result = findMismatch(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(Result));
    }

    static int[] findMismatch(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }
        return findMissing(arr);
    }
    static int[] findMissing(int[] arr) {
        int i = 0;
        while(i< arr.length){
            int correctIndex = arr[i] - 1;
            if(i != correctIndex && arr[i] == arr[correctIndex]) {
                return new int[]{arr[i],i+1};
            }else{
                i++;
            }
        }
        return new int[]{-1, -1};
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Array:   [ 2, 2 ]   (N=2, Duplicate=2, Missing=1)
 *
 *   Cyclic Sort pass:
 *   i=0: arr[0]=2, correctIndex = 2 - 1 = 1
 *        arr[0] != arr[1] (2 != 2 is false! arr[0] == arr[1] = 2) -> Increment i=1
 *
 *   Post-Sort Scan (`findMissing`):
 *   i=0: correctIndex = arr[0] - 1 = 1
 *        i (0) != correctIndex (1) AND arr[0] == arr[1] (2 == 2)
 *        --> Returns { arr[i], i + 1 } = { 2, 1 }
 *            (Duplicate = 2, Missing = 1)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Cyclic Sort Phase (`findMismatch`):
 *    - Loop `i` from `0` to `arr.length - 1`.
 *    - Calculate `correctIndex = arr[i] - 1`.
 *    - If `arr[i] != arr[correctIndex]`, swap `arr[i]` with `arr[correctIndex]`.
 *    - Else (already in place or duplicate detected), increment `i++`.
 * 2. Search Mismatch Phase (`findMissing`):
 *    - Iterate `i` from `0` to `arr.length - 1`.
 *    - Calculate `correctIndex = arr[i] - 1`.
 *    - If `i != correctIndex` AND `arr[i] == arr[correctIndex]`:
 *      - `arr[i]` is the **duplicate number**.
 *      - `i + 1` is the **missing number**.
 *      - Return `new int[]{ arr[i], i + 1 }`.
 * 3. Return `{-1, -1}` if no mismatch found.
 *
 * UNIQUE FORMULA & LOGIC:
 * - Dual Result Pair `{arr[i], i + 1}`: At the mismatched index `i`, `arr[i]` holds the duplicate value that took the place of the expected value `i + 1`.
 */



