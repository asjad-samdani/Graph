package Prac;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Edge {
  int src;
  int dest;

  public Edge(int s, int d) {
    this.src = s;
    this.dest = d;

  }

}

public class CreateGraph {

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

  public static void bfs(ArrayList<Edge> graph[]) {
    Queue<Integer> queue = new LinkedList<>();
    boolean visited[] = new boolean[graph.length];
    queue.add(0); // src
    while (!queue.isEmpty()) {
      int curr = queue.remove();
      if (!visited[curr]) {
        visited[curr] = true;
        System.out.print(curr + " ");
      }
      for (Edge edge : graph[curr]) {
        queue.add(edge.dest);
      }
    }
  }

  public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
    vis[curr] = true;
    System.out.print(curr + " ");
    for (Edge edge : graph[curr]) {
      if (!vis[edge.dest]) {
        dfs(graph, edge.dest, vis);
      }

    }
  }

  public static void print(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      for (Edge edge : graph[i]) {
        System.out.print(edge.dest + "-> ");
      }
      System.out.println();
    }

  }

  public static void main(String[] args) {
    int V = 7;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph, V);

    System.out.println("BFS Traversal starting from vertex 0:");
    bfs(graph);
    System.out.println();

    System.out.println("DFS Traversal starting from vertex 0:");
    dfs(graph, 0, new boolean[V]);
  }

}
