package Exersise;

public class LinearSearchInString {
    public static void main(String[] args) {
        String str = "abcde";
        char target = 'g';
        System.out.println("Is the element found : "+linearSearch(str, target));
    }

    static boolean linearSearch(String str, char target) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == target) {
                return true;
            }
        }
            return false;
    }
}

/*
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   String: "abcde", Target: 'g'
 *   Index:   0    1    2    3    4
 *   Chars:  ['a', 'b', 'c', 'd', 'e']
 *            ^    ^    ^    ^    ^
 *           'a'!='g'  'b'!='g'  ... -> None match -> Return false
 *
 * STEP-BY-STEP PROCEDURE:
 * 1. Loop `i` from index `0` to `str.length() - 1`.
 * 2. Extract character at index `i` using `char ch = str.charAt(i)`.
 * 3. Compare `ch == target`. If match found, return `true`.
 * 4. After scanning all characters, return `false`.
 *
 * UNIQUE FORMULA & LOGIC:
 * - `str.charAt(i)`: Zero-based indexing method to inspect individual characters in a String.
 */


