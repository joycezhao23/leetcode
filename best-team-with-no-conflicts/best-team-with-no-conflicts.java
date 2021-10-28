class Solution {
    class Pair {
        int score, age;
        public Pair(int score, int age) {
            this.score = score;
            this.age = age;
        }
    }
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length, res = 0;
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++)
            arr[i] = new Pair(scores[i], ages[i]);
        Arrays.sort(arr, (a, b) -> a.age == b.age ? a.score - b.score : a.age - b.age);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i].score;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j].score > arr[i].score) continue;
                dp[i] = Math.max(dp[i], dp[j] + arr[i].score);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}