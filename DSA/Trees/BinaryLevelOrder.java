import java.util.ArrayList;
import java.util.List;

//O/P: Binary Tree Level Order Traversal: [[5], [3, 8], [2, 4, 9]]
public class BinaryLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traversal(root, 0, result);
        return result;
    }

    public void traversal (TreeNode node, int depth, List<List<Integer>> result) {
        if(node==null) return;

        if(result.size()==depth)
            result.add(new ArrayList<>());

        result.get(depth).add(node.val);
        traversal(node.left, depth+1, result);
        traversal(node.right, depth+1, result);
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
        BinaryLevelOrder solution = new BinaryLevelOrder();
        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println("Binary Tree Level Order Traversal: " + result);
    }
}
