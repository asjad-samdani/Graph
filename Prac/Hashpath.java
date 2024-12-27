package Prac;
import java.util.ArrayList;

class Edge {
  int src;
  int dest;

  public Edge(int s, int d) {
    this.src = s;
    this.dest = d;

  }
}

class Hashpath {

  public static void createGraph(ArrayList<Edge> graph[], int V) {
    for (int i = 0; i < V; i++) {
      graph[i] = new ArrayList<>();
    }

    // 0-vertex
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

  public static boolean hashPath(ArrayList<Edge> graph[], int src, int dest, boolean vis[]) {
    if (src == dest) {
      return true;
    }
    vis[src] = true;
    for (Edge edge : graph[src]) {
      if (!vis[edge.dest] && hashPath(graph, edge.dest, dest, vis)) {
        return true;
      }

    }
    return false;
  }

  public static void main(String[] args) {

    int V = 7;
    int src = 0;
    int dest = 2;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph, V);
    boolean path = hashPath(graph, src, dest, new boolean[V]);
    if (path) {
      System.out.println("Path exists between " + src + " and " + dest);
    } else {
      System.out.println("No path exists between " + src + " and " + dest);
    }
  }

}