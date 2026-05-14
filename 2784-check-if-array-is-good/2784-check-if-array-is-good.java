import java.util.Arrays;

class Solution {
    public boolean isGood(int[] nums) {
        // Sort the array to easily check the permutation structure
        Arrays.sort(nums);
        
        int n = nums.length - 1;
        
        // Base[n] has length n+1. For nums to be good, it must match this length.
        // For Example 1: nums=[2,1,3], len=3. n=2. base[2]=[1,2,2]. False.
        if (nums.length < 2) return false;

        // Check if the first n elements are 1, 2, ..., n-1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }
        
        // Check if the last two elements are n, n
        return nums[n] == n && nums[n-1] == n;
    }
}
