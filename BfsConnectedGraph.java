import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsConnectedGraph {
  static class Edge {
    int src;
    int dest;

    public Edge(int s, int d) {
      this.src = s;
      this.dest = d;
    }

  }

  public static void createGraph(ArrayList<Edge>[] graph) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 2));
    // 1-vertex
    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 3));
    // 2-vertex
    graph[2].add(new Edge(2, 0));
    graph[2].add(new Edge(2, 4));
    // 3-vertex
    graph[3].add(new Edge(3, 1));
    graph[3].add(new Edge(3, 4));
    graph[3].add(new Edge(3, 5));
    // 4- vertex
    graph[4].add(new Edge(4, 2));
    graph[4].add(new Edge(4, 3));
    graph[4].add(new Edge(4, 5));
    // 5th
    graph[5].add(new Edge(5, 3));
    graph[5].add(new Edge(5, 4));
    graph[5].add(new Edge(5, 6));
    // 6th
    graph[6].add(new Edge(6, 5));
  }

  public static void bfs(ArrayList<Edge>[] graph) {
    boolean visit[] = new boolean[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (!visit[i]) {
        bfsUtils(graph, visit);

      }
    }

  }

  public static void bfsUtils(ArrayList<Edge>[] graph, boolean[] visit) {
    Queue<Integer> queue = new LinkedList();
    queue.add(0);
    while (!queue.isEmpty()) {
      int curr = queue.remove();
      if (!visit[curr]) {
        System.out.print(curr + " ");
        visit[curr] = true;
        // neigh
        for (int i = 0; i < graph[curr].size(); i++) {
          Edge e = graph[curr].get(i);
          queue.add(e.dest);
        }

      }

    }

  }

  public static void main(String[] args) {
    int V = 7;
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph);
    bfs(graph);
  }

}
