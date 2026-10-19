import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSolution {
    public static void main(String[] args) {
//        String s = "codeleet";
//        int[] indices = {4,5,6,7,0,2,1,3};
//        System.out.println(restoreString(s, indices));

//        String command = "G()(al)";
//        System.out.println(command.length());
//        System.out.println(interpret(command));

//       String s = "textbook";
//        System.out.println(halvesAreAlike(s));

//        String s = "1326#";
//        System.out.println(freqAlphabets(s));

//        String s = "   fly me   to   the moon         ";
//        System.out.println(lengthOfLastWord(s));

//        String s = "(}";
//        System.out.println(isValid(s));

//        String s = "MCMXCIV";
//        System.out.println(romanToInt(s));

//        String[] s = {"a","abc","bc","d"};
//        System.out.println(numOfStrings(s, "abc"));

//        String s = "is2 sentence4 This1 a3";
//        System.out.println(Arrays.toString(s.split(" ")));

//        String s = "is2 sentence4 This1 a3";
//        System.out.println(sortSentence(s));

//        String s = "DRL";
//        System.out.println(judgeCircle(s));

//        String str = "Let's take LeetCode contest";
//        System.out.println(reverseWords(str));

//        String s = "0000000000";
//        int minJump =2, maxJump = 5;
//        System.out.println(canReach(s, minJump, maxJump));

//        int num = 701;
//        System.out.println(convertToTitle(num));

//        String s = "xyxzxe";
//        char ch = 'a';
//        System.out.println(reversePrefix(s, ch));

//        String s1 = "avc";
//        String s2 = "pqr";
//        System.out.println(mergeAlternately(s1, s2));

//        String s1 = "111";
//        System.out.println(checkOnesSegment(s1));

//        String sq = "ababc", wr = "ba";
//        System.out.println(maxRepeating(sq, wr));

//        String name = "alex", typed = "aaleexa";
//        System.out.println(isLongPressedName(name, typed));

//        String s1 = " ";
//        System.out.println(isPalindrome(s1));

//        String s = "a";
//        System.out.println(validPalindrome(s));

//        String s1 = "abda";
//        String s2 = "acmc";
//        System.out.println(checkPalindromeFormation(s1, s2));

//        String str1 = "of", str2 = "A lot of words";
//        System.out.println(areSentencesSimilar(str1, str2));

//        String[] strs = {"dog","racecar","car"};
//        System.out.println(longestCommonPrefix(strs));

//        String str = "CONTEST IS COMING";
//        System.out.println(printVertically2(str));

//        String s = "bad";
//        int[] arr = {10,20,30};
//        System.out.println(shiftingLetters(s, arr));

//        String[] s = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
//        String s2 = "FB";
//        System.out.println(camelMatch(s, s2));


//        int[] arr = {1,2,3,4};
//        System.out.println(Arrays.toString(productExceptSelf(arr)));

//        String s1 = "abcab", s2 = "abc";
//        int[] arr = {0,1,2,3,4};
//        System.out.println(maximumRemovals(s1, s2, arr));

//        String start = "LXXLXRLXXL", result = "XLLXRXLXLX";
//        System.out.println(canTransform(start, result));

//        String s = "zzzzz";
//        System.out.println(countHomogenous(s));

        String s = "0110111";
        System.out.println(numSub(s));
    }

    static String restoreString(String s, int[] indices) {
        char[] result = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            result[indices[i]] = s.charAt(i);
        }
        return new String(result);
    }

    static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    static String interpret(String command) {
        StringBuilder str = new StringBuilder();
        int index = 0;
        while (index < command.length()) {
            if (command.charAt(index) == 'G') {
                str.append('G');
                index++;
            } else if (command.charAt(index) == '(' && command.charAt(index + 1) == ')') {
                str.append('o');
                index += 2;
            } else if (command.charAt(index) == '(' && command.charAt(index + 1) == 'a') {
                str.append("al");
                index += 4;
            }
        }
        return str.toString();
    }

    static boolean halvesAreAlike(String s) {
        int count1 = 0;
        int count2 = 0;
        int i = 0;
        int j = s.length() / 2;
        while (i < s.length() / 2 && j < s.length()) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'A') {
                count1++;
            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                count1++;
            } else if (s.charAt(i) == 'i' || s.charAt(i) == 'I') {
                count1++;
            } else if (s.charAt(i) == 'o' || s.charAt(i) == 'O') {
                count1++;
            } else if (s.charAt(i) == 'u' || s.charAt(i) == 'U') {
                count1++;
            }

            if (s.charAt(j) == 'a' || s.charAt(j) == 'A') {
                count2++;
            } else if (s.charAt(j) == 'e' || s.charAt(j) == 'E') {
                count2++;
            } else if (s.charAt(j) == 'i' || s.charAt(j) == 'I') {
                count2++;
            } else if (s.charAt(j) == 'o' || s.charAt(j) == 'O') {
                count2++;
            } else if (s.charAt(j) == 'u' || s.charAt(j) == 'U') {
                count2++;
            }
            i++;
            j++;
        }
        return count1 == count2;
    }

    static String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();
        int index = s.length() - 1;
        while (index >= 0) {
            StringBuilder temp = new StringBuilder(2);
            if (s.charAt(index) == '#') {
                temp.append(s.charAt(index - 2));
                temp.append(s.charAt(index - 1));
                result.append(check(temp));
                index -= 3;
            } else {
                temp.append(s.charAt(index));
                result.append(check(temp));
                index--;
            }
        }
        return result.reverse().toString();
    }


    static public char check(StringBuilder s) {
        int number = Integer.parseInt(s.toString());
        return (char) ('a' + number - 1);
    }

    static int lengthOfLastWord(String s) {
        String stripped = s.strip();
        int idx = stripped.length() - 1;
        int count = 0;
        while (idx >= 0) {
            if (stripped.charAt(idx) != ' ') {
                count++;
            } else {
                break;
            }
            idx--;
        }
        return count;
    }

    static boolean isValid(String s) {
        int idx = 0;
        while (idx < s.length()) {
            if (s.length() < 2) {
                return false;
            } else if (s.charAt(idx) == '(' && s.charAt(idx + 1) == ')'
                    || s.charAt(idx) == '[' && s.charAt(idx + 1) == ']'
                    || s.charAt(idx) == '{' && s.charAt(idx + 1) == '}') {
                idx += 2;
            } else {
                return false;
            }
        }
        return true;
    }

    static int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = value(s.charAt(i));
            if (i + 1 < s.length() && curr < value(s.charAt(i + 1))) {
                ans -= curr;
            } else {
                ans += curr;
            }
        }
        return ans;
    }

    static int value(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }


    static int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }
        return count;
    }

    static String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] res = new String[words.length];
        for (String word : words) {
            int idx = word.charAt(word.length() - 1) - '0';
            res[idx - 1] = word.substring(0, word.length() - 1);
        }
        return String.join(" ", res);
    }

    static boolean judgeCircle(String moves) {
        int[] move = new int[2];
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') {
                move[0]++;
            } else if (moves.charAt(i) == 'D') {
                move[0]--;
            } else if (moves.charAt(i) == 'R') {
                move[1]++;
            } else {
                move[1]--;
            }
        }
        return move[0] == 0 && move[1] == 0;
    }

    static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            int end = words[i].length() - 1;
            while (0 <= end) {
                ans.append(words[i].charAt(end));
                end--;
            }
            if (i != words.length - 1) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }

    static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') return false;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int reachable = 0;
        for (int i = 1; i < n; i++) {
            if (i >= minJump && dp[i - minJump]) reachable++;
            if (i > maxJump && dp[i - maxJump - 1]) reachable--;
            if (reachable > 0 && s.charAt(i) == '0') dp[i] = true;
        }
        return dp[n - 1];
    }

    static String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            res.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }

    static String reversePrefix(String word, char ch) {
        StringBuilder result = new StringBuilder();
        int isEqual = 0;
        while (isEqual < word.length()) {
            if (word.charAt(isEqual) == ch) {
                result.append(add(word.substring(0, isEqual + 1)));
                int next = isEqual + 1;
                while (next < word.length()) {
                    result.append(word.charAt(next));
                    next++;
                }
                return result.toString();
            }
            isEqual++;
        }
        return word;
    }

    static String add(String word) {
        StringBuilder result = new StringBuilder();
        int end = word.length() - 1;
        while (end >= 0) {
            result.append(word.charAt(end));
            end--;
        }
        return result.toString();
    }

    static String mergeAlternately(String word1, String word2) {
        int index1 = 0;
        int index2 = 0;
        StringBuilder result = new StringBuilder();
        while (index1 < word1.length() || index2 < word2.length()) {
            if (index1 < word1.length()) {
                result.append(word1.charAt(index1));
                index1++;
            }
            if (index2 < word2.length()) {
                result.append(word2.charAt(index2));
                index2++;
            }
        }
        return result.toString();
    }

    static boolean checkOnesSegment(String s) {
        boolean ended = false;
        int i = 0;
        while (i < s.length()) {
            if (i < s.length() - 1 && s.charAt(i) == '1' && s.charAt(i + 1) == '0') {
                ended = true;
            }
            if (s.charAt(i) == '1' && ended && i > 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    static int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder words = new StringBuilder(word);
        while (sequence.contains(words.toString())) {
            count++;
            words.append(word);
        }
        return count;
    }

    static boolean isLongPressedName(String name, String typed) {
        int nStart = 0;
        int tStart = 0;
        while (tStart < typed.length()) {
            if (nStart < name.length() && name.charAt(nStart) == typed.charAt(tStart)) {
                nStart++;
            } else if (tStart == 0 || typed.charAt(tStart) != typed.charAt(tStart - 1)) {
                return false;
            }
            tStart++;
        }
        return nStart == name.length();
    }

    static boolean isPalindrome(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                ans.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        int start = 0;
        int end = ans.length() - 1;
        while (start < end) {
            if (ans.charAt(start) == ans.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return palindrome(s, start) || palindrome(s, end);
            }
        }
        return true;
    }

    static boolean palindrome(String s, int p1) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (start == p1) {
                start++;
            } else {
                end--;
            }

            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    static boolean checkPalindromeFormation(String a, String b) {
        if (isPalindromeFun(a, 0, a.length() - 1) || isPalindromeFun(b, 0, b.length() - 1)) return true;
        else return check1(a, b) || check1(b, a);
    }
    static boolean isPalindromeFun(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    static boolean check1(String a, String b) {
        int start = 0;
        int end = b.length() - 1;
        while (start < end && b.charAt(start) == a.charAt(start)) {
            start++;
            end--;
        }
        return isPalindromeFun(a, start, end) || isPalindromeFun(b, start, end);
    }

    static boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] sen1 = sentence1.split(" ");
        String[] sen2 = sentence2.split(" ");
        if (sen1.length < sen2.length) {
            String[] temp = sen1;
            sen1 = sen2;
            sen2 = temp;
        }
        int left = 0;
        int s1End = sen1.length - 1;
        int s2End = sen2.length - 1;
        while (left <= s2End && sen1[left].equals(sen2[left])) {
            left++;
        }
        while (left <= s2End && sen1[s1End].equals(sen2[s2End])) {
            s1End--;
            s2End--;
        }
        return left > s2End;
    }

    static String longestCommonPrefix(String[] strs) {
        StringBuilder com = new StringBuilder(strs[maxEl(strs)]);
        for (String str : strs) {
            int start = 0;
            while (start < com.length()) {
                if (str.charAt(start) != com.charAt(start)) {
                    com.delete(start, com.length());
                    break;
                }
                start++;
            }
        }
        return com.toString();
    }

    static int maxEl(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                idx = i;
                minLen = strs[i].length();
            }
        }
        return idx;
    }

    static int maxLe(String[] strs) {
        int max = Integer.MIN_VALUE;
        for (String s : strs) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }
    static List<String> printVertically2(String s) {
        String[] str = s.split(" ");
        int cols = maxLe(str);
        String[] ans = new String[cols];
        Arrays.fill(ans, "");
        int start = 0;
        int idx = 0;
        while (start < cols) {
            for (String el : str) {
                if (start < el.length()) {
                    ans[idx] += String.valueOf(el.charAt(start));
                } else {
                    ans[idx] += " ";
                }
            }
            ans[idx] = ans[idx].stripTrailing();
            start++;
            idx++;
        }
        return Arrays.asList(ans);
    }

    static String shiftingLetters(String s, int[] shifts) {
        int idx = 0;
        StringBuilder ans = new StringBuilder(s.length());
        int shiftLen = 0;
        for (int shift : shifts) {
            shiftLen = (shiftLen + shift % 26) % 26;
        }
        while (idx < s.length()) {
            if (idx > 0) shiftLen = (shiftLen - shifts[idx - 1] % 26 + 26) % 26;
            ans.append(shift(s.charAt(idx), shiftLen));
            idx++;
        }
        return ans.toString();
    }
    static char shift(char ch, int shiftLen) {
        shiftLen %= 26;
        return (char) ((ch - 'a' + shiftLen) % 26 + 'a');
    }


    static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>(queries.length);
        char[] patternArr = pattern.toCharArray();
        for(String s : queries){
            boolean isMatch = match(s.toCharArray(), patternArr);
            ans.add(isMatch);
        }
        return ans;
    }
    static Boolean match(char[] chArr, char[] patternArr){
        int idx = 0;
        for (char c : chArr) {
            if (idx < patternArr.length && c == patternArr[idx]) {
                idx++;
            } else if (c >= 'A' && c <= 'Z') {
                return false;
            }
        }
        return idx == patternArr.length;
    }

    static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int prefix = 1;
        for(int i =0; i< result.length; i++){
            result[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for(int i = result.length-1; i >= 0; i--){
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }

    static int maximumRemovals(String s, String p, int[] removable) {
        int start =0;
        int end = removable.length;
        int ans =0;
        while(start <= end){
            int mid = start + (end-start)/2;
            Boolean[] mark = new Boolean[s.length()];
            Arrays.fill(mark, false);
            for(int i =0; i < mid; i++){
                mark[removable[i]] = true;
            }
            if(checkMark(s, p, mark)){
                ans = mid;
                start = mid+1;
            }else{
                end = mid -1;
            }
        }
        return ans;
    }
    static boolean checkMark(String s, String p, Boolean[] mark) {
        int start = 0;
        int pIdx = 0;
        while (start < s.length() && pIdx < p.length()){
            if(!mark[start] && s.charAt(start) == p.charAt(pIdx)){
                pIdx++;
            }
            start++;
        }
        return pIdx == p.length();
    }

    static boolean canTransform(String start, String result) {
        int i = 0, j = 0, n = start.length();
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && result.charAt(j) == 'X') j++;

            if (i == n || j == n) return i == n && j == n;
            if (start.charAt(i) != result.charAt(j)) return false;
            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;

            i++;
            j++;
        }
        return true;
    }

    static int countHomogenous(String s) {
        int count =0;
        int consecutive = 0;
        char prev = ' ';
        int mod = 1000000007;
        for(int i =0; i< s.length(); i++){
            char curr = s.charAt(i);
            if(curr == prev){
                consecutive++;
            }else{
                consecutive =1;
                prev = curr;
            }
            count = (count+consecutive)%mod;
        }
        return count;
    }

    static int numSub(String s) {
        int count = 0;
        int consecutive =0;
        int mod = 1000000007;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
               consecutive++;
            }else{
                consecutive = 0;
            }
            count = (count+consecutive)%mod;
        }
        return count;
    }
}

