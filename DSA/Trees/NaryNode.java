// @tag:LinkedIn
import java.util.ArrayList;
import java.util.List;

public class NaryNode {
    int val;
    List<NaryNode> children;

    NaryNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}
