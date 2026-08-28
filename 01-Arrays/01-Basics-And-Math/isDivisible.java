package Exersise;

public class isDivisible {
    public static void main(String[] args) {
        int num = 99;
        System.out.println(checkDivisibility(num));
    }
        public static boolean checkDivisibility(int num) {
            int originalNum = num;
            int product = 1;
            int sum = 0;
            while(num > 0){
                int rem = num % 10;
                product *= rem;
                sum += rem;
                num /= 10;
            }
            int ans = sum + product;
//            if(num%ans == 0){
//                return true;
//            }
            // else{
            //     return false
            // }
            return originalNum%ans == 0;
            // return num%(sum+product) == 0;
        }

}

/*
 * The checkDivisibility function checks if a number is divisible by the sum of its digits plus the product of its digits.
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Store original number in `originalNum` (since `num` gets reduced to 0).
 * 2. Initialize `product = 1` and `sum = 0`.
 * 3. Extract digits while `num > 0`:
 *    - `rem = num % 10` (gets rightmost digit)
 *    - `product *= rem` and `sum += rem`
 *    - `num /= 10` (removes rightmost digit)
 * 4. Compute `ans = sum + product`.
 * 5. Return `originalNum % ans == 0`.
 *
 * UNIQUE FORMULA & LOGIC:
 * - `rem = num % 10` & `num /= 10`: Extracts digits one by one from right to left using base-10 arithmetic.
 *
 * EDGE CASE HANDLING:
 * - `originalNum` copy: Saving `originalNum` is necessary because the `while` loop reduces `num` to 0. Testing `num % ans` directly would fail since `num` becomes 0.
 */



