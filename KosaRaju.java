import java.util.ArrayList;
import java.util.Stack;

class Edge {
  int src;
  int dest;

  public Edge(int s, int d) {
    this.src = s;
    this.dest = d;
  }
}

public class KosaRaju {
  public static void createGraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 2));
    graph[0].add(new Edge(0, 3));

    graph[1].add(new Edge(1, 0));

    graph[2].add(new Edge(2, 1));

    graph[3].add(new Edge(3, 4));
  }

  // Depth First Search (DFS)
  private static void dfs(ArrayList<Edge>[] graph, int curr, boolean visited[]) {
    visited[curr] = true;
    System.out.print(curr + " ");

    for (Edge edge : graph[curr]) {
      if (!visited[edge.dest]) {
        dfs(graph, edge.dest, visited);
      }
    }
  }

  // Topological Sorting for Kosaraju's algorithm
  public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
    // dfs
    vis[curr] = true;
    for (Edge edge : graph[curr]) {
      if (!vis[edge.dest]) {
        topSort(graph, edge.dest, vis, s);
      }

    }
    s.push(curr);

  }

  // Kosaraju's algorithm to find strongly connected components (SCCs)
  public static void kosaRaju(ArrayList<Edge> graph[], int v) {
    // Step 1 O(V+E)
    Stack<Integer> s = new Stack<>();
    boolean visited[] = new boolean[v];
    for (int i = 0; i < v; i++) {
      if (!visited[i]) {
        topSort(graph, i, visited, s);
      }
    }
    // Step 2: Transpose the graph (reverse all edges) (O(V + E))
    ArrayList<Edge> transpose[] = new ArrayList[v];
    for (int i = 0; i < v; i++) {
      visited[i] = false;
      transpose[i] = new ArrayList<>();
    }
    for (int i = 0; i < v; i++) {
      for (Edge e : graph[i]) {
        transpose[e.dest].add(new Edge(e.dest, e.src));
      }
    }
    // Step 3: DFS on the transposed graph (O(V + E))
    while (!s.isEmpty()) {
      int curr = s.pop();
      if (!visited[curr]) {
        System.out.print("SCC: ");
        dfs(transpose, curr, visited);
        System.out.println();
      }
    }

  }

  public static void main(String[] args) {
    int v = 5;
    ArrayList<Edge> graph[] = new ArrayList[v];
    createGraph(graph);
    System.out.println("Strongly Connected Components (SCCs):");
    kosaRaju(graph, v);

  }

}