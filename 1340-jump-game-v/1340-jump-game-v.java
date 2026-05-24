class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] memo = new int[n];
        int maxJumps = 1;

        for (int i = 0; i < n; i++) {
            maxJumps = Math.max(maxJumps, dfs(arr, d, i, memo));
        }

        return maxJumps;
    }

    private int dfs(int[] arr, int d, int i, int[] memo) {
        if (memo[i] != 0) {
            return memo[i];
        }

        int maxVisits = 1;

        // Jump left
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
            if (arr[j] >= arr[i]) {
                break; // Cannot jump over an element that is >= current element
            }
            maxVisits = Math.max(maxVisits, 1 + dfs(arr, d, j, memo));
        }

        // Jump right
        for (int j = i + 1; j <= Math.min(arr.length - 1, i + d); j++) {
            if (arr[j] >= arr[i]) {
                break; // Cannot jump over an element that is >= current element
            }
            maxVisits = Math.max(maxVisits, 1 + dfs(arr, d, j, memo));
        }

        memo[i] = maxVisits;
        return maxVisits;
    }
}
