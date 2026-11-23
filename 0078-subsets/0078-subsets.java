class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subset(new ArrayList<>(), nums, 0);
    }

    public List<List<Integer>> subset(List<Integer> p, int[] up, int start) {
        if (start == up.length) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int elm = up[start];
        List<List<Integer>> left = subset(p, up, start + 1);
        List<Integer> newP = new ArrayList<>(p);
        newP.add(elm);
        List<List<Integer>> right = subset(newP, up, start + 1);
        left.addAll(right);
        return left;
    }
}