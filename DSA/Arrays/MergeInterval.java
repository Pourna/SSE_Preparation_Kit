import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
    }

    public int[][] merge (int[][] intervals) {
        int n = intervals.length;
        if(n==0) return new int[][]{};

        List<int[]> result = new ArrayList<>();
        int last = 0;
        for(int i=1; i<n; i++) {
            if(intervals[i][0]<=intervals[last][1]) {
                intervals[last][1] = Math.max(intervals[i][1], intervals[last][1]);
            } else {
                result.add(new int[] {intervals[last][0], intervals[last][1]});
                last++;
                intervals[last] = intervals[i];
            }
        }
        result.add(new int[] {intervals[last][0], intervals[last][1]});
        for (int[] interval : result) {
            System.out.print(Arrays.toString(interval));
        }
        return result.toArray(new int[result.size()][]);
    }
}


