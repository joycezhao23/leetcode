class Solution {
    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        List<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < indexes.length; i++) list.add(new int[]{indexes[i], i});
        Collections.sort(list, (a, b) -> b[0] - a[0]);
        StringBuilder sb = new StringBuilder(s);
        for (int[] index : list) {
            if (s.substring(index[0]).startsWith(sources[index[1]])) {
                sb.replace(index[0], index[0] + sources[index[1]].length(), targets[index[1]]);
            }
        }
        return sb.toString();
    }
}