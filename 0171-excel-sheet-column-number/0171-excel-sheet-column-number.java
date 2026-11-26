class Solution {
    public int titleToNumber(String columnTitle) {
        long ans = 0;
        for(int i =0; i < columnTitle.length(); i++){
            int ch = (columnTitle.charAt(i) - 'A')+1;
            ans = ans * 26 + ch;
        }
        return (int)ans;
    }
}