import java.util.Arrays;

class Solution {
    public int minimumEffort(int[][] tasks) {
        // Sort tasks based on the difference (minimum - actual) in descending order.
        // This ensures tasks with high requirements are handled when we have more energy accumulated.
        // Alternatively: Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        
        int initialEnergy = 0;
        int currentEnergy = 0;
        
        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];
            
            // If current energy is less than required, add the difference to the total
            if (currentEnergy < minimum) {
                initialEnergy += (minimum - currentEnergy);
                currentEnergy = minimum;
            }
            
            // Perform the task
            currentEnergy -= actual;
        }
        
        return initialEnergy;
    }
}
