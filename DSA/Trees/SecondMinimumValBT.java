// @tag:LinkedIn
public class SecondMinimumValBT {

    public int findSecondMinimumValue(TreeNode root) {
        return traverse(root, root.val);
    }

    public int traverse(TreeNode node, int minVal) {
        if(node==null) return -1;

        if(node.val>minVal) return node.val;
        int left = traverse(node.left, minVal);
        int right = traverse(node.right, minVal);

        if(left==-1) return right;
        if(right==-1) return left;
        return Math.min(left, right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        // Call the solution
        SecondMinimumValBT solution = new SecondMinimumValBT();
        int result = solution.findSecondMinimumValue(root);
        System.out.println("Second Minimum Node In a Binary Tree: " + result);
    }
}
