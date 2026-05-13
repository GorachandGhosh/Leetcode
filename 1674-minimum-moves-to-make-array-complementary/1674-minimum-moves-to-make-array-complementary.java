class Solution {
    public int minMoves(int[] nums, int limit) {
        // diff[i] stores the change in moves required if the target sum is i
        int[] diff = new int[2 * limit + 2];
        int n = nums.length;

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            // Default: 2 moves for every pair
            diff[2] += 2;
            diff[2 * limit + 1] -= 2;

            // Range for 1 move: [min(a, b) + 1, max(a, b) + limit]
            // We subtract 1 move from the "2 moves" default in this range
            int minSum1Move = Math.min(a, b) + 1;
            int maxSum1Move = Math.max(a, b) + limit;
            diff[minSum1Move] -= 1;
            diff[maxSum1Move + 1] += 1;

            // Range for 0 moves: exactly a + b
            // We subtract 1 move from the "1 move" result for this specific sum
            int targetSum = a + b;
            diff[targetSum] -= 1;
            diff[targetSum + 1] += 1;
        }

        int minMoves = n; // Maximum possible moves is n
        int currentMoves = 0;
        // Sweep through the difference array to find the minimum
        for (int sum = 2; sum <= 2 * limit; sum++) {
            currentMoves += diff[sum];
            minMoves = Math.min(minMoves, currentMoves);
        }

        return minMoves;
    }
}
