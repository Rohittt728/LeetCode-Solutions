/*

Link : https://leetcode.com/problems/reconstruct-itinerary/

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
One must use all the tickets once and only once.

Example 1:
Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

Example 2:
Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.

*/




class Solution {
    
    HashMap<String, PriorityQueue<String>> flights;
    List<String> path;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        
        flights = new HashMap<>();
        path = new ArrayList<>();
        
        for (List<String> li : tickets) {
            flights.putIfAbsent(li.get(0), new PriorityQueue<String>());
            flights.get(li.get(0)).add(li.get(1));
        }
        
        dfs("JFK");
        return path;
    }
    
    public void dfs (String depart) {
        
        PriorityQueue<String> pq = flights.get(depart);
        
        // System.out.println (depart + " " + pq);
        while (pq != null && !pq.isEmpty())
            dfs(pq.poll());
        
        path.add(0, depart);
    }
}