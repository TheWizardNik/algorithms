import java.util.HashMap;
import java.util.HashSet;

public class Greedy {
    public static HashSet<String> greedy(HashSet<String> statsNeeded,
                                         HashMap<String, HashSet<String>> stations) {
        HashSet<String> finalStations = new HashSet<>();
        while (!statsNeeded.isEmpty()) {
            String bestStation = null;
            HashSet<String> statesCovered = new HashSet<>();
            for (HashMap.Entry s: stations.entrySet()) {
                    HashSet<String> covered = new HashSet<>();
                    covered.addAll(statsNeeded);
                    covered.retainAll((HashSet<String>)s.getValue());
                    if (covered.size() > statesCovered.size()) {
                        bestStation = (String)s.getKey();
                        statesCovered = covered;
                    }
            }
            statsNeeded.removeAll(statesCovered);
            finalStations.add(bestStation);
        }
        return finalStations;
    }

    public static void main(String[] args) {
        HashSet<String> statsNeeded = new HashSet<>();
        statsNeeded.add("mt");
        statsNeeded.add("wa");
        statsNeeded.add("or");
        statsNeeded.add("id");
        statsNeeded.add("nv");
        statsNeeded.add("ut");
        statsNeeded.add("ca");
        statsNeeded.add("az");

        HashMap<String, HashSet<String>> stations = new HashMap<>();

        HashSet<String> kone = new HashSet<>();
        HashSet<String> ktwo = new HashSet<>();
        HashSet<String> kthree = new HashSet<>();
        HashSet<String> kfour = new HashSet<>();
        HashSet<String> kfive = new HashSet<>();

        kone.add("id");
        kone.add("nv");
        kone.add("ut");

        ktwo.add("wa");
        ktwo.add("id");
        ktwo.add("mt");

        kthree.add("or");
        kthree.add("nv");
        kthree.add("ca");

        kfour.add("nv");
        kfour.add("ca");

        kfive.add("ca");
        kfive.add("az");

        stations.put("kone",kone);
        stations.put("ktwo",ktwo);
        stations.put("kthree",kthree);
        stations.put("kfour",kfour);
        stations.put("kfive",kfive);


        HashSet<String> finalStations = greedy(statsNeeded,stations);

        for (String s : finalStations)
        System.out.println(s+" ");
    }
}