/*
 * ============================
 * FUNCTION 1: restoreString (LC 1528 - Shuffle String)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   s       = "codeleet"
 *   indices = [4,5,6,7,0,2,1,3]
 *
 *   result[4]='c'  result[5]='o'  result[6]='d'  result[7]='e'
 *   result[0]='l'  result[2]='e'  result[1]='t'  result[3]='?'
 *            → "leetcode"
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Create char[] result of same length as s.
 *   2. For each i, place s.charAt(i) at result[indices[i]].
 *   3. Return new String(result).
 *
 * UNIQUE FORMULA & LOGIC:
 *   - Direct index mapping: result[indices[i]] = s.charAt(i)
 *
 * ============================
 * FUNCTION 2: defangIPaddr (LC 1108 - Defanging an IP Address)
 * ============================
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Replace all "." with "[.]" using String.replace().
 *   - One-liner leveraging built-in replace.
 *
 * ============================
 * FUNCTION 3: interpret (LC 1678 - Goal Parser Interpretation)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   command = "G()(al)"
 *           G → 'G'   () → 'o'   (al) → "al"
 *           Result = "Goal"
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Walk with index pointer.
 *   2. If charAt(index) == 'G' → append 'G', index++.
 *   3. If '(' followed by ')' → append 'o', index += 2.
 *   4. If '(' followed by 'a' → append "al", index += 4 (skips "(al)").
 *
 * POINTER / INDEX ADJUSTMENT RATIONALE:
 *   - index += 2 for "()" skips both chars.
 *   - index += 4 for "(al)" skips all 4 chars.
 *
 * ============================
 * FUNCTION 4: halvesAreAlike (LC 1704 - Determine if String Halves Are Alike)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   s = "textbook"
 *   first half: "text" → vowels: 'e' → count1 = 1
 *   second half: "book" → vowels: 'o','o' → count2 = 2
 *   1 != 2 → false
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Use two pointers: i (first half), j (second half starting at len/2).
 *   2. Count vowels (a,e,i,o,u case-insensitive) in each half.
 *   3. Return count1 == count2.
 *
 * ============================
 * FUNCTION 5: freqAlphabets + check (LC 1309 - Decrypt String from Alphabet to Integer Mapping)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   s = "1326#"
 *     Scan RIGHT to LEFT:
 *     '#' found → take "26" → 'z'
 *     '3' → 'c'
 *     '1' → 'a'
 *     Result (reversed) = "acz"
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Start from end of string (index = len-1).
 *   2. If char == '#', take previous 2 chars as number → map to letter, index -= 3.
 *   3. Otherwise, single digit → map to letter, index--.
 *   4. Reverse the result at the end.
 *
 * UNIQUE FORMULA & LOGIC:
 *   - Mapping: (char)('a' + number - 1) converts 1→'a', 26→'z'.
 *
 * ============================
 * FUNCTION 6: lengthOfLastWord (LC 58 - Length of Last Word)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   s = "   fly me   to   the moon         "
 *   After strip: "fly me   to   the moon"
 *   Scan from end: 'm','o','o','n' → count = 4, hit ' ' → break
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Strip leading/trailing spaces.
 *   2. Scan backwards from end, increment count until space hit.
 *   3. Return count.
 *
 * ============================
 * FUNCTION 7: isValid (LC 20 - Valid Parentheses - simplified)
 * ============================
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. If length < 2, return false.
 *   2. Check consecutive pairs: (), [], {} → advance by 2.
 *   3. If any pair doesn't match → return false.
 *   Note: This is a simplified version that only works for non-nested brackets.
 *
 * ============================
 * FUNCTION 8: romanToInt + value (LC 13 - Roman to Integer)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   s = "MCMXCIV"
 *   M=1000  C<M→-100  M=+1000  X<C→-10  C=+100  I<V→-1  V=+5
 *   = 1000 - 100 + 1000 - 10 + 100 - 1 + 5 = 1994
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. For each char, get its Roman value.
 *   2. If current < next → subtract current (subtractive case like IV, IX, XL).
 *   3. Otherwise → add current.
 *
 * UNIQUE FORMULA & LOGIC:
 *   - Subtractive rule: if value(s[i]) < value(s[i+1]), subtract instead of add.
 *
 * ============================
 * FUNCTION 9: numOfStrings (LC 1967 - Number of Strings That Appear as Substrings in Word)
 * ============================
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. For each pattern in patterns[], check if word.contains(pattern).
 *   2. If yes, increment count.
 *   3. Return count.
 *
 * ============================
 * FUNCTION 10: sortSentence (LC 1859 - Sorting the Sentence)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   s = "is2 sentence4 This1 a3"
 *   "is2" → idx=2, word="is" → res[1] = "is"
 *   "This1" → idx=1, word="This" → res[0] = "This"
 *   Result: "This is a sentence"
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Split by spaces.
 *   2. For each word, extract last char as position digit.
 *   3. Place word (without last char) at res[digit - 1].
 *   4. Join with spaces.
 *
 * UNIQUE FORMULA & LOGIC:
 *   - Position extraction: word.charAt(word.length()-1) - '0' gives 1-based index.
 *
 * ============================
 * FUNCTION 11: judgeCircle (LC 657 - Robot Return to Origin)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   moves = "UD"  →  U:(+1,0) D:(-1,0)  →  (0,0) = origin ✓
 *   moves = "LL"  →  L:(0,-1) L:(0,-1)  →  (0,-2) ≠ origin ✗
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Track vertical (move[0]) and horizontal (move[1]) displacement.
 *   2. U→+1, D→-1 on move[0]; R→+1, L→-1 on move[1].
 *   3. Return true if both == 0.
 *
 * ============================
 * FUNCTION 12: reverseWords (LC 557 - Reverse Words in a String III)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   s = "Let's take LeetCode contest"
 *   "Let's" → "s'teL"   "take" → "ekat"
 *   Result: "s'teL ekat edoCteeL tsetnoc"
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Split by space.
 *   2. For each word, reverse it char-by-char (scan from end to start).
 *   3. Join words with spaces.
 *
 * ============================
 * FUNCTION 13: canReach (LC 1871 - Jump Game VII)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   s = "011010", minJump=2, maxJump=3
 *   Index:  0  1  2  3  4  5
 *   Char:   0  1  1  0  1  0
 *   dp[0]=T  →  can reach [2..3]  →  dp[3]=T (char='0')
 *   dp[3]=T  →  can reach [5..6]  →  dp[5]=T (char='0') ✓
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. If last char == '1', return false (can't land on '1').
 *   2. dp[0] = true. Track "reachable" count using sliding window.
 *   3. For each i: if i >= minJump and dp[i-minJump], reachable++.
 *   4. If i > maxJump and dp[i-maxJump-1], reachable-- (window slides out).
 *   5. If reachable > 0 and s[i] == '0', dp[i] = true.
 *   6. Return dp[n-1].
 *
 * UNIQUE FORMULA & LOGIC:
 *   - Sliding window DP: reachable tracks how many valid sources exist in
 *     [i-maxJump, i-minJump] window, avoiding O(n*k) brute force.
 *
 * ============================
 * FUNCTION 14: convertToTitle (LC 168 - Excel Sheet Column Title)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   701 → 701-1=700 → 700%26=24 → 'Y' → 700/26=26
 *       → 26-1=25  → 25%26=25  → 'Z' → 25/26=0  → stop
 *   Reversed: "ZY" → Result
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. While columnNumber > 0: decrement by 1 (shift to 0-based).
 *   2. Append (char)('A' + columnNumber % 26).
 *   3. Divide columnNumber by 26.
 *   4. Reverse the result.
 *
 * UNIQUE FORMULA & LOGIC:
 *   - columnNumber-- before mod/divide converts 1-based (A=1) to 0-based (A=0).
 *   - Without decrement, 'Z' (26) would be treated as next digit incorrectly.
 *
 * ============================
 * FUNCTION 15: reversePrefix + add (LC 2000 - Reverse Prefix of Word)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   word = "abcdefd", ch = 'd'
 *   Find first 'd' at index 3 → reverse "abcd" → "dcba"
 *   Append rest "efd" → "dcbaefd"
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Find first occurrence of ch in word.
 *   2. Reverse substring [0..index] using helper add().
 *   3. Append remaining substring [index+1..end].
 *   4. If ch not found, return word unchanged.
 *
 * ============================
 * FUNCTION 16: mergeAlternately (LC 1768 - Merge Strings Alternately)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   word1 = "abc"    word2 = "pqr"
 *   index:  a p b q c r
 *   Result: "apbqcr"
 *
 *   word1 = "ab"     word2 = "pqrs"
 *   index:  a p b q r s
 *   Result: "apbqrs"
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Two pointers index1, index2 starting at 0.
 *   2. While either has chars left:
 *      - Append from word1 if index1 in bounds, index1++.
 *      - Append from word2 if index2 in bounds, index2++.
 *   3. Return result.
 *
 * ============================
 * FUNCTION 17: checkOnesSegment (LC 1784 - Check if Binary String Has at Most One Segment of Ones)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   "110"  → 1,1 then 0 → ended=true → no more 1s → true
 *   "1001" → 1 then 0 → ended=true → then 1 found after ended → false
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Track "ended" flag: set true when '1' is followed by '0'.
 *   2. If we see '1' after ended is true, return false.
 *   3. If we finish without violation, return true.
 *
 * ============================
 * FUNCTION 18: maxRepeating (LC 1668 - Maximum Repeating Substring)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   sequence = "ababc", word = "ab"
 *   Check: "ab"   in "ababc"? ✓ count=1
 *   Check: "abab" in "ababc"? ✓ count=2
 *   Check: "ababab" in "ababc"? ✗ → return 2
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Start with words = word, count = 0.
 *   2. While sequence.contains(words): count++, words += word.
 *   3. Return count.
 *
 * ============================
 * FUNCTION 19: isLongPressedName (LC 925 - Long Pressed Name)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   name  = "alex"     typed = "aaleex"
 *   a==a → nStart=1    a==prev 'a' → skip
 *   l==l → nStart=2    e==e → nStart=3
 *   e==prev 'e' → skip  x==x → nStart=4
 *   nStart == name.length → true ✓
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Two pointers: nStart (name), tStart (typed).
 *   2. If name[nStart] == typed[tStart] → advance both.
 *   3. Else if typed[tStart] == typed[tStart-1] → long press, advance tStart only.
 *   4. Else → mismatch, return false.
 *   5. Return nStart == name.length (all chars consumed).
 *
 * POINTER / INDEX ADJUSTMENT RATIONALE:
 *   - nStart advances only on exact match, allowing typed to have extras.
 *   - Long-press chars must match previous typed char.
 *
 * ============================
 * FUNCTION 20: isPalindrome (LC 125 - Valid Palindrome)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   s = "A man, a plan, a canal: Panama"
 *   Clean: "amanaplanacanalpanama"
 *    start→ a                    a ←end   ✓
 *           m                  m          ✓
 *   ... all match → true
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Filter: keep only alphanumeric, convert to lowercase.
 *   2. Two pointers (start, end) moving inward.
 *   3. If mismatch found → return false.
 *   4. If all match → return true.
 *
 * ============================
 * FUNCTION 21: validPalindrome + palindrome (LC 680 - Valid Palindrome II)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   s = "abca"
 *   start→a  a←end ✓   b≠c → try removing:
 *     Remove s[start=1]: check "aca" → palindrome ✓ → true
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Two-pointer check. If mismatch at (start, end):
 *   2. Try skipping char at start OR skipping char at end.
 *   3. If either resulting substring is palindrome → return true.
 *   4. palindrome() helper checks with one index excluded (p1).
 *
 * EDGE CASE HANDLING:
 *   - At most one deletion allowed (can't skip two chars).
 *
 * ============================
 * FUNCTION 22: checkPalindromeFormation (LC 1616 - Split Two Strings to Make Palindrome)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   a = "ulacfd", b = "jizalu"
 *   check1(a,b): compare b[start] vs a[start] from outside in
 *   b[0]='j' vs a[0]='u' → mismatch at start=0
 *   Then check if a[0..5] or b[0..5] is palindrome itself
 *
 *   check1(b,a): compare a[start] vs b[start]... → find matching prefix/suffix
 *   then check middle portion is palindrome → true
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. If either a or b is already a palindrome → return true.
 *   2. check1(a,b): match b's prefix with a's suffix moving inward.
 *   3. When mismatch, check if remaining middle of a OR b is palindrome.
 *   4. Try both orderings: check1(a,b) || check1(b,a).
 *
 * UNIQUE FORMULA & LOGIC:
 *   - Split point: prefix of one string + suffix of other = palindrome.
 *   - After matching outer chars, only the inner unmatched part needs palindrome check.
 *
 * ============================
 * FUNCTION 23: areSentencesSimilar (LC 1813 - Sentence Similarity III)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   sen1 = "A lot of words"  →  ["A","lot","of","words"]
 *   sen2 = "of"              →  ["of"]
 *   Ensure sen1 is longer. left=0: "A"≠"of" → stop.
 *   Right: "words"≠"of" → stop. left(0) > s2End(0)? No → false
 *
 *   sen1 = "My name is Hakim"  sen2 = "My Hakim"
 *   left: "My"=="My" → left=1. "name"≠"Hakim" → stop.
 *   right: "Hakim"=="Hakim" → s1End=2,s2End=0.  left(1) > s2End(0) → true ✓
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Split both sentences. Ensure sen1 is the longer one.
 *   2. Match from left: while words match, advance left.
 *   3. Match from right: while words match, shrink both ends.
 *   4. If left > s2End, all of sen2 is accounted for → true.
 *
 * UNIQUE FORMULA & LOGIC:
 *   - Sen2 must be a sub-sequence that fits as prefix + suffix of sen1.
 *   - Insertion point is in the middle of sen1.
 *
 * ============================
 * FUNCTION 24: longestCommonPrefix + maxEl (LC 14 - Longest Common Prefix)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   strs = ["flower","flow","flight"]
 *   Start with shortest: "flow" (len=4)
 *   vs "flower": f✓ l✓ o✓ w✓  → "flow"
 *   vs "flow":   f✓ l✓ o✓ w✓  → "flow"
 *   vs "flight": f✓ l✓ i≠o → trim to "fl"
 *   Result: "fl"
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Find shortest string (using maxEl helper - actually finds min length).
 *   2. Initialize common prefix = shortest string.
 *   3. Compare each string char-by-char. On mismatch, trim prefix.
 *   4. Return remaining prefix.
 *
 * ============================
 * FUNCTION 25: printVertically2 + maxLe (LC 1324 - Print Words Vertically)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   s = "HOW ARE YOU"
 *   H  A  Y
 *   O  R  O
 *   W  E  U
 *   → ["HAY","ORO","WEU"]
 *
 *   s = "CONTEST IS COMING"
 *   C  I  C
 *   O  S  O
 *   N     M   ← pad with space, then stripTrailing
 *   T     I
 *   E     N
 *   S     G
 *   T
 *   → ["CIC","OIS","N M","T I","E N","S G","T"]
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Split by spaces. Find max word length (maxLe helper).
 *   2. For each column index (0 to maxLen-1):
 *      - For each word: if column < word.length, take char; else pad space.
 *   3. stripTrailing() to remove trailing spaces.
 *
 * ============================
 * FUNCTION 26: shiftingLetters + shift (LC 848 - Shifting Letters)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   s = "abc", shifts = [3,5,9]
 *   Total shift for 'a': 3+5+9 = 17 → (0+17)%26 = 17 → 'r'
 *   Total shift for 'b': 5+9 = 14   → (1+14)%26 = 15 → 'p'
 *   Total shift for 'c': 9          → (2+9)%26  = 11 → 'l'
 *   Result: "rpl"
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Compute total shift = sum of all shifts (mod 26 to avoid overflow).
 *   2. For each character: apply totalShift, then subtract current shift[i-1]
 *      for the next iteration (prefix sum in reverse).
 *   3. shift() helper: (ch - 'a' + shiftLen) % 26 + 'a'.
 *
 * UNIQUE FORMULA & LOGIC:
 *   - Cumulative shift from right: shift for index i = sum(shifts[i..n-1]).
 *   - Instead of re-summing, subtract shifts[i-1] as we go left-to-right.
 *   - All mod 26 to handle wrap-around: z+1 = a.
 *
 * ============================
 * FUNCTION 27: camelMatch + match (LC 1023 - Camelcase Matching)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   pattern = "FB"
 *   "FooBar"      → F✓ o(lower,skip) o(skip) B✓ a(skip) r(skip) → idx==2 ✓ true
 *   "FootBall"    → F✓ o o t B✓ a l l → idx==2 ✓ true
 *   "FrameBuffer" → F✓ r a m e B✓ u f f e r → idx==2 ✓ true
 *   "ForceFeedBack"→ F✓ o r c e F≠B (uppercase mismatch!) → false
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. For each query, use match() helper.
 *   2. Iterate through query chars with pattern pointer idx.
 *   3. If char matches pattern[idx] → advance idx.
 *   4. Else if char is UPPERCASE → mismatch, return false (can't skip uppercase).
 *   5. Lowercase non-matching chars are silently skipped.
 *   6. Return idx == pattern.length (all pattern chars matched).
 *
 * UNIQUE FORMULA & LOGIC:
 *   - Key insight: lowercase chars can be inserted anywhere, but uppercase
 *     chars MUST match the pattern. Any extra uppercase = immediate false.
 *
 * ============================
 * FUNCTION 28: productExceptSelf (LC 238 - Product of Array Except Self)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   nums = [1, 2, 3, 4]
 *
 *   Prefix pass (left→right):
 *   result = [1, 1, 2, 6]     (prefix products before each index)
 *
 *   Suffix pass (right→left):
 *   suffix = 1 → result[3] = 6*1 = 6
 *   suffix = 4 → result[2] = 2*4 = 8
 *   suffix = 12 → result[1] = 1*12 = 12
 *   suffix = 24 → result[0] = 1*24 = 24
 *
 *   result = [24, 12, 8, 6]
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. First pass (L→R): result[i] = product of all elements LEFT of i.
 *   2. Second pass (R→L): multiply result[i] by product of all elements RIGHT of i.
 *   3. No division used. O(n) time, O(1) extra space (result array is output).
 *
 * UNIQUE FORMULA & LOGIC:
 *   - result[i] = prefixProduct[0..i-1] × suffixProduct[i+1..n-1]
 *   - Two-pass technique avoids division and handles zeros correctly.
 *
 * ============================
 * FUNCTION 29: maximumRemovals + checkMark (LC 1898 - Maximum Number of Removable Characters)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   s = "abcacb", p = "ab", removable = [3,1,0]
 *   Binary search on k (number of removals):
 *   mid=1: remove index 3 → "abc_cb" → "ab" is subseq? ✓ → ans=1, search right
 *   mid=2: remove indices 3,1 → "a_c_cb" → "ab" subseq? ✗ → search left
 *   Answer = 1
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Binary search on answer k in [0..removable.length].
 *   2. For each mid: mark first mid indices from removable[] as removed.
 *   3. checkMark(): verify if p is still a subsequence of s (skipping marked).
 *   4. If yes → ans = mid, search right (start = mid+1).
 *   5. If no → search left (end = mid-1).
 *
 * UNIQUE FORMULA & LOGIC:
 *   - Binary search on the answer: monotonic property — if k removals work,
 *     k-1 also works. If k fails, k+1 also fails.
 *   - checkMark() is a standard subsequence check with a boolean mask.
 *
 * ============================
 * FUNCTION 30: canTransform (LC 777 - Swap Adjacent in LR String)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   start  = "RXXLRXRXL"
 *   result = "XRLXXRRLX"
 *   Rules: 'L' can move LEFT (swap LX → XL), 'R' can move RIGHT (swap XR → RX)
 *   Skip all X's, then:
 *   - L in start at index i, L in result at index j: i >= j (L moved left)
 *   - R in start at index i, R in result at index j: i <= j (R moved right)
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Two pointers i,j. Skip 'X' in both strings.
 *   2. If both reach end → true. If only one → false.
 *   3. If start[i] != result[j] → false (L and R can't swap).
 *   4. If 'L' and i < j → false (L can only move LEFT, not right).
 *   5. If 'R' and i > j → false (R can only move RIGHT, not left).
 *   6. Advance both pointers.
 *
 * UNIQUE FORMULA & LOGIC:
 *   - L can only slide LEFT: its index in start must be >= its index in result.
 *   - R can only slide RIGHT: its index in start must be <= its index in result.
 *   - The relative order of L's and R's must be preserved.
 *
 * ============================
 * FUNCTION 31: countHomogenous (LC 1759 - Count Number of Homogenous Substrings)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   s = "abbcccaa"
 *   'a' → consecutive=1 → count+=1 (substrings: "a")
 *   'b' → consecutive=1 → count+=1 ("b")
 *   'b' → consecutive=2 → count+=2 ("b","bb")
 *   'c' → consecutive=1 → count+=1 ("c")
 *   'c' → consecutive=2 → count+=2 ("c","cc")
 *   'c' → consecutive=3 → count+=3 ("c","cc","ccc")
 *   'a' → consecutive=1 → count+=1
 *   'a' → consecutive=2 → count+=2
 *   Total = 13
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Track consecutive count of same char.
 *   2. If current == previous → consecutive++. Else → reset to 1.
 *   3. Add consecutive to total count each step.
 *   4. Mod 10^9+7 to prevent overflow.
 *
 * UNIQUE FORMULA & LOGIC:
 *   - A run of length k contributes k*(k+1)/2 homogenous substrings.
 *   - Adding consecutive at each step is equivalent: 1+2+3+...+k = k*(k+1)/2.
 *
 * ============================
 * FUNCTION 32: numSub (LC 1513 - Number of Substrings With Only 1s)
 * ============================
 *
 * VISUAL / SYMBOLIC DIAGRAM:
 *
 *   s = "0110111"
 *   '0' → consecutive=0
 *   '1' → consecutive=1 → count+=1 ("1")
 *   '1' → consecutive=2 → count+=2 ("1","11")
 *   '0' → consecutive=0
 *   '1' → consecutive=1 → count+=1
 *   '1' → consecutive=2 → count+=2
 *   '1' → consecutive=3 → count+=3 ("1","11","111")
 *   Total = 9
 *
 * STEP-BY-STEP PROCEDURE:
 *   1. Same pattern as countHomogenous but only for '1' chars.
 *   2. If char == '1' → consecutive++. Else → reset to 0.
 *   3. Add consecutive to count each step.
 *   4. Mod 10^9+7.
 *
 * UNIQUE FORMULA & LOGIC:
 *   - Identical math to countHomogenous: a run of k ones has k*(k+1)/2 all-1 substrings.
 *   - Incrementally adding consecutive at each step is the streaming version of this formula.
 */
