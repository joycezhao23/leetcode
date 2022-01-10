class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int aa = i >= 0 ? a.charAt(i) - '0' : 0, bb = j >= 0 ? b.charAt(j) - '0' : 0;
            int total = carry + aa + bb;
            sb.append(total % 2);
            carry = total / 2;
            i--;
            j--;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}