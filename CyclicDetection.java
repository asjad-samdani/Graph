import java.util.ArrayList;

public class CyclicDetection {
  static class Edge {
    int src;
    int dest;

    public Edge(int s, int d) {
      this.dest = d;
      this.src = s;
    }
  }

  static void createGraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 2));
    graph[0].add(new Edge(0, 3));
    // 1-vertex
    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 2));
    // 2-vertex
    graph[2].add(new Edge(2, 0));
    graph[2].add(new Edge(2, 1));
    // 3-vertex
    graph[3].add(new Edge(3, 0));
    graph[3].add(new Edge(3, 4));
    // 4- vertex
    graph[4].add(new Edge(4, 3));

  }

  static boolean detectCycle(ArrayList<Edge>[] graph) {
    boolean[] vis = new boolean[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (!vis[i]) {
        if (detectCycleUtil(graph, vis, i, -1)) {
          return true;
        }
      }
    }
    return false;

  }

  static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] visit, int curr, int parent) {
    visit[curr] = true;
    // for (int i = 0; i < graph[curr].size(); i++) {
    // 3 case to visit
    // Edge e = graph[curr].get(i);
    for (Edge e : graph[curr]) {

      // Case 3: Unvisited node, so we perform DFS
      if (!visit[e.dest]) {
        if (detectCycleUtil(graph, visit, e.dest, curr)) {
          return true;
        }
        // Case 1: If the node is visited and is not the parent, we found a cycle
      } else if (visit[e.dest] && e.dest != parent) {
        return true;

      }
    }
    return false;

  }

  public static void main(String[] args) {
    int V = 5;
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph);
    System.out.println(detectCycle(graph));

  }

}
