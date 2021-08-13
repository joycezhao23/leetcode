class Solution {
    public int minNumberOfFrogs(String s) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        String c = "croak";
        for (int i = 0; i < s.length(); i++) {
            int idx = c.indexOf(s.charAt(i));
            if (!map.containsKey(idx)) {
                if (idx != 0) return -1;
                map.put(1, map.getOrDefault(1, 0) + 1);
            } else {
                map.put((idx + 1) % 5, map.getOrDefault((idx + 1) % 5, 0) + 1);
                if (map.get(idx) == 1) {
                    map.remove(idx);
                } else {
                    map.put(idx, map.get(idx) - 1);
                }
            }
        }
        if (map.size() > 1) return -1;
        return map.getOrDefault(0, -1);
    }
}