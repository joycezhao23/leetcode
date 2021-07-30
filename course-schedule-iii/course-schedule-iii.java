class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int day = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < courses.length; i++) {
            day += courses[i][0];
            pq.add(courses[i][0]);
            if (day > courses[i][1]) day -= pq.poll();
        }
        return pq.size();
    }
}