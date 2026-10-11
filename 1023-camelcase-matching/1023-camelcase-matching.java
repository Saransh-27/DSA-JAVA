class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>(queries.length);
        char[] patternArr = pattern.toCharArray();
        for(String s : queries){
            boolean isMatch = match(s.toCharArray(), patternArr);
            ans.add(isMatch);
        }
        return ans;
    }

    public Boolean match(char[] chArr, char[] patternArr){
        int idx = 0;
        for(int i =0; i< chArr.length; i++){
            if(idx < patternArr.length && chArr[i] == patternArr[idx]){
                idx++;
            }else if(chArr[i] >= 'A' && chArr[i] <= 'Z'){
                return false;
            }
        }
        return idx == patternArr.length;
    }
}