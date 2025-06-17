/*
For input: [[1,1],2,[1,1]]
Level 1: [2] → seen first, gets higher weight
Level 2: [1,1,1,1] → seen later, gets lower weight
Result = 2×2 + 4×1 = 8


Time Complexity: O(N), where N is the total number of elements (integers + lists)
Space Complexity: O(W), where W is the max width of the nested list (number of elements at any level)
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Interface as defined in the problem
interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    void setInteger(int value);
    void add(NestedInteger ni);
    List<NestedInteger> getList();
}

// Implementation of NestedInteger for testing
class NestedIntegerImpl implements NestedInteger {
    private Integer value;
    private List<NestedInteger> list;

    public NestedIntegerImpl() {
        list = new ArrayList<>();
    }

    public NestedIntegerImpl(int value) {
        this.value = value;
    }

    @Override
    public boolean isInteger() {
        return value != null;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public void setInteger(int value) {
        this.value = value;
        this.list = null;
    }

    @Override
    public void add(NestedInteger ni) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(ni);
        this.value = null; // it's now a list, not a single integer
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}

// Solution class with BFS method
class NestedListSum {
    public static int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        int weighted=0;
        int unweighted=0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                NestedInteger item = queue.poll();
                if(item.isInteger()){
                    unweighted+=item.getInteger();
                } else {
                    queue.addAll(item.getList());
                }
            }
            weighted+=unweighted;
        }
        return weighted;
    }

    public static void main(String[] args) {
        // Create input: [[1,1], 2, [1,1]]
        NestedIntegerImpl list1 = new NestedIntegerImpl();
        list1.add(new NestedIntegerImpl(1));
        list1.add(new NestedIntegerImpl(1));

        NestedIntegerImpl list2 = new NestedIntegerImpl();
        list2.add(new NestedIntegerImpl(1));
        list2.add(new NestedIntegerImpl(1));

        List<NestedInteger> input = new ArrayList<>();
        input.add(list1);
        input.add(new NestedIntegerImpl(2));
        input.add(list2);

        // Run solution
        int result = depthSumInverse(input);
        System.out.println("Result: " + result);  // Output: 8
    }
}
