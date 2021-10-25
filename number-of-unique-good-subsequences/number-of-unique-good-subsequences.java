class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int hasZero = 0, MOD = 1000000007;
        long ends0 = 0, ends1 = 0;
        for (char c : binary.toCharArray()) {
            if (c == '0') {
                ends0 = (ends0 + ends1) % MOD;
                hasZero = 1;
            } else {
                ends1 = (ends0 + ends1 + 1) % MOD;
            }
        }
        return (int)((ends0 + ends1 + hasZero) % MOD);
    }
}