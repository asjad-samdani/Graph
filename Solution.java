import java.util.*;

class Solution {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int year = in.nextInt();

    System.out.println(isLeapYear(year));
  }

  public static boolean isLeapYear(int year) {

    return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
  }
}
