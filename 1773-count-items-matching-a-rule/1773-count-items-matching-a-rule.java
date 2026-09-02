class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int counter =0;
        int cvalue = 0;
        if(ruleKey.equals("type")){
            cvalue = 0;
        }else if(ruleKey.equals("color")){
            cvalue = 1;
        }else{
            cvalue = 2;
        }
        for(int i =0; i< items.size(); i++){
            if(ruleValue.equals(items.get(i).get(cvalue))){
                counter++;
            }
        }
        return counter;
    }
}