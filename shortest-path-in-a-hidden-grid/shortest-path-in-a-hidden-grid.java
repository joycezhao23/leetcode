/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 *     boolean canMove(char direction);
 *     void move(char direction);
 *     boolean isTarget();
 * }
 */

class Solution {
    public int findShortestPath(GridMaster master) {
        int[][] grid = new int[1000][1000];
        grid[500][500] = START;
        int[] target = buildGrid(master, grid, 500, 500);
        return target == null ? -1 : getStep(target, 500, 500, grid);
    }
    
    int START = -1, BLOCK = 3, EMPTY = 1, TARGET = 2;
    char[] direction = new char[]{'U','L','D','R'};
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, -1, 0, 1};
    
    private int getStep(int[] start, int x, int y, int[][] grid) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(start);
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int xx = cur[0] + dx[i], yy = cur[1] + dy[i];
                    if (xx == x && yy == y) return step;
                    if (grid[xx][yy] == EMPTY) {
                        grid[xx][yy] = BLOCK;
                        q.add(new int[]{xx, yy});
                    }
                }
            }
            step++;
        }
        return -1;
    }
    
    private int[] buildGrid(GridMaster master, int[][] grid, int xx, int yy) {
        if (master.isTarget()) {
            grid[xx][yy] = TARGET;
            return new int[]{xx, yy};
        }
        
        int[] res = null;
        for (int i = 0; i < 4; i++) {
            int x = xx + dx[i], y = yy + dy[i];
            if (grid[x][y] != 0) continue;
            if (!master.canMove(direction[i])) {
                grid[x][y] = BLOCK;
            } else {
                grid[x][y] = EMPTY;
                master.move(direction[i]);
                int[] pos = buildGrid(master, grid, x, y);
                if (pos != null) res = pos;
                master.move(direction[(i + 2) % 4]);
            }
        }
        return res;
    }
}