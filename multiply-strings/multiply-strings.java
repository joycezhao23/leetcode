class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int carry = 0, n1 = num1.length(), n2 = num2.length(); 
        int[] res = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry + res[n1 - 1 - i + n2 - 1 - j];
                res[n1 - 1 - i + n2 - 1 - j] = num % 10;
                carry = num / 10;
            }
            if (carry > 0) {
                res[n1 - 1 - i + n2] = carry;
                carry = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        int pos = res[n1+n2-1] == 0 ? n1 + n2 - 2 : n1 + n2 - 1;
        while (pos>= 0)
            sb.append(res[pos--]);
        
        return sb.toString();
    }
}