import java.util.ArrayList;
import java.util.List;


//O/P: Binary Tree Level Order Traversal: [[5], [8, 3], [2, 4, 9]]
public class BinaryZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traversal(root, 0, result);
        return result;
    }

    public void traversal(TreeNode node, int depth, List<List<Integer>> result) {
        if(node==null) return;

        if(depth==result.size())
            result.add(new ArrayList<>());

        if(depth%2==0) {
            result.get(depth).add(node.val);
        } else {
            result.get(depth).add(0,node.val);
        }

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
        BinaryZigZagTraversal solution = new BinaryZigZagTraversal();
        List<List<Integer>> result = solution.zigzagLevelOrder(root);
        System.out.println("Binary Tree Level Order Traversal: " + result);
    }
}
