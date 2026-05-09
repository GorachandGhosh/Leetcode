class Solution {
    public int rob(int[] nums) {
        // Base cases: if no houses, return 0
        if (nums == null || nums.length == 0) return 0;
        // If only one house, rob it
        if (nums.length == 1) return nums[0];
        // dp[i] will store the maximum money robbed up to house i
        int[] dp = new int[nums.length];
        
        // Initialize base cases for DP
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        // Fill DP table
        for (int i = 2; i < nums.length; i++) {
            // Formula: max(rob current + prev2, skip current + prev1)
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        
        return dp[nums.length - 1];
    }
}