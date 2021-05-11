class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<String> pq = new PriorityQueue<String>((a, b) -> compareString(a, b));
        for (int num : nums) {
            pq.add(String.valueOf(num));
        }
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
    
    private int compareString(String a, String b) {
        if (a.length() > b.length()) {
            return -1 * compareString(b, a);
        }
        char[] aa = a.toCharArray(), bb = b.toCharArray();
        int n = aa.length, j = 0, m = bb.length;
        while (j < 2 * m) {
            if (aa[j % n] != bb[j % m]) {
                return bb[j % m] - aa[j % n];
            }
            j++;
        }
        return 0;
    }
}