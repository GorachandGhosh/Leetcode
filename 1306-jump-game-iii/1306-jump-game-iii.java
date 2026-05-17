import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            // Check if we reached the target index with value 0
            if (arr[curr] == 0) {
                return true;
            }
            
            // Calculate possible next moves
            int[] nextIndices = new int[]{curr + arr[curr], curr - arr[curr]};
            
            for (int next : nextIndices) {
                // Check bounds and if the index has been visited
                if (next >= 0 && next < n && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        
        return false;
    }
}
