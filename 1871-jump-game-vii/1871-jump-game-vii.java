class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        
        int reachableCount = 0;
        
        for (int i = 1; i < n; i++) {
            if (i >= minJump) {
                // Add the reachability status of index (i - minJump) to our window
                if (dp[i - minJump]) {
                    reachableCount++;
                }
            }
            
            if (i > maxJump) {
                // Remove the reachability status of index (i - maxJump - 1) from our window
                if (dp[i - maxJump - 1]) {
                    reachableCount--;
                }
            }
            
            // The current index is reachable if the character is '0' and 
            // there is at least one reachable position in the valid jump window
            if (s.charAt(i) == '0' && reachableCount > 0) {
                dp[i] = true;
            }
        }
        
        return dp[n - 1];
    }
}
