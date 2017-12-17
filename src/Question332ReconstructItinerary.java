import java.util.*;

public class Question332ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, Queue<String>> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String[] ticket : tickets) {
            String departure = ticket[0];
            String arrival = ticket[1];
            map.putIfAbsent(departure, new PriorityQueue<>());
            map.get(departure).add(arrival);
        }
        helper(result, map, "JFK");
        return result;
    }

    private void helper(List<String> result, Map<String, Queue<String>> map, String departure) {
        Queue<String> arrivals = map.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            helper(result, map, arrivals.poll());
        result.add(0, departure);
    }

    public static void main(String[] args) {
        String[][] test = new String[][] {
                {"JFK", "ABC"},
                {"JFK", "DEF"},
                {"ABC", "GHI"},
                {"DEF", "JFK"},
        };
        Question332ReconstructItinerary tmp = new Question332ReconstructItinerary();
        System.out.println(tmp.findItinerary(test));
    }
}
