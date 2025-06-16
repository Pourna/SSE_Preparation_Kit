import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeIntervalTest {
    MergeInterval solution = new MergeInterval();

    @Test
    public void test_Input1() {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] expected = {{1,6},{8,10},{15,18}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    public void test_Input2() {
        int[][] intervals = {{1,2},{3,6},{8,10},{15,18}};
        int[][] expected = {{1,2},{3,6},{8,10},{15,18}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    public void test_Input3() {
        int[][] intervals = {};
        int[][] expected = {};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    public void test_Input4() {
        int[][] intervals = {{1,3}};
        int[][] expected = {{1,3}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    public void test_Input5() {
        int[][] intervals = {{1,2}, {2,3} ,{3,4}};
        int[][] expected = {{1,4}};
        assertArrayEquals(expected, solution.merge(intervals));
    }
}
