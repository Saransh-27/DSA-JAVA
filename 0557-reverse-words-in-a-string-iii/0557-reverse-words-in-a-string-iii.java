class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i =0; i< words.length; i++){
            int end = words[i].length()-1;
            while (0 <= end){
                ans.append(words[i].charAt(end));
                end--;
            }
            if(i != words.length-1) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}