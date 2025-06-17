/*The "Shortest distance between LinkedIn connections" is a classic graph traversal problem — often framed as finding the shortest path between two nodes in an undirected graph, where each person (user) is a node and each connection (friendship) is an edge.

🧩 Problem Statement
Given:

A graph of users representing LinkedIn-style connections.

Two users: source and target.

Return:

The minimum number of connections (degrees of separation) between source and target.

The actual path (list of users) from source to target.


✅ Optimal Approach: BFS (Breadth-First Search)
Since the graph is unweighted, use BFS to find the shortest path.


💡 Time and Space Complexity

Time Complexity	O(V + E)
Space Complexity	O(V) for visited, queue, parent


*
* */

import java.util.*;

public class ShortestPath {

    public List<String> shortestPath (Map<String, List<String>> graph, String source, String target) {
        if(source.equals(target)) return List.of(source);

        LinkedList<String> queue = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();
        HashSet<String> visited = new HashSet<>();

        queue.offer(source);
        visited.add(source);
        parent.put(source, null);

        while(!queue.isEmpty()) {
            String curr = queue.poll();
            for(String neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, curr);
                    queue.offer(neighbor);

                    if(neighbor.equals(target)) {
                        return buildPath(parent, target);
                    }
                }
            }
        }

        return List.of();
    }

    public List<String> buildPath(Map<String, String> parent, String target) {
        LinkedList<String> path = new LinkedList<>();
        while(target!=null) {
            path.addFirst(target);
            target = parent.get(target);
        }
        return path;
    }

    //Connections (Edges):
    //A - B
    //B - C
    //A - D
    //C - E
    //E - F
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", List.of("B", "D"));
        graph.put("B", List.of("A", "C"));
        graph.put("C", List.of("B", "E"));
        graph.put("D", List.of("A"));
        graph.put("E", List.of("F", "C"));
        graph.put("F", List.of("E"));

        ShortestPath sol = new ShortestPath();
        List<String> result = sol.shortestPath(graph, "A", "F");
        System.out.println("The Shortest Path between A and F is "+result+" and the distance is: "+(result.size()-1));
    }
}
