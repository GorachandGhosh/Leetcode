class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                // Minimum is in the left part
                right = mid;
            } else if (nums[mid] > nums[right]) {
                // Minimum is in the right part
                left = mid + 1;
            } else {
                // Equality: shrink the boundary to handle duplicates
                right--;
            }
        }
        return nums[left];
    }
}
