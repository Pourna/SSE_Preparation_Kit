// @tag:LinkedIn
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MaxStack {

    static class Node {
        int val;
        Node prev, next;

        Node(int x) {
            this.val=x;
        }
    }

    Node head, tail;
    TreeMap<Integer, List<Node>> map;

    MaxStack() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        map = new TreeMap<>();
    }

    void push(int x) {
        Node node = new Node(x);
        addToTail(node);
        map.computeIfAbsent(x, k-> new ArrayList<>()).add(node);
    }

    void addToTail(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }

    int pop() {
        Node node = tail.prev;
        remove(node);
        removeFromMap(node);
        return node.val;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void removeFromMap(Node node) {
        List<Node> nodes = map.get(node.val);
        nodes.remove(nodes.size()-1);
        if(nodes.isEmpty())
            map.remove(node.val);
    }

    int top() {
        return tail.prev.val;
    }

    int peekMax() {
        return map.lastKey();
    }

    int popMax() {
        int max = map.lastKey();
        List<Node> nodes = map.get(max);
        Node node = nodes.remove(nodes.size()-1);
        if(nodes.isEmpty()) map.remove(max);
        remove(node);
        return node.val;
    }

    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        System.out.println(stack.top());        // should return 5
        System.out.println(stack.popMax());     // should remove and return 5 (top-most one)
        System.out.println(stack.top());        // should return 1
        System.out.println(stack.peekMax());    // should return 5
        System.out.println(stack.pop());        // should remove and return 1
        System.out.println(stack.top());        // should return 5
    }
}
