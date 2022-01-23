class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<Integer>();
        int dlow = getDigits(low), dhigh = getDigits(high);
        for (int i = dlow; i <= dhigh; i++) {
            for (int j = 1; j <= 10 - i; j++) {
                int num = getNum(j, i);
                if (num >= low && num <= high) res.add(num);
            }
        }
        return res;
    }
    
    private int getNum(int start, int digit) {
        int num = 0;
        while(digit-- > 0) {
            num = num * 10 + start++;
        }
        return num;
    }
    
    private int getDigits(int num) {
        int count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        return count;
    }
}