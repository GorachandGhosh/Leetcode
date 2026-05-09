
class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int layers = Math.min(m, n) / 2;

        for (int i = 0; i < layers; i++) {
            // 1. Extract the current layer (ring)
            List<Integer> layer = new ArrayList<>();
            // Top row
            for (int j = i; j < n - i; j++) layer.add(grid[i][j]);
            // Right col
            for (int j = i + 1; j < m - i - 1; j++) layer.add(grid[j][n - i - 1]);
            // Bottom row
            for (int j = n - i - 1; j > i; j--) layer.add(grid[m - i - 1][j]);
            // Left col
            for (int j = m - i - 1; j > i; j--) layer.add(grid[j][i]);

            // 2. Perform cyclic rotation on the extracted layer
            int len = layer.size();
            int rot = k % len;
            Collections.rotate(layer, -rot); // Negative for counter-clockwise

            // 3. Put elements back into the grid
            int idx = 0;
            // Top row
            for (int j = i; j < n - i; j++) grid[i][j] = layer.get(idx++);
            // Right col
            for (int j = i + 1; j < m - i - 1; j++) grid[j][n - i - 1] = layer.get(idx++);
            // Bottom row
            for (int j = n - i - 1; j > i; j--) grid[m - i - 1][j] = layer.get(idx++);
            // Left col
            for (int j = m - i - 1; j > i; j--) grid[j][i] = layer.get(idx++);
        }
        return grid;
    }
}