import java.util.ArrayList;
import java.util.List;

public class MergeInterval2 {

    public int[][] merge(int[][] intervals, int[] newInterval) {
        int n=intervals.length;

        if(n==0 && newInterval.length==0) return new int[][]{};
        if(n==0 && newInterval.length>1) return new int [][]{newInterval};

        //{1,3},{6,9},{15,18} - {2,5}
        List<int[]> result = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if(newInterval[1] < intervals[i][0]) {
                result.add(newInterval);
                newInterval = intervals[i];
            } else if(newInterval[0] > intervals[i][1]) {
                result.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
