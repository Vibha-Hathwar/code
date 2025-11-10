```Given an array arr[], where the ith element of arr[] represents the price of a stock on the ith day (all prices are non-negative integers). Find the maximum profit you can make by buying and selling stocks such that after selling a stock, you cannot buy again on the next day (i.e., there is a one-day cooldown).

Examples:
Input: arr[] = [0, 2, 1, 2, 3]
Output: 3
Explanation: You first buy on day 1, sell on day 2 then cool down, then buy on day 4, and sell on day 5. The total profit earned is (2-0) + (3-2) = 3, which is the maximum achievable profit.
Input:  arr[] = [3, 1, 6, 1, 2, 4]
Output: 7
Explanation: You first buy on day 2 and sell on day 3 then cool down, then again you buy on day 5 and then sell on day 6. Clearly, the total profit earned is (6-1) + (4-2) = 7, which is the maximum achievable profit.

Constraint:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 104
```

class Solution:
    def maxProfit(self, prices):
        #code here
        n= len(prices)    #0.11
        if n == 0:
            return 0
        buy, sell, cool = -prices[0], 0, 0
        for i in range(1, n):
            prev_buy, prev_sell, prev_cool = buy, sell, cool
            buy = max(prev_buy, prev_cool - prices[i])
            sell = prev_buy + prices[i]
            cool = max(prev_cool, prev_sell)
        return max(sell, cool)
