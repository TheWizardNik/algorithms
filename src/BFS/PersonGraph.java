package BFS;

import BFS.Person;

import java.util.HashMap;
import java.util.LinkedList;

public class PersonGraph {
   private HashMap<String, LinkedList<Person>> graph = new HashMap<>();

   public PersonGraph (){}



   public PersonGraph (String key, LinkedList<Person> value)
   {
       graph.put(key,value);
   }

   public void put (String key, LinkedList<Person> value)
   {
       graph.put(key,value);
   }

   public LinkedList<Person> get (String person)
   {
       return graph.get(person);
   }
}
