class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals based on start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();

        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            // If overlapping
            if (nextStart <= currentEnd) {
                currentEnd = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap → add previous interval
                merged.add(new int[] { currentStart, currentEnd });
                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }

        // Add last interval
        merged.add(new int[] { currentStart, currentEnd });

        return merged.toArray(new int[merged.size()][]);
    }
}