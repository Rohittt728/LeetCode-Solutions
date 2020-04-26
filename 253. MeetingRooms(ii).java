/*

Link : https://leetcode.com/problems/meeting-rooms-ii/

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:
Input: intervals = [(0,30),(5,10),(15,20)]
Output: 2
	Explanation:
	We need two meeting rooms
	room1: (0,30)
	room2: (5,10),(15,20)

Example 2:
Input: intervals = [(2,7)]
Output: 1
	Explanation: 
	Only need one meeting room

*/



/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int count = 0;
        for (Interval i : intervals) {
            if (pq.isEmpty()) {
                count ++;
                pq.add(i.end);
            }
            else {
                int min = pq.peek();
                if (min <= i.start)
                    pq.poll();
                else
                    count ++;
                pq.add(i.end);
            }
        }
        
        return count;
    }
}