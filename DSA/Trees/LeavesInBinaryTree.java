// @tag:LinkedIn
import java.util.ArrayList;
import java.util.List;

public class LeavesInBinaryTree {

    public List<List<Integer>> findLeaves (TreeNode root) {
        if(root==null) return null;
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    public int dfs(TreeNode node, List<List<Integer>> result) {
        if(node==null) return -1;

        int leftHeight = dfs(node.left, result);
        int rightHeight = dfs(node.right, result);

        int currHeight = 1 + Math.max(leftHeight, rightHeight);

        if(result.size()==currHeight) {
            result.add(new ArrayList<>());
        }

        result.get(currHeight).add(node.val);
        return currHeight;
    }

    public static void main(String[] args) {
        // Build the binary tree:
        //          1
        //        /   \
        //       4     3
        //      / \   / \
        //     2   4 2   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);

        // Call the solution
        LeavesInBinaryTree solution = new LeavesInBinaryTree();
        List<List<Integer>> result = solution.findLeaves(root);
        System.out.println("Leaves in Binary Tree: " + result);
    }
}
