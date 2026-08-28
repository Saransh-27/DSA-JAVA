package Exersise;

import java.util.Arrays;

public class Search2D {
    public static void main(String[] args) {
        int[][] arr2D ={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int target = 7;
        System.out.println("the target "+target+" is found at index :"+Arrays.toString(linearsearch2D(arr2D, target)));
        System.out.println("the target "+target+" is found at index :"+Arrays.toString(binarySearch2D(arr2D, target))+" with using binary search");
    }
    public static int[] linearsearch2D(int[][] arr2D, int target) {
        for(int row =0; row <= arr2D.length -1; row++){
            for(int col =0; col <= arr2D[row].length -1; col++){
                if(arr2D[row][col] == target){
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] binarySearch2D(int[][] arr2D, int target) {
        int left = 0;
        int right = arr2D.length - 1;
        while(left < arr2D.length && right >= 0){
            if(arr2D[left][right] == target){
                return new int[]{left, right};
            }else if(arr2D[left][right] < target){
                left++;
            }else if(arr2D[left][right] > target){
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Row 0 (left=0) ---->  [ 10,  20,  30,  40 ] <--- (right=3) Top-Right Corner
 *   Row 1               [ 15,  25,  35,  45 ]
 *   Row 2               [ 28,  29,  37,  47 ]
 *   Row 3               [ 34,  36,  40,  49 ]
 *
 *   If arr[left][right] == target -> Found at {left, right}
 *   If arr[left][right] < target  -> Eliminate Row (left++)
 *   If arr[left][right] > target  -> Eliminate Column (right--)
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Start search from top-right corner (`left = 0`, `right = arr2D.length - 1`) in row/col sorted 2D array.
 * 2. Loop while `left < arr2D.length` and `right >= 0`:
 *    - If `arr2D[left][right] == target`, return `{left, right}`.
 *    - If `arr2D[left][right] < target`, move down by `left++` (eliminates current row).
 *    - If `arr2D[left][right] > target`, move left by `right--` (eliminates current column).
 * 3. Return `{-1, -1}` if target is not found.
 *
 * POINTER ADJUSTMENT RATIONALE:
 * - Starting at top-right corner allows binary elimination: elements left are smaller, elements down are larger.
 */

