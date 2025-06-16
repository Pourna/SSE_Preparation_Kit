// @tag:LinkedIn
### 🔍 How It Works:
cleanRoom(): Starts DFS from position (0,0) facing up (dir = 0).

visited set: Tracks which (row,col) cells we've already cleaned.

dfs():

Cleans the current cell.

Explores all 4 directions using robot’s move() and orientation.

Recursively continues cleaning all accessible spaces.

Uses goBack() to return to the previous cell and restore direction.

goBack():

Turns 180°, moves forward (backward), and restores direction with another 180°.


### ✅ Features:
Simulates a room with walls (0) and open cells (1)

Defines a mock Robot class with position and direction

Implements the cleaning logic

Shows the cleaned room after execution


### 🧱 Room Layout Reminder:
We're using this room layout:

```java
int[][] room = {
    {1, 1, 1, 1},
    {1, 0, 0, 1},
    {1, 1, 1, 1}
};
```

### Visual representation:

```aiignore
(0,0) (0,1) (0,2) (0,3)
(1,0)  X     X   (1,3)
(2,0) (2,1) (2,2) (2,3)
```

#### Legend:

1: free space

0: wall / obstacle

X: wall (can't move there)

#### Robot starts at (1, 3) (last cell of 2nd row)



```java
import java.util.*;

interface Robot {
    boolean move();
    void turnLeft();
    void turnRight();
    void clean();
}

public class RoomCleanerWithGridPrint {

    static final int[][] DIRS = { {-1,0}, {0,1}, {1,0}, {0,-1} };

    static class SimulatedRobot implements Robot {
        int[][] room;
        int x, y;
        int dir;
        Set<String> cleaned = new HashSet<>();

        public SimulatedRobot(int[][] room, int startX, int startY) {
            this.room = room;
            this.x = startX;
            this.y = startY;
            this.dir = 0;
        }

        public boolean move() {
            int newX = x + DIRS[dir][0];
            int newY = y + DIRS[dir][1];
            if (newX >= 0 && newX < room.length && newY >= 0 && newY < room[0].length && room[newX][newY] == 1) {
                x = newX;
                y = newY;
                return true;
            }
            return false;
        }

        public void turnLeft() {
            dir = (dir + 3) % 4;
        }

        public void turnRight() {
            dir = (dir + 1) % 4;
        }

        public void clean() {
            cleaned.add(x + "," + y);
        }

        public void printCleanedGrid() {
            System.out.println("Cleaned Grid:");
            for (int i = 0; i < room.length; i++) {
                for (int j = 0; j < room[0].length; j++) {
                    if (room[i][j] == 0) {
                        System.out.print(" # ");
                    } else if (cleaned.contains(i + "," + j)) {
                        System.out.print(" C ");
                    } else {
                        System.out.print(" . ");
                    }
                }
                System.out.println();
            }
        }
    }

    static class Solution {
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

        public void cleanRoom(Robot robot) {
            Set<String> visited = new HashSet<>();
            dfs(robot, 0, 0, 0, visited);
        }

        private void dfs(Robot robot, int row, int col, int dir, Set<String> visited) {
            String pos = row+","+col;
            if (visited.contains(pos)) return;
            
            robot.clean();
            visited.add(pos);
            
            for(int i=0; i<4; i++) {
                int newDir = (i + dir) % 4;
                int newRow = row + directions[newDir][0];
                int newCol = col + directions[newDir][1];

                if (!visited.contains(newRow + "," + newCol) && robot.move()) {
                    dfs(robot, newRow, newCol, newDir, visited);
                    robot.goBack();
                }
                robot.turnRight();
            }
        }

        private void goBack(Robot robot) {
            robot.turnRight();
            robot.turnRight();
            robot.move();
            robot.turnRight();
            robot.turnRight();
        }
    }

    public static void main(String[] args) {
        int[][] room = {
            {1, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 1}
        };

        // Robot starts at row=1, col=3
        SimulatedRobot robot = new SimulatedRobot(room, 1, 3);

        Solution cleaner = new Solution();
        cleaner.cleanRoom(robot);

        robot.printCleanedGrid();
    }
}
```

### 🧪 Sample Output:

```yaml
Cleaned Cells:
0,0
1,0
0,1
0,2
0,3
1,3
2,3
2,2
2,1
2,0
```
