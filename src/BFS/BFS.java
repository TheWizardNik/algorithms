package BFS;

import java.util.*;

public class BFS {

    public static void bfs(TreeMap<Integer, List<Integer>> graph) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        List<Integer> searched = new ArrayList<>();
        deque.addAll(graph.get(graph.firstKey()));
        System.out.println(graph.firstKey());
        while (!deque.isEmpty()) {
            int i = deque.pop();
            if (!searched.contains(i)) {
                System.out.println(i);
                if (graph.get(i) != null) {
                    List<Integer> all = graph.get(i);
                    all.sort(((o1, o2) -> o1 - o2));
                    deque.addAll(all);
                    searched.add(i);
                } else searched.add(i);
            }
        }
    }

    public static void dfs(TreeMap<Integer, List<Integer>> graph) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        List<Integer> searched = new ArrayList<>();
        deque.addAll(graph.get(graph.firstKey()));
        System.out.println(graph.firstKey());
        while (!deque.isEmpty()) {
            int i = deque.pop();
            if (!searched.contains(i)) {
                System.out.println(i);
                if (graph.get(i) != null) {
                    List<Integer> all = graph.get(i);
                    all.sort(((o1, o2) -> o2 - o1));
                    for (int add : all)
                        deque.addFirst(add);
                    searched.add(i);
                } else searched.add(i);
            }
        }
    }

    public static void cosmos(TreeMap<Integer, List<Integer>> graph) {
        List<Integer> inCommand = new ArrayList<>();

        for (int i = 0; i < graph.size() && inCommand.size() < graph.size() / 2; i += 2)
            inCommand.addAll(bfsWithLayers(graph, i));

        System.out.println("////");

        for (int i = 1; i < graph.size() && inCommand.size() < graph.size(); i += 2)
            inCommand.addAll(bfsWithLayers(graph, i));

    }

    public static List<Integer> bfsWithLayers(TreeMap<Integer, List<Integer>> graph, int d) {
        List<Integer> list = new ArrayList<>();
        int layer = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        List<Integer> searched = new ArrayList<>();
        deque.addAll(graph.get(graph.firstKey()));
        int layerSize = graph.get(graph.firstKey()).size();
        while (!deque.isEmpty()) {
            int i = deque.pop();
            if (!searched.contains(i)) {
                if (layer == d) {
                    System.out.println(i);
                    list.add(i);
                }
                if (graph.get(i) != null) {
                    List<Integer> all = graph.get(i);
                    all.sort(((o1, o2) -> o1 - o2));
                    deque.addAll(all);
                    searched.add(i);
                } else searched.add(i);
            }
            layerSize--;
            if (layerSize == 0) {
                layer++;
                layerSize = deque.size();
            }
        }
        return list;
    }


    public static void main(String[] args) {
        LinkedList<Integer> oneList = new LinkedList<>();
        LinkedList<Integer> twoList = new LinkedList<>();
        LinkedList<Integer> threeList = new LinkedList<>();
        LinkedList<Integer> fourList = new LinkedList<>();
        LinkedList<Integer> fiveList = new LinkedList<>();
        LinkedList<Integer> sixList = new LinkedList<>();
        LinkedList<Integer> sevenList = new LinkedList<>();
        LinkedList<Integer> eightList = new LinkedList<>();
        LinkedList<Integer> nineList = new LinkedList<>();
        LinkedList<Integer> tenList = new LinkedList<>();
        oneList.add(3);
        oneList.add(2);
        oneList.add(4);
        twoList.add(1);
        twoList.add(5);
        twoList.add(7);
        threeList.add(1);
        fourList.add(1);
        fourList.add(6);
        fiveList.add(2);
        fiveList.add(8);
        sixList.add(4);
        sixList.add(10);
        sevenList.add(10);
        sevenList.add(8);
        sevenList.add(2);
        eightList.add(7);
        eightList.add(9);
        eightList.add(5);
        nineList.add(10);
        nineList.add(8);
        tenList.add(6);
        tenList.add(7);
        tenList.add(9);
        TreeMap<Integer, List<Integer>> graph = new TreeMap<>();
        graph.put(1, oneList);
        graph.put(2, twoList);
        graph.put(3, threeList);
        graph.put(4, fourList);
        graph.put(5, fiveList);
        graph.put(6, sixList);
        graph.put(7, sevenList);
        graph.put(8, eightList);
        graph.put(9, nineList);
        graph.put(10, tenList);
        System.out.println("dfs:");
        dfs(graph);
        System.out.println("bfs:");
        bfs(graph);
        System.out.println("bfsWithLayers:");
        bfsWithLayers(graph, 0);
        System.out.println("cosmos^");
        cosmos(graph);
    }
}