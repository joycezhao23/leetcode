class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] count = new int[128];
        Set<Character> set = new HashSet<Character>();
        int l = 0, res = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            count[cs[i]]++;
            set.add(cs[i]);
            while (set.size() > 2) {
                count[cs[l]]--;
                if (count[cs[l]] == 0) 
                    set.remove(cs[l]);
                l++;
            }
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}