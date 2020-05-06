/*

Link : https://leetcode.com/problems/flatten-2d-vector/

Implement an iterator to flatten a 2d vector.

Example 1:
Input:[[1,2],[3],[4,5,6]]
Output:[1,2,3,4,5,6]

Example 2:
Input:[[7,9],[5]]
Output:[7,9,5]

*/



public class Vector2D implements Iterator<Integer> {

    List<List<Integer>> list;
    int row;
    int col;
    int totalRows;
    
    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        list = vec2d;
        row = 0;
        col = 0;
        totalRows = list.size();
    }

    @Override
    public Integer next() {
        // Write your code here
        int n = 0;
        if (col < list.get(row).size())
            n = list.get(row).get(col);
            
        col++;
        if (col == list.get(row).size()) {
            col = 0;
            row ++;
        }
        return n;
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        while (row < totalRows && (list.get(row) == null || list.get(row).isEmpty()))
            row ++;
            
        return list != null && !list.isEmpty() && row < totalRows;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */