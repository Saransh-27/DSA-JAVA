class Solution {
    public int kthFactor(int n, int k) {
         ArrayList<Integer> fact = new ArrayList<>();
        for(int i = 1; i*i <= n; i++){
            if(n%i==0){
                if(n/i != i){
                    fact.add(n/i);
                }
                fact.add(i);
            }
        }
        Collections.sort(fact);
        if(fact.size()<k) return -1;
        return fact.get(k-1);
    }
}