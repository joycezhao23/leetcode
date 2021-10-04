class Solution {
    public String getHint(String secret, String guess) {
        int[][] c = new int[10][2];
        int counta = 0, countb = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {  
                counta++;
            } else {
                c[secret.charAt(i) - '0'][0]++;    
                c[guess.charAt(i) - '0'][1]++;    
            }
        }
        for (int i = 0; i < 10; i++) {
            countb += Math.min(c[i][0], c[i][1]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(counta);
        sb.append('A');
        sb.append(countb);
        sb.append('B');
        return sb.toString();
    }
}