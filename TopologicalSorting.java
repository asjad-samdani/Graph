import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {
  static class Edge {
    int src;
    int dest;

    public Edge(int s, int d) {
      this.dest = d;
      this.src = s;

    }
  }

  public static void createGraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();

    }
    graph[2].add(new Edge(2, 3));
    graph[3].add(new Edge(3, 1));

    graph[4].add(new Edge(4, 0));
    graph[4].add(new Edge(4, 1));

    graph[5].add(new Edge(5, 0));
    graph[5].add(new Edge(5, 2));
  }

  public static void topSortUtils(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> stack) {
    vis[curr] = true;
    for (Edge edge : graph[curr]) {
      if (!vis[edge.dest]) {
        topSortUtils(graph, edge.dest, vis, stack);
      }
    }
    stack.push(curr);

  }

  public static void topSort(ArrayList<Edge> graph[], int v) {
    boolean vis[] = new boolean[v];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < v; i++) {
      if (!vis[i]) {
        topSortUtils(graph, i, vis, stack);
      }
    }
    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");

    }
  }

  public static void main(String[] args) {
    int V = 6;
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph);
    topSort(graph, V);

  }
}
