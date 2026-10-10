class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder com = new StringBuilder(strs[maxEl(strs)]);
        for(String str: strs){
            int start = 0;
            while(start < com.length()){
                if(str.charAt(start) != com.charAt(start)){
                    com.delete(start, com.length());
                    break;
                }
                start++;
            }
        }
        return com.toString();
    }

    public int maxEl(String[] strs){
        int minLen = Integer.MAX_VALUE;
        int idx = 0;
        for(int i =0; i< strs.length; i++){
            if(strs[i].length() < minLen){
                idx = i;
                minLen = strs[i].length();
            }
        }
        return idx;
    } 
}