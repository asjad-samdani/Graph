import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {

  static class Edge {
    int src;
    int dest;
    int wt;

    public Edge(int s, int d, int w) {
      this.src = s;
      this.dest = d;
      this.wt = w;
    }
  }

  static void createGraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();

    }

    // 0-vertex
    graph[0].add(new Edge(0, 1, 1));
    graph[0].add(new Edge(0, 2, 1));
    // 1-vertex
    graph[1].add(new Edge(1, 0, 1));
    graph[1].add(new Edge(1, 3, 1));
    // 2-vertex
    graph[2].add(new Edge(2, 0, 1));
    graph[2].add(new Edge(2, 4, 1));
    // 3-vertex
    graph[3].add(new Edge(3, 1, 1));
    graph[3].add(new Edge(3, 4, 1));
    graph[3].add(new Edge(3, 5, 1));
    // 4- vertex
    graph[4].add(new Edge(4, 2, 1));
    graph[4].add(new Edge(4, 3, 1));
    graph[4].add(new Edge(4, 5, 1));
    // 5th
    graph[5].add(new Edge(5, 3, 1));
    graph[5].add(new Edge(5, 4, 1));
    graph[5].add(new Edge(5, 6, 1));
    // 6th
    graph[6].add(new Edge(6, 5, 1));

  }

  public static void bfs(ArrayList<Edge>[] graph) {
    Queue<Integer> queue = new LinkedList();
    boolean visited[] = new boolean[graph.length];
    queue.add(0); // spurce->0
    while (!queue.isEmpty()) {
      int curr = queue.remove();
      if (!visited[curr]) {
        visited[curr] = true;
        System.out.print(curr + " ");
        // for (int i = 0; i < graph[curr].size(); i++) {
        // Edge e = graph[curr].get(i);
        // queue.add(e.dest);
        // }
        for (Edge e : graph[curr]) {
          queue.add(e.dest);
        }
      }

    }
  }

  public static void main(String[] args) {
    int v = 7;
    ArrayList<Edge> graph[] = new ArrayList[v];
    createGraph(graph);
    bfs(graph);

  }

}
