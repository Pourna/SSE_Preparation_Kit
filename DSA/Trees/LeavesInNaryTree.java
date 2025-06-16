import java.util.ArrayList;
import java.util.List;

// @tag:LinkedIn
public class LeavesInNaryTree {

    public List<List<Integer>> findLeaves (NaryNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    public int dfs(NaryNode node, List<List<Integer>> result) {
        if(node==null) return -1;

        int maxChildHeight = -1;
        for(NaryNode child : node.children) {
            maxChildHeight = Math.max(maxChildHeight, dfs(child, result));
        }

        int currHeight = maxChildHeight + 1;
        if(result.size()<=currHeight) {
            result.add(new ArrayList<>());
        }

        result.get(currHeight).add(node.val);
        return currHeight;
    }

    public static void main(String[] args) {
        // Tree:
        //         1
        //       / | \
        //      2  3  4
        //     /      \
        //    5        6
        NaryNode root = new NaryNode(1);
        NaryNode n2 = new NaryNode(2);
        NaryNode n3 = new NaryNode(3);
        NaryNode n4 = new NaryNode(4);
        NaryNode n5 = new NaryNode(5);
        NaryNode n6 = new NaryNode(6);

        n2.children.add(n5);
        n4.children.add(n6);
        root.children.add(n2);
        root.children.add(n3);
        root.children.add(n4);

        LeavesInNaryTree solver = new LeavesInNaryTree();
        List<List<Integer>> leavesByLevel = solver.findLeaves(root);
        System.out.println(leavesByLevel); // Output: [[5, 3, 6], [2, 4], [1]]
    }
}
