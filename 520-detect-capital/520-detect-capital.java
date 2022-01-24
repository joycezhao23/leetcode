class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) count++;
        }
        return count == 0 || (Character.isUpperCase(word.charAt(0)) && count == 1) || count == word.length();
    }
}