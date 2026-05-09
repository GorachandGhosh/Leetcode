class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Sort greed factors and cookie sizes
        Arrays.sort(g);
        Arrays.sort(s);
        
        int child = 0; // Pointer for children
        int cookie = 0; // Pointer for cookies

        // Iterate through cookies and children
        while (child < g.length && cookie < s.length) {
            // If the current cookie can satisfy the current child
            if (s[cookie] >= g[child]) {
                child++; // Move to next child
            }
            // Always move to next cookie
            cookie++;
        }
        
        // Number of children satisfied is the value of the child pointer
        return child;
    }
}