We have an undirected, connected graph of n houses labeled 0…n–1. 
A subset of these houses, given by solarPanels, already have power and incur cost 0. 
Every other house must “pull” electricity along the wires (each wire = unit distance) to its nearest solar‐powered house. 
Return an array dist[0…n-1] where dist[i] is the shortest path length from house i to any house in solarPanels (or 0 if i is itself in solarPanels)

✅ Problem Summary 
Graph type: Undirected, unweighted. 

Input: n nodes labeled from 0 to n-1. 

edges: list of connections between houses. 

solarPanels: list of nodes (houses) that already have power. 

Output: dist[i] = shortest distance from node i to any of the solar-powered nodes.

✅ Key Insight 

Use Breadth-First Search (BFS) starting from all solar-powered houses simultaneously (multi-source BFS).

✅ BFS Approach

Build the graph using an adjacency list.

Initialize dist[] as -1 or Infinity, set to 0 for all nodes in solarPanels.

Push all solar-powered nodes into a queue.

Perform BFS: at each step, update the neighbor’s distance as dist[current] + 1 if not already visited

✅ Time & Space Complexity 

Time: O(N + E), where N = number of nodes, E = number of edges.

Space: O(N + E) for graph and queue.

