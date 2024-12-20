import java.util.ArrayList;

public class HashPath {
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

  public static void createGraph(ArrayList<Edge>[] graph) {
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

  public static boolean hashPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
    if (src == dest) {
      return true;

    }
    visited[src] = true;

    // for (int i = 0; i < graph[src].size(); i++) {
    // Edge e = graph[src].get(i);
    // if (!visited[e.dest]) {
    // if (hashPath(graph, e.dest, dest, visited)) {
    // return true;
    // }

    // }

    // }
    // return false;
    for (Edge edge : graph[src]) {
      if (!visited[edge.dest] && hashPath(graph, edge.dest, dest, visited)) {
        return true;

      }
    }
    return false;
  }

  // String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);

  public static void main(String[] args) {
    int V = 7;
    int src = 0;
    int dest = 4;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);
    boolean vis = hashPath(graph, src, dest, new boolean[V]);
    if (vis) {
      System.out.println("Path exists between " + src + " and " + dest);

    } else {
      System.out.println("No path exists between " + src + " and " + dest);
    }
  }
}
