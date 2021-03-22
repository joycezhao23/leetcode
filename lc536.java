class Solution {
    public TreeNode str2tree(String s) {
        if (s.length() == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        char[] cs = s.toCharArray();
        int val = 0, mul = 1;
        TreeNode parent = null, child = null;
        for (char c : cs) {
            if (Character.isDigit(c)) {
                val = val * 10 + mul * Character.getNumericValue(c);
            } else if (c == '-') {
                mul = -1;
            } else if (c == '(') {
                if (child != null) {
                    stack.push(child);
                    child = null;
                } else {
                    stack.push(new TreeNode(val));
                    val = 0;
                    mul = 1;    
                }
            } else {
                parent = stack.pop();
                child = child == null ? new TreeNode(val) : child;
                if (parent.left == null) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                child = parent;
                val = 0;
                mul = 1;
            }
        }
        
        return child == null ? new TreeNode(val) : child;
    }
}