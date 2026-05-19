class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0; // Pointer for nums1
        int j = 0; // Pointer for nums2
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                // Since they are sorted, the first match we find is the minimum
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                // nums1[i] is too small, move to the next element in nums1
                i++;
            } else {
                // nums2[j] is too small, move to the next element in nums2
                j++;
            }
        }
        
        // No common element found
        return -1;
    }
}
