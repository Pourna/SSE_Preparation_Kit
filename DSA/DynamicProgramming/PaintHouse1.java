/*
* 🔍 Problem Statement
You are given a row of n houses, each to be painted with one of three colors: red, blue, or green.

The cost of painting each house with a certain color is given in a costs matrix:

java
Copy
Edit
costs[i][j] = cost of painting house i with color j
where j = 0 (red), 1 (blue), 2 (green).

No two adjacent houses can have the same color.

* ⏱️ Time & Space Complexity
Time: O(n)

Space: O(1) (in-place DP update)
*/
public class PaintHouse1 {

    public int minCost (int[][] costs) {
        if(costs.length==0) return 0;

        int n = costs.length;
        for(int i = 1; i<n; i++) {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(costs[n-1][0], Math.min(costs[n-1][1], costs[n-1][2]));
    }

    public static void main(String[] args) {
        PaintHouse1 sol = new PaintHouse1();
        int[][] costs = {{17,2,17}, {16,16,5}, {14,3,19}};
        System.out.println("The minimum cost to paint the houses is:" +sol.minCost(costs));
    }
}
