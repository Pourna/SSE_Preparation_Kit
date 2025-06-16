// @tag:LinkedIn
import java.util.ArrayList;
import java.util.List;

/*
*Given an array of distinct integers candidates and a target integer target,
return all unique combinations of candidates where the chosen numbers sum to target.
You may use the same number from candidates unlimited number of times.

✅ Example:
Input:
candidates = [2,3,6,7], target = 7
Output:
[[2,2,3],[7]]

*
Time Complexity: O(2^t) where t = target, due to branching on each step.
Space Complexity: O(k) where k is the depth of recursion.
*/
public class CombinationSum {

    public List<List<Integer>> combination(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    public void backTrack(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {
        if(target==0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if(target<0 || index==candidates.length)
            return;

        current.add(candidates[index]);
        backTrack(candidates, index, target-candidates[index], current, result);
        current.remove(current.size()-1);

        backTrack(candidates, index+1, target, current, result);
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = cs.combination(candidates, target);
        System.out.println(res);
    }
}
