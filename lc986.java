class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) return new int[0][0];
        
        List<int[]> list = new ArrayList<int[]>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            if (start <= end) {
                int[] itv = {start, end};
                list.add(itv);
            }
            
            if (end == firstList[i][1]) i++;
            if (end == secondList[j][1]) j++;
        }
        
        return list.toArray(new int[0][2]);
    }
}