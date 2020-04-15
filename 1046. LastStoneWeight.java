/*

Link : https://leetcode.com/problems/last-stone-weight/

We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

Example 1:
Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.

Note:
1 <= stones.length <= 30
1 <= stones[i] <= 1000

*/


// Solution1 : fetching max, sorting, repeat
class Solution {
    public int lastStoneWeight(int[] stones) {
        
        int len = stones.length;
        Arrays.sort(stones);				// sorting array
        
        while (len > 1) {
            int p = stones[len - 1];			// fetching maximum two elements
            int q = stones[len - 2];
            if (p == q)						// if both are equals, array length is reduced by 2
                len -= 2;
            else {							// if not, replace second last element by "max - secondMax"
                stones[len - 2] = p - q;		// array length reduced by 1
                len -= 1;
            }
                
            Arrays.sort(stones, 0, len);		// again sort the array till the reduced length
        }
        if (len == 1)							// if single element remains return it, else 0
            return stones[0];
        return 0;
    }
}



// Solution2 : using max heap property, priority queue in java
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i : stones)
            pq.add(i);
        
        int a = 0;
        int b = 0;
        while (pq.size() > 1) {
            a = pq.poll();
            b = pq.poll();
            if (a > b)
                pq.add(a - b);
        }
        return pq.size() == 1 ? pq.poll() : 0;
    }
}