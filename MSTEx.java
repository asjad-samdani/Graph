import java.util.ArrayList;
import java.util.PriorityQueue;

class MSTEx {
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
    int cost;

    public Pair(int n, int c) {
      this.node = n;
      this.cost = c;
    }

    @Override
    public int compareTo(Pair o) {
      return this.cost - o.cost;
    }
  }

  public static void primsAlgorithm(ArrayList<Edge> graph[], int v) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    boolean visit[] = new boolean[v];
    pq.add(new Pair(0, 0));
    ArrayList<Edge> mstEdges = new ArrayList<>(); // To store edges in the MST
    int minCost = 0;

    while (!pq.isEmpty()) {
      Pair curr = pq.poll();
      if (!visit[curr.node]) {
        visit[curr.node] = true;
        minCost += curr.cost;

        // Explore neighbors
        for (Edge e : graph[curr.node]) {
          if (!visit[e.dest]) {
            pq.add(new Pair(e.dest, e.wt));
            mstEdges.add(new Edge(curr.node, e.dest, e.wt)); // Add the edge to MST
          }
        }
      }
    }

    System.out.println("Edges in the Minimum Spanning Tree (MST):");
    for (Edge e : mstEdges) {
      System.out.println("Edge: " + e.src + " - " + e.dest + " with weight: " + e.wt);
    }

    System.out.println("Total cost of MST: " + minCost);
  }

  public static void createGraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1, 10));
    graph[0].add(new Edge(0, 3, 30));
    graph[0].add(new Edge(0, 2, 15));
    graph[1].add(new Edge(1, 0, 10));
    graph[1].add(new Edge(1, 3, 40));
    graph[2].add(new Edge(2, 0, 15));
    graph[2].add(new Edge(2, 3, 50));
    graph[3].add(new Edge(3, 1, 40));
    graph[3].add(new Edge(3, 2, 50));
  }

  public static void main(String[] args) {
    int V = 4;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);
    primsAlgorithm(graph, V);
  }
}
