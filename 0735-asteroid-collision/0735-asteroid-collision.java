class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int ast : asteroids) {
            boolean destroyed = false;
            // Collision happens only if positive moves right and negative moves left
            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                if (Math.abs(ast) > stack.peek()) {
                    stack.pop(); // Existing positive asteroid explodes
                    continue;
                } else if (Math.abs(ast) == stack.peek()) {
                    stack.pop(); // Both explode
                }
                destroyed = true;
                break;
            }
            
            if (!destroyed) {
                stack.push(ast);
            }
        }
        
        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}