
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // Sort the asteroids from smallest to largest
        Arrays.sort(asteroids);
        
        // Use a long to prevent integer overflow when adding asteroid masses together
        long currentMass = mass;
        
        for (int asteroid : asteroids) {
            // If the planet's mass is smaller than the asteroid's, the planet is destroyed
            if (currentMass < asteroid) {
                return false;
            }
            // Otherwise, the asteroid is destroyed and the planet gains its mass
            currentMass += asteroid;
        }
        
        return true;
    }
}
