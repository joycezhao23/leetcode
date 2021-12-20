/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int last = 1;
        while (true) {
            if (reader.get(last) < target) {
                last *= 2;
            } else if (reader.get(last) == target) {
                return last;
            } else {
                break;
            }
        }
        int start = last / 2, end = last;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (reader.get(start) == target) return start;
        return reader.get(end) == target ? end : -1;
    }
}