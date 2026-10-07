class Solution {
    public boolean isLongPressedName(String name, String typed) {
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
        if (nStart == name.length()) {
            return true;
        }
        return nStart == name.length();
    }
}