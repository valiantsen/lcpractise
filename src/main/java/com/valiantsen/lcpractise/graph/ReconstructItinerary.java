package main.java.com.valiantsen.lcpractise.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from,
 * to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK.
 * Thus, the itinerary must begin with JFK.
 * 
 * Note: If there are multiple valid itineraries, you should return the itinerary that has the
 * smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"]
 * has a smaller lexical order than ["JFK", "LGB"]. All airports are represented by three capital
 * letters (IATA code). You may assume all tickets form at least one valid itinerary. Example 1:
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]] Return ["JFK", "MUC",
 * "LHR", "SFO", "SJC"]. Example 2: tickets =
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]] Return
 * ["JFK","ATL","JFK","SFO","ATL","SFO"]. Another possible reconstruction is
 * ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 * 
 * @ClassName: ReconstructItinerary
 * @author zhangyasen
 * @date 2017年10月8日
 */
public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String[] pair : tickets) {
            if (map.containsKey(pair[0])) {
                map.get(pair[0]).add(pair[1]);
            } else {
                PriorityQueue<String> l = new PriorityQueue<>();
                l.add(pair[1]);
                map.put(pair[0], l);
            }
        }
        find("JFK", result, map);
        return result;
    }

    private void find(String source, List<String> result, Map<String, PriorityQueue<String>> map) {
        while (map.containsKey(source) && !map.get(source).isEmpty()) {
            find(map.get(source).poll(), result, map);
        }
        result.add(0, source);
    }
}
