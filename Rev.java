import java.util.Stack;

public class Rev {
  public static void main(String[] args) {
    int number = 12345;
    String str = String.valueOf(number);
    Stack<Character> stack = new Stack<>();

    for (char ch : str.toCharArray()) {
      stack.push(ch);
    }

    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");
    }

  }
}