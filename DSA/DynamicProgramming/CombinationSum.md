Here is the Java solution to  [LeetCode Link](https://leetcode.com/problems/combination-sum/description/) 

### ✅ Problem:
Given an array of distinct integers candidates and a target integer target, return all unique combinations of candidates where the chosen numbers sum to target. You may use the same number from candidates unlimited number of times.

### ✅ Example:
Input: candidates = [2,3,6,7], 

target = 7

Output: [[2,2,3],[7]]

### ✅ Approach:
#### Use Backtracking (DFS).

At each step:

Include the current candidate and recurse with the remaining target reduced.

Or skip the current candidate and move to the next.

Stop when:

Target becomes 0 → Valid combination.

Target becomes < 0 → Invalid path.

### ✅ Time and Space Complexity:
#### Time Complexity: 
O(2^t) where t = target, due to branching on each step.

#### Space Complexity:
O(k) where k is the depth of recursion.