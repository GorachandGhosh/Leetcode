class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int i=1, minval=prices[0];

        while(i<prices.length){
            max = Math.max(max, prices[i] - minval);
            i++;
            minval = Math.min(minval, prices[i-1]);
        }
        return max;
    }
}