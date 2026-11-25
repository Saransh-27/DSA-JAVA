class Solution {
    public String intToRoman(int num) {
        int idx = 0;
        int n = num;
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            int rem = n % 10;
            int num1 = rem * (int)Math.pow(10, idx);
            String syb = convert(num1);
            // Add each place value to the beginning
            ans.insert(0, syb);
            n /= 10;
            idx++;
        }

        return ans.toString();
    }

    public String convert(int num) {
        String[] ones = {
            "", "I", "II", "III", "IV",
            "V", "VI", "VII", "VIII", "IX"
        };

        String[] tens = {
            "", "X", "XX", "XXX", "XL",
            "L", "LX", "LXX", "LXXX", "XC"
        };

        String[] hundreds = {
            "", "C", "CC", "CCC", "CD",
            "D", "DC", "DCC", "DCCC", "CM"
        };

        String[] thousands = {
            "", "M", "MM", "MMM"
        };

        if (num < 10) {
            return ones[num];
        } else if (num < 100) {
            return tens[num / 10];
        } else if (num < 1000) {
            return hundreds[num / 100];
        } else {
            return thousands[num / 1000];
        }
    }
}