class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int wl = words.length, pl = puzzles.length;
        int[] w = new int[wl], p = new int[pl];
        for (int i = 0; i < wl; i++)
            w[i] = helper(words[i]);
        for (int i = 0; i < pl; i++)
            p[i] = helper(puzzles[i]);
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < pl; i++) {
            int count = 0, maskFirst = (1 << puzzles[i].charAt(0) - 'a'), mask = p[i];
            for (int j = 0; j < wl; j++) {
                if ((w[j] & maskFirst) > 0 && (w[j] & mask) == w[j])
                    count++;
            }
            res.add(count);
        }
        return res;
    }
    
    private int helper(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res |= (1 << (s.charAt(i) - 'a'));
        }
        return res;
    }
}