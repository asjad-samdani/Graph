import java.util.*;

class Person {
  String name;
  int age;

  Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return name + " (" + age + ")";
  }
}

public class ComparatorExample {
  public static void main(String[] args) {
    List<Person> people = new ArrayList<>();
    people.add(new Person("Alice", 30));
    people.add(new Person("Bob", 25));
    people.add(new Person("Charlie", 35));

    // Sorting by name using Comparator
    people.sort(new Comparator<Person>() {
      @Override
      public int compare(Person p1, Person p2) {
        return p1.name.compareTo(p2.name);
      }
    });

    System.out.println("Sorted by name: " + people);
  }
}
