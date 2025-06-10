/*
* We have an undirected, connected graph of n houses labeled 0…n–1.
* A subset of these houses, given by solarPanels, already have power and incur cost 0.
* Every other house must “pull” electricity along the wires (each wire = unit distance) to its nearest solar‐powered house.
* Return an array dist[0…n-1] where dist[i] is the shortest path length from house i to any house in solarPanels
* (or 0 if i is itself in solarPanels)
*
* Time: O(N + E), where N = number of nodes, E = number of edges.
* Space: O(N + E) for graph and queue.
* */

import java.util.*;

public class SolarPanelsDistance {

    public static int[] minDistance(int n, int[][] edges, List<Integer> solarPanels) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        for(int solar : solarPanels) {
            dist[solar]=0;
            q.offer(solar);
        }

        while(!q.isEmpty()) {
            int current = q.poll();
            for(int i: graph.get(current)) {
                if(dist[i]==-1) {
                    dist[i] = dist[current]+1;
                    q.offer(i);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2}, {2,3}, {3,4}, {4,5}};
        List<Integer> solarPanels=new ArrayList<>();
        solarPanels.add(0);
        solarPanels.add(5);
        int[] result = minDistance(6, edges, solarPanels);
        System.out.println("Minimum distance for each house to get solarPanel is:"+ Arrays.toString(result));
    }
}
