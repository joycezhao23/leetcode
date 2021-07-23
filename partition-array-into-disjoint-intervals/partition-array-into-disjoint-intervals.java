class Solution {
    public int partitionDisjoint(int[] A) {
        int aLength = 1;
        int aMax = A[0];
        int maxEncountered = 0;

        for (int i = 0; i < A.length; i++) {
            maxEncountered = Math.max(maxEncountered, A[i]);

            if (A[i] < aMax) {
                aMax = maxEncountered;
                aLength = i + 1;
            }
        }

        return aLength;
    }
}