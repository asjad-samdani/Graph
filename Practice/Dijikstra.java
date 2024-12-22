import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijikstra {
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

  static class Pair implements Comparable<Pair> {
    int node;
    int dest;

    public Pair(int n, int d) {
      this.node = n;
      this.dest = d;
    }

    @Override
    public int compareTo(Pair p2) {
      return this.dest = p2.dest;

    }

  }

  public static void dijkstra(ArrayList<Edge> graph[], int src, int V) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    boolean vis[] = new boolean[V];
    int dist[] = new int[V];
    for (int i = 0; i < V; i++) {
      if (i != src) {
        dist[i] = Integer.MAX_VALUE;

      }
    }
    pq.add(new Pair(0, 0));
    while (!pq.isEmpty()) {
      Pair curr = pq.remove();
      vis[curr.node] = true;
      for (Edge e : graph[curr.node]) {
        int u = e.src;
        int v = e.dest;
        // Relexation
        if (dist[u] + e.wt < dist[v]) {
          dist[v] = dist[u] + e.wt;
          pq.add(new Pair(v, dist[v]));

        }
      }

    }
    for (int i = 0; i < V; i++) {
      System.out.println("Node: " + i + " Distance: " + dist[i]);
    }
    System.out.println();
  }

  public static void createGraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }
    // 0-vertex
    graph[0].add(new Edge(0, 1, 2));
    graph[0].add(new Edge(0, 2, 4));
    // 1-vertex
    graph[1].add(new Edge(1, 3, 7));
    graph[1].add(new Edge(1, 2, 1));
    // 2-vertex
    graph[2].add(new Edge(2, 4, 3));
    // 3-vertex
    graph[3].add(new Edge(3, 5, 1));

    // 4- vertex
    graph[4].add(new Edge(4, 3, 2));
    graph[4].add(new Edge(4, 5, 5));

  }

  public static void main(String[] args) {
    int v = 6;
    ArrayList<Edge> graph[] = new ArrayList[v];
    createGraph(graph);
    dijkstra(graph, 0, v);

  }

}
