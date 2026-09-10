import java.util.Arrays;

public class CountElemets {
    public static void main(String[] args) {
        int[] nums = {-71,-71,93,-71,40};
        CountElemets countElemets = new CountElemets();
        int result = countElemets.countElements(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(result);
    }

    public int countElements(int[] nums) {
        bubbleSort(nums);
        int counter =0;
        int smallest = nums[0];
        int greatest = nums[nums.length-1];
        for(int i = 1; i < nums.length -1; i++ ){
            if(nums[i] > smallest && nums[i] < greatest){
                counter++;
            }
        }
        return counter;
    }

    void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j =1; j < arr.length - i; j++) {
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Input:   [-71, -71, 93, -71, 40]
 *   After BubbleSort: [-71, -71, -71, 40, 93]
 *                       ^                 ^
 *                   smallest(-71)    greatest(93)
 *
 *   Scan index 1 to N-2 (skip first & last):
 *   i=1: -71 > -71 && -71 < 93 -> FALSE (not strictly greater than smallest)
 *   i=2: -71 > -71 && -71 < 93 -> FALSE
 *   i=3:  40 > -71 &&  40 < 93 -> TRUE  -> counter = 1
 *
 *   Result: 1 element strictly between min and max.
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Sort the array using `bubbleSort(nums)` (ascending order).
 * 2. Identify `smallest = nums[0]` and `greatest = nums[nums.length - 1]`.
 * 3. Loop `i` from index `1` to `nums.length - 2` (excludes boundaries):
 *    - If `nums[i] > smallest` AND `nums[i] < greatest`, increment `counter`.
 * 4. Return `counter`.
 *
 * EDGE CASE HANDLING:
 * - Loop starts at `i=1` and ends at `nums.length - 2`: Skips the first and last
 *   elements since they are the smallest/greatest and cannot be strictly between.
 * - Strict inequality (`>` and `<`): Elements equal to min or max are NOT counted.
 *
 * UNIQUE FORMULA & LOGIC:
 * - Uses in-place BubbleSort (O(N²)) to sort before scanning. An alternative is
 *   to find min/max in O(N) without sorting.
 */
