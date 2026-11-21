class Solution {
    public int[] sortByBits(int[] arr) {
        int[] bits = new int[arr.length];
        for(int i =0; i < arr.length; i++){
            int curr = arr[i];
            int currBits = 0;
            while(curr > 0){
                currBits++;
                curr = curr & (curr-1);
            }
            bits[i] = currBits;
        }
        boolean swapped;
        for (int j = 0; j < arr.length; j++) {
            swapped = false;
            for (int i =0; i < arr.length - 1 -j; i++) {
                if (bits[i] > bits[i + 1] || (bits[i] == bits[i + 1] && arr[i] > arr[i + 1])) {

                    // Swap bits
                    int temp = bits[i];
                    bits[i] = bits[i + 1];
                    bits[i + 1] = temp;

                    // Swap original numbers
                    int temp2 = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp2;

                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return arr;
    }
}