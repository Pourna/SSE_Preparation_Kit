public class MaxDepthBT {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


    public static void main(String[] args) {
        // Build the binary tree:
        //         5
        //        / \
        //       3   8
        //      / \   \
        //     2   4   9

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(9);

        // Call the solution
        MaxDepthBT solution = new MaxDepthBT();
        int maxSumBST = solution.maxDepth(root);
        System.out.println("Maximum Sum BST in Binary Tree: " + maxSumBST);
    }
}