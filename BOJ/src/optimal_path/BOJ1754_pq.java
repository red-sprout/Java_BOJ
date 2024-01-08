package optimal_path;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int idx;
    int distance;

    public Node(int idx, int distance) {
        this.idx = idx;
        this.distance = distance;
    }

    public int compareTo(Node n) {
        return this.distance - n.distance;
    }
}

public class BOJ1754_pq {
    static int v, e;
    static List<List<Node>> graph;
    static int[] dist;
    static boolean[] visited;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        dist = new int[v + 1];
        visited = new boolean[v + 1];

        graph = new ArrayList<List<Node>>();
        graph.add(new ArrayList<Node>());
        for(int i = 1; i <= v; i++) {
            graph.add(new ArrayList<Node>());
        }

        int start = Integer.parseInt(br.readLine());

        for(int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
        }
        
        for(int i = 0; i <= v; i++) {
            dist[i] = INF;
        }

        dijkstra(start);

        for(int i = 1; i <= v; i++) {
            if(dist[i] == INF) sb.append("INF" + "\n");
            else sb.append(String.valueOf(dist[i]) + "\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static void dijkstra(int start) {
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()) {
            int now = pq.poll().idx;

            if(visited[now]) continue;
            visited[now] = true;

            for(Node next : graph.get(now)) {
                if(dist[next.idx] > dist[now] + next.distance) {
                    dist[next.idx] = dist[now] + next.distance;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }
}