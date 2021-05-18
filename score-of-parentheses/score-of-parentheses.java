class Solution {
    public int scoreOfParentheses(String s) {
        char[] cs = s.toCharArray();
        Stack<Integer> score = new Stack<Integer>();
        
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                score.push(0);
            } else {
                int countZero = 0, sum = 0;
                while (countZero == 0) {
                    int curr = score.pop();
                    if (curr == 0) countZero++;
                    sum += curr;
                }
                int res = sum == 0 ? 1 : sum * 2;
                score.push(res);
            }
        }
        
        int sol = 0;
        while (!score.isEmpty()) sol += score.pop();
        
        return sol;
    }
}