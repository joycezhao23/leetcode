class Solution {
    int pos = 0, l = 0;
    char[] cs;
    
    public class Pair {
        TreeNode node;
        int d;
        Pair(int d, TreeNode node) {
            this.node = node;
            this.d = d;
        }
    }
    
    public TreeNode recoverFromPreorder(String S) {
        l = S.length();
        if (S == null || l == 0) return null;
        cs = S.toCharArray();
        Stack<Pair> stack = new Stack<Pair>();
        TreeNode root = new TreeNode(getNum());
        stack.push(new Pair(0, root));
        
        while (pos < l) {
            int depth = getD();
            TreeNode curr = new TreeNode(getNum());
            while(depth <= stack.peek().d) {
                stack.pop();
            }
            if (stack.peek().node.left == null) {
                stack.peek().node.left = curr;
            } else {
                stack.peek().node.right = curr;
            }
            stack.push(new Pair(depth, curr));
        }
        
        return root;
    }
    
    private int getNum() {
        int num = 0;
        while (pos < l && cs[pos] != '-') num = num * 10 + cs[pos++] - '0';
        return num;
    }
    
    private int getD() {
        int count = 0;
        while (cs[pos] == '-') {
            count++;
            pos++;
        }
        return count;
    }
}