package com.leetcode.Companies.GoldmanSachs;

public class StringToInteger {
    /**
     * Integer.MAX_VALUE = 2147483647
     * Integer.MAX_VALUE/10 = 2147483640
     * Integer.MAX_VALUE % 10 = 7
     * <p>
     * base > Integer.MAX_VALUE / 10 i.e. base>2147483640 (Ex: if base = 2147483641 ,
     * then when multiplied by 10,It would lead to overflow)
     * base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7
     * EX: Then base = 2147483640 + (Any addition greater than 7 would lead to integer overflow)
     **/

    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;

        int base = 0;
        int i = 0;
        char[] str = s.toCharArray();
        while (i < str.length && str[i] == ' ') i++;
        int sign = 1;
        if (i < str.length && (str[i] == '-' || str[i] == '+'))
            sign = str[i++] == '-' ? -1 : 1;

        while (i < str.length && str[i] >= '0' && str[i] <= '9') {
            //check for overflow
            if (base > Integer.MAX_VALUE / 10 || base == Integer.MAX_VALUE / 10 && (str[i] - '0') > 7)
                return sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            base = base * 10 + (str[i++] - '0');
        }
        return base * sign;
    }

}
