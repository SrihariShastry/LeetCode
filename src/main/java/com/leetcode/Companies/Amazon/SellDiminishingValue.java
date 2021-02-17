package com.leetcode.Companies.Amazon;

import java.util.Arrays;

/*https://leetcode.com/problems/sell-diminishing-valued-colored-balls/discuss/927509/Java-O(NlogN)-or-Detailed-Explanation-or-Runtime-Beats-100*/
public class SellDiminishingValue {

    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        long ans = 0;
        long count = 1;
        int n = inventory.length - 1;
        while (orders > 0) {

            if (n > 0 && inventory[n] > inventory[n - 1]
                    && orders >= count * (inventory[n] - inventory[n - 1])) {
                ans += count * sum(inventory[n], inventory[n - 1]);
                orders -= count * (inventory[n] - inventory[n - 1]);
            } else if (n == 0 || inventory[n] > inventory[n - 1]) {

                //if n == 0 and there are many orders that have to be fulfilled
                //or if number of orders are < count * distance bw two prices
                long a = orders / count;
                ans += count * sum(inventory[n], inventory[n] - a);

                long b = orders % count;
                ans += b * (inventory[n] - a);
                orders = 0;
            }

            ans %= 1000000007;
            count++;
            n--;
        }
        return (int) ans;
    }

    public long sum(long x, long y) {
        return (x * (x + 1)) / 2 - (y * (y + 1)) / 2;
    }
}
