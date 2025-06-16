// @tag:LinkedIn
public class LCAinBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null) {
            if(p.val<root.val && q.val<root.val)
                root=root.left;

            else if(p.val>root.val && q.val>root.val)
                root=root.right;

            else return root;
        }
        return null;
    }

    public static void main(String[] args) {
        // Build the binary tree:
        //         5
        //        / \
        //       3   8
        //      / \   \
        //     2   4   9

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(5);

        // Call the solution
        LCAinBST solution = new LCAinBST();
        TreeNode result = solution.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        System.out.println("Lowest Common Ancestor of a Binary Search Tree: " + result.val);
    }
}
