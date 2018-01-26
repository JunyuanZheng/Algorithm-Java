import java.util.*;

public class Question399EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        assert equations.length == values.length;
        Map<String, Map<String, Double>> map = new HashMap<>();
        int length = equations.length;
        for (int i = 0; i < length; i += 1) {
            String[] equation = equations[i];
            double value = values[i];
            // update 1
            Map<String, Double> list1 = map.getOrDefault(equation[0], new HashMap<>());
            list1.putIfAbsent(equation[1], value);
            map.put(equation[0], list1);

            // update 2
            Map<String, Double> list2 = map.getOrDefault(equation[1], new HashMap<>());
            list2.putIfAbsent(equation[0], 1.0 / value);
            map.put(equation[1], list2);
        }
        double[] results = new double[queries.length];
        for (int i = 0; i < results.length; i += 1) {
            String[] query = queries[i];
            Double result = this.query(query[0], query[1], map, new HashSet<>());
            results[i] = (result != null) ? result : -1.0;
        }
        return results;
    }

    private Double query(String start, String end, Map<String, Map<String, Double>> map, Set<String> visited) {
        String dupeKey = start+":"+end;
        if(visited.contains(dupeKey))
            return null;
        if(!map.containsKey(start) || !map.containsKey(end))
            return null;
        if(Objects.equals(start, end))
            return 1.0;
        Map<String, Double> tmp = map.get(start);
        visited.add(dupeKey);
        for(String key : tmp.keySet()) {
            Double res = query(key, end, map, visited);
            if(res != null) {
                return tmp.get(key) * res;
            }
        }
        visited.remove(dupeKey);
        return null;
    }
}
