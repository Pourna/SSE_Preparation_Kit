// @tag:LinkedIn
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if ( p!=null && q!=null && p.val==q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else
            return false;
    }

    public static void main(String[] args) {
        // Build the binary tree:
        //         1
        //        / \
        //       2   3

        TreeNode root1= new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        // Call the solution
        SameTree solution = new SameTree();
        boolean isSame = solution.isSameTree(root1, root2);
        System.out.println("The given two trees match result is : " + isSame);
    }
}
