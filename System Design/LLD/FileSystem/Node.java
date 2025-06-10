import java.util.HashMap;
import java.util.Map;

public abstract class Node {
    String name;
    long createdAt;
    long modifiedAt;
    Directory parent;

    abstract boolean isDirectory();
}

