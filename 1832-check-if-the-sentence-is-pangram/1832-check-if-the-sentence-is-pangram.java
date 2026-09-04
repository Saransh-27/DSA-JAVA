class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] str = new int[26];
           if(sentence.length() < 26){
                    return false;
           }
        for(int i =0; i< sentence.length(); i++){
            str[sentence.charAt(i) - 'a']++;                
        }
        for(int i =0; i< 26; i++){
            if(str[i] == 0){
                return false;
            }
        }
        return true;
    }
}