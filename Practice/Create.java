import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Create {
  static class Edge {
    int src;
    int dest;

    public Edge(int s, int d) {
      this.src = s;
      this.dest = d;
    }
  }

  public static void createGraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }
    // 0-vertex
    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 2));
    // 1-vertex
    graph[1].add(new Edge(1, 3));
    graph[1].add(new Edge(1, 2));
    // 2-vertex
    graph[2].add(new Edge(2, 4));
    // 3-vertex
    graph[3].add(new Edge(3, 5));
    // 4- vertex
    graph[4].add(new Edge(4, 3));
    graph[4].add(new Edge(4, 5));

  }

  public static void dfs(ArrayList<Edge> graph[], int current, boolean visited[]) {
    System.out.print(current + " ");
    visited[current] = true;
    // neighbours
    for (Edge e : graph[current]) {
      if (!visited[e.dest]) {
        dfs(graph, e.dest, visited);
      }
    }
  }

  public static void bfs(ArrayList<Edge> graph[]) {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[graph.length];
    queue.add(0);// source
    while (!queue.isEmpty()) {
      int curr = queue.remove();
      if (!visited[curr]) {
        visited[curr] = true;
        System.out.println(curr);
        for (Edge e : graph[curr]) {
          queue.add(e.dest);
        }

      }

    }
  }

  public static void main(String[] args) {
    int v = 6;
    ArrayList<Edge> graph[] = new ArrayList[v];
    createGraph(graph);
    for (int i = 0; i < v; i++) {
      for (Edge e : graph[i]) {
        System.out.print("[" + e.src + " -> " + e.dest + "] ");
      }
      System.out.println();
    }
    dfs(graph, 0, new boolean[v]);
    bfs(graph);
  }

}
