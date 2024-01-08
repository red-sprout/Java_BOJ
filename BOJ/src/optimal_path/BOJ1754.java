package optimal_path;

import java.io.*;
import java.util.*;

class Node{
    int idx;
    int distance;

    public Node(int idx, int distance) {
        this.idx = idx;
        this.distance = distance;
    }
}

public class BOJ1754 {
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
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, cost));
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
        for(int i = 1; i <= v; i++) {
            int nodeCost = INF;
            int nodeIdx = 0;
            for(int j = 1; j <= v; j++) {
                if(!visited[j] && dist[j] < nodeCost) {
                    nodeCost = dist[i];
                    nodeIdx = j;
                }
            }

            visited[nodeIdx] = true;

            for(int j = 0; j < graph.get(nodeIdx).size(); j++) {
                Node nextNode = graph.get(nodeIdx).get(j);
                if(dist[nextNode.idx] > dist[nodeIdx] + nextNode.distance) {
                    dist[nextNode.idx] = dist[nodeIdx] + nextNode.distance;
                }
            }
        }
    }
}