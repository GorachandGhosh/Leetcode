class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;
        
        // Map to store value as key and all its occurrences (indices) as list values
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        // Start from the first index
        queue.offer(0);
        visited[0] = true;
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int currIdx = queue.poll();
                
                // If we reach the last index
                if (currIdx == n - 1) return steps;
                
                List<Integer> nextIndices = new ArrayList<>();
                if (currIdx + 1 < n) nextIndices.add(currIdx + 1);
                if (currIdx - 1 >= 0) nextIndices.add(currIdx - 1);
                
                if (map.containsKey(arr[currIdx])) {
                    nextIndices.addAll(map.get(arr[currIdx]));
                }
                
                for (int nextIdx : nextIndices) {
                    if (nextIdx >= 0 && nextIdx < n && !visited[nextIdx]) {
                        visited[nextIdx] = true;
                        queue.offer(nextIdx);
                    }
                }
                
                // Optimization: Clear the map list after visiting all same values to prevent TLE
                if (map.containsKey(arr[currIdx])) {
                    map.remove(arr[currIdx]);
                }
            }
            steps++;
        }
        
        return -1;
    }
}
