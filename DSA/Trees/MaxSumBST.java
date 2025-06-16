// @tag:LinkedIn
public class MaxSumBST {

    int maxSum=0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    public int[] dfs(TreeNode node) {
        if(node==null)
            return new int[] {1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        if(left[0]==1 && right[0]==1 && left[2]<node.val && node.val<right[1]) {
            int sum = left[3] + right[3] + node.val;
            maxSum = Math.max(maxSum, sum);

            int min = Math.min(left[1], node.val);
            int max = Math.max(right[2], node.val);
            return new int[]{1, min, max, sum};
        } else {
            return new int[]{0,0,0,0};
        }
    }

    public static void main(String[] args) {
        // Build the binary tree:
        //         5
        //        / \
        //       3   8
        //      / \   \
        //     2   4   9

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);

        // Call the solution
        MaxSumBST solution = new MaxSumBST();
        int result = solution.maxSumBST(root);
        System.out.println("Maximum Sum BST in Binary Tree: " + result);
    }
}
