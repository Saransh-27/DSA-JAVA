public class ToLowerCase {
    public static void main(String[] args) {
        String str = "Hello World!";
        String lowerStr = toLowerCase(str);
        System.out.println(lowerStr); // Output: hello world!
    }

    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   Input:  "Hello World!"
 *   Output: "hello world!"
 *
 *   Character-by-character:
 *   'H' (72) -> 'h' (104)  |  'e' stays 'e'  |  'l' stays 'l'  |  ...
 *   'W' (87) -> 'w' (119)  |  '!' stays '!'
 *
 *   ASCII: Uppercase 'A'=65..'Z'=90, Lowercase 'a'=97..'z'=122
 *   Conversion: uppercase + 32 = lowercase  (e.g., 'H'(72) + 32 = 'h'(104))
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Call `str.toLowerCase()` which internally converts each uppercase character
 *    (A-Z) to its lowercase equivalent by adding 32 to the ASCII value.
 * 2. Non-alphabetic characters (digits, symbols, spaces) remain unchanged.
 *
 * UNIQUE FORMULA & LOGIC:
 * - `str.toLowerCase()`: Java's built-in method handles Unicode conversion.
 * - Manual approach would be: `if (ch >= 'A' && ch <= 'Z') ch = (char)(ch + 32)`.
 */
