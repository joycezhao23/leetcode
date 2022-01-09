class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] dx = {0, 1,0,-1}, dy = {1,0,-1,0};
        int x = 0, y = 0, dir = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                x += dx[dir];
                y += dy[dir];
            } else if (c == 'L') {
                dir = (dir + 3) % 4;
            } else if (c == 'R') {
                dir = (dir + 1) % 4;
            }
        }
        return x == 0 && y == 0 || dir != 0;
    }
}