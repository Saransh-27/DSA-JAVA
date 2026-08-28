package Exersise;

import java.util.Arrays;

public class FindMissing {
    public static void main(String[] args) {
        int[] arr = {4, 0, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(findMissing(arr));
    }

    static void sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i];
            if (arr[i] != i && arr[i] < arr.length) {
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = correctIndex;
            } else {
                i++;
            }
        }
    }

    static int findMissing(int[] arr) {
        int i = 0;
        while(i< arr.length){
            if(i != arr[i]) {
                return i;
            }else{
                i++;
            }
        }
        return i;
    }

}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Array:    [ 4, 0, 2, 1 ]   (Range 0..N, N=4)
 *   Target:   Value v belongs at index v (0 at 0, 1 at 1, etc.)
 *
 *   Pass Cyclic Sort:
 *   [ 4, 0, 2, 1 ]  -> arr[0]=4 (val >= N, skip) -> i=1
 *   [ 4, 0, 2, 1 ]  -> arr[1]=0 != 1 -> Swap arr[1] & arr[0] -> [ 0, 4, 2, 1 ]
 *   [ 0, 4, 2, 1 ]  -> arr[1]=4 (val >= N, skip) -> i=2
 *   [ 0, 4, 2, 1 ]  -> arr[2]=2 == 2 (correct)   -> i=3
 *   [ 0, 4, 2, 1 ]  -> arr[3]=1 != 3 -> Swap arr[3] & arr[1] -> [ 0, 1, 2, 4 ]
 *
 *   Sorted Array: [ 0, 1, 2, 4 ]
 *   Indices:        0  1  2  3
 *                            ^
 *                   i=3 != arr[3]=4  --> Missing number is 3!
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Initialize `i = 0`.
 * 2. Cyclic Sort Phase:
 *    - Set `correctIndex = arr[i]`.
 *    - If `arr[i] != i` AND `arr[i] < arr.length`, swap `arr[i]` with `arr[correctIndex]`.
 *    - Else (element is equal to `i` or equals `arr.length`), increment `i++`.
 * 3. Search Phase (`findMissing`):
 *    - Scan array from index 0 to `arr.length - 1`.
 *    - Return the first index `i` where `arr[i] != i`.
 *    - If all 0..N-1 indices match, return `arr.length` (N is the missing number).
 *
 * EDGE CASE HANDLING (`arr[i] < arr.length`):
 * - Bounds check `arr[i] < arr.length`: Prevents `ArrayIndexOutOfBoundsException` when the element equals `N` (which belongs at index `N`, outside the 0..N-1 array range).
 */





