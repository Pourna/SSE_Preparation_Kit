/*
* 🧩 LeetCode 265. Paint House II
🔗 https://leetcode.com/problems/paint-house-ii/

🔍 Problem Statement
You are given an n x k integer matrix costs, where costs[i][j] is the cost of painting the ith house with the jth color.

You need to paint all houses such that no two adjacent houses have the same color.

Return the minimum total cost.
*
*(O(n × k) Time, O(k) Space)
* Time Complexity: O(n × k)
* Space Complexity: O(k)
* */
import java.util.Arrays;

public class PaintHouse2 {

    public int minCost(int[][] costs) {
        if(costs==null || costs.length == 0)
            return 0;
        int n=costs.length;
        int k=costs[0].length;

        //copy first row to prevRow
        int[] prevRow = Arrays.copyOfRange(costs[0], 0, k);

        for(int i=1; i<n; i++) {
            int[] currRow = new int[k];
            int min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE, min1Index=-1;

            //Identify min1, min2, and min1Index
            for(int j=0; j<k; j++) {
                if(prevRow[j]<min1) {
                    min2=min1;
                    min1=prevRow[j];
                    min1Index=j;
                } else if(prevRow[j]<min2) {
                    min2=prevRow[j];
                }
            }

            for(int j=0; j<k; j++) {
                if(min1Index==j) {
                    currRow[j] = costs[i][j] + min2;
                } else {
                    currRow[j] = costs[i][j] + min1;
                }
            }
            prevRow = currRow;
        }

        //Find the minCost among the lastRow
        int minCost=Integer.MAX_VALUE;
        for(int j=0; j<n; j++) {
            minCost=Math.min(minCost, prevRow[j]);
        }
        return minCost;
    }

    public static void main(String[] args) {
        int[][] costs = {{1, 5, 3}, {2, 9, 4}};
        PaintHouse2 sol = new PaintHouse2();
        System.out.println("Minimum costs to paint n house with given k colors is: " +sol.minCost(costs));
    }
}
