package BFS;

public class Person {
    private boolean isSeller;
    private String name;

    public Person(Person person)
    {
        this.isSeller = person.isSeller();
        this.name = person.getName();
    }

    public Person(String name, boolean isSeller)
    {
        this.name=name;
        this.isSeller=isSeller;
    }

    public String getName() {
        return name;
    }

    public boolean isSeller() {
        return isSeller;
    }
}
