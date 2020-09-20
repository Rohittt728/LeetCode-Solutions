/*

Link : https://leetcode.com/problems/robot-bounded-in-circle/

On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degress to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

Example 1:
Input: "GGLLGG"
Output: true
Explanation: 
The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.

Example 2:
Input: "GG"
Output: false
Explanation: 
The robot moves north indefinitely.

Example 3:
Input: "GL"
Output: true
Explanation: 
The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...

Note:
1 <= instructions.length <= 100
instructions[i] is in {'G', 'L', 'R'}

*/


class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int x = 0, y = 0;
        int dirs[][] = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;    // 0-North, 1-Right, 2-Down, 3-Left 
        
        int len = instructions.length();
        for (int i = 0; i < len; i++) {
            char c = instructions.charAt(i);
            
            if (c == 'G') {
                x += dirs[dir][0];
                y += dirs[dir][1];
            }
            else if (c == 'L') {
                dir = (dir + 3) % 4;
            }
            else if (c == 'R') {
                dir = (dir + 1) % 4;
            }
        }
        
        // either at the same place or at a different place with a different direction
        return (x == 0 && y == 0) || (dir != 0);
    }
}