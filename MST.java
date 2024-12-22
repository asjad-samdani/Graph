import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST {
  static class Edge {
    int src, dest, weight;

    public Edge(int s, int d, int w) {
      this.src = s;
      this.dest = d;
      this.weight = w;
    }
  }

  public static void createGraph(ArrayList<Edge>[] graph) {
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

  static class Pair implements Comparable<Pair> {
    int node;
    int cost;

    public Pair(int node, int cost) {
      this.node = node;
      this.cost = cost;
    }

    @Override
    public int compareTo(Pair p2) {
      return this.cost - p2.cost;// ascending order
    }

  }

  public static void primAlgorith(ArrayList<Edge> graph[], int V) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();// non mst set
    boolean visit[] = new boolean[V];// mst set
    int mstCost = 0;
    pq.add(new Pair(0, 0));
    while (!pq.isEmpty()) {
      Pair curr = pq.remove();
      if (!visit[curr.node]) {
        visit[curr.node] = true;
        mstCost += curr.cost;
        for (Edge e : graph[curr.node]) {
          if (!visit[e.dest]) {
            pq.add(new Pair(e.dest, e.weight));
          }
        }
      }
    }
    System.out.println("min cost of mst : " + mstCost);
  }

  public static void main(String[] args) {
    int V = 4;
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph);
    primAlgorith(graph, V);
  }

}
