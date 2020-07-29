/*

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]

*/

class Solution {
    public int maxProfit(int[] prices) {
        
        
        if(prices == null || prices.length<=1) {
            return 0;
        }
        
       int buyProfit[] = new int[prices.length];
        int sellProfit[] = new int[prices.length];
        
        buyProfit[0] = -prices[0];
        sellProfit[0] = 0;
        
        buyProfit[1] = Math.max(buyProfit[0],-prices[1]);
        
        sellProfit[1] = Math.max(sellProfit[0],buyProfit[0]+prices[1]);
        
        for(int i=2;i<prices.length;i++) {
            buyProfit[i] = Math.max(buyProfit[i-1],sellProfit[i-2]-prices[i]);
            sellProfit[i] = Math.max(sellProfit[i-1],buyProfit[i-1]+prices[i]);
        }
        
        return sellProfit[prices.length-1];
        
    }
}
