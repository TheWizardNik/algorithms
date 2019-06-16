import java.util.HashMap;
import java.util.LinkedList;

public class Dijkstra {
    private static String[] nodes = new String[]{"a", "b", "fin"};


    public static String findLowest(HashMap<String, Double> costs, LinkedList<String> searched) {
        Double lowest = Double.POSITIVE_INFINITY;
        String lowestNode = null;
        for (String node : nodes) {
            Double cost = costs.get(node);
            if (cost < lowest && !searched.contains(node)) {
                lowest = cost;
                lowestNode = node;
            }
        }
        return lowestNode;
    }

    public static HashMap<String, Double> dijkstra(HashMap<String, HashMap<String, Double>> graph,
                                                     HashMap<String, Double> costs,
                                                     HashMap<String, String> parents) {
        LinkedList<String> searched = new LinkedList<>();
        String node = findLowest(costs,searched);
        while (node!=null)
        {
            Double cost = costs.get(node);
            HashMap<String,Double> neighbours = graph.get(node);
            for (String n: neighbours.keySet())
            {
                Double newCost = cost + neighbours.get(n);
                if (costs.get(n)>newCost)
                {
                    costs.replace(n,newCost);
                    parents.replace(n,node);
                }
            }
            searched.add(node);
            node = findLowest(costs,searched);
        }
        return costs;
    }


    public static void main(String[] args) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        HashMap<String, Double> costs = new HashMap<>();
        HashMap<String, String> parents = new HashMap<>();

        HashMap<String, Double> start = new HashMap<>();
        start.put("a", (double) 6);
        start.put("b", (double) 2);
        HashMap<String, Double> a = new HashMap<>();
        a.put("fin", (double) 1);
        HashMap<String, Double> b = new HashMap<>();
        b.put("a", (double) 3);
        b.put("fin", (double) 5);
        HashMap<String, Double> fin = new HashMap<>();

        graph.put("start", start);
        graph.put("a", a);
        graph.put("b", b);
        graph.put("fin", fin);

        costs.put("a", (double) 6);
        costs.put("b", (double) 2);
        costs.put("fin", Double.POSITIVE_INFINITY);

        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        costs = dijkstra(graph,costs,parents);

        System.out.println(costs.get("fin"));
    }
}
