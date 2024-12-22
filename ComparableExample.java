import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student {
  int roll;
  String name;
  int age;

  public Student(int r, String n, int a) {
    this.roll = r;
    this.name = n;
    this.age = a;
  }

  @Override
  public String toString() {
    return "Student{roll=" + roll + ", name='" + name + "', age=" + age + "}";
  }

  // @Override
  // public int compareTo(Student s) {
  // return s.age - this.age;
  // }

}

public class ComparableExample {

  public static void main(String[] args) {
    List<Student> students = new ArrayList<>();
    students.add(new Student(1, "Alice", 20));
    students.add(new Student(2, "Bob", 22));
    students.add(new Student(3, "Charlie", 21));
    students.add(new Student(4, "David", 23));
    students.add(new Student(5, "Eve", 24));
    students.forEach(s -> System.out.println(s));
    System.out.println("\nAfter sorting by age (descending):");
    Collections.sort(students, (s1, s2) -> s2.roll - s1.roll);
    students.forEach(s -> System.out.println(s));
  }

}
