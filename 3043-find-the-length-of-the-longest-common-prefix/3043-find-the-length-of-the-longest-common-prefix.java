
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes = new HashSet<>();
        
        // Step 1: Add all possible prefixes of each number in arr1 to the set
        for (int num : arr1) {
            while (num > 0) {
                prefixes.add(num);
                num /= 10; // Remove the last digit to get the shorter prefix
            }
        }
        
        int maxLength = 0;
        
        // Step 2: Check all possible prefixes of each number in arr2
        for (int num : arr2) {
            while (num > 0) {
                if (prefixes.contains(num)) {
                    // Step 3: If found, calculate length and update max
                    int currentLength = String.valueOf(num).length();
                    maxLength = Math.max(maxLength, currentLength);
                    
                    // Since we are looking for the longest, and we're dividing num 
                    // by 10 in each loop, the first hit for a specific num 
                    // is its longest match. We can break to check the next arr2 element.
                    break; 
                }
                num /= 10;
            }
        }
        
        return maxLength;
    }
}
