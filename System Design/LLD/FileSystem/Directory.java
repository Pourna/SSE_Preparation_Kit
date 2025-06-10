import java.util.HashMap;
import java.util.Map;

public class Directory extends Node {
    Map<String, Node> children;

    Directory(String name) {
        this.name = name;
        this.createdAt = System.currentTimeMillis();
        this.children = new HashMap<>();
        this.modifiedAt = this.createdAt;
    }

    @Override
    boolean isDirectory() {
        return true;
    }
}

