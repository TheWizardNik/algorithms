package BFS;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class BFS {
    public static Person bfs(PersonGraph graph) {
        ArrayDeque<Person> deque = new ArrayDeque<>();
        deque.addAll(graph.get("masha"));
        while (!deque.isEmpty()) {
            Person p = new Person(deque.pop());
            if (p.isSeller()) return p;
            else if (graph.get(p.getName())!=null) deque.addAll(graph.get(p.getName()));
        }
        return new Person("nobody", false);
    }


    public static void main(String[] args) {
        Person masha = new Person("masha", false);
        Person dasha = new Person("dasha", false);
        Person kostya = new Person("kostya", false);
        Person misha = new Person("misha", true);
        Person lena = new Person("lena", false);
        Person oleg = new Person("oleg", false);
        Person ivan = new Person("ivan", true);

        LinkedList<Person> mashaList = new LinkedList<>();
        mashaList.add(dasha);
        mashaList.add(kostya);
        LinkedList<Person> dashaList = new LinkedList<>();
        dashaList.add(masha);
        dashaList.add(kostya);
        dashaList.add(lena);
        LinkedList<Person> kostyaList = new LinkedList<>();
        kostyaList.add(misha);
        LinkedList<Person> lenaList = new LinkedList<>();
        lenaList.add(ivan);
        lenaList.add(oleg);
        LinkedList<Person> ivanList = new LinkedList<>();
        ivanList.add(masha);

        PersonGraph graph = new PersonGraph();
        graph.put("masha", mashaList);
        graph.put("dasha", dashaList);
        graph.put("kostya", kostyaList);
        graph.put("misha", new LinkedList<Person>());
        graph.put("lena", lenaList);
        graph.put("ivan", ivanList);
        graph.put("oleg", new LinkedList<Person>());

        System.out.println(bfs(graph).getName() + " is seller!");
    }
}
