package mac.DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ2606 {
    static int nodeCnt, lineCnt, ans;
    static boolean[][] graph;
    static boolean[] visited;

    static void dfs(int node) {
        visited[node] = true;
        for (int i = 1; i <= nodeCnt; i++) {
            if (graph[node][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nodeCnt = Integer.parseInt(br.readLine());
        lineCnt = Integer.parseInt(br.readLine());
        graph = new boolean[nodeCnt+1][nodeCnt+1];
        visited = new boolean[nodeCnt+1];

        for (int i = 0; i < lineCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            graph[startNode][endNode] = graph[endNode][startNode] = true;
        }

        dfs(1);
        for (int i = 2; i <= nodeCnt; i++) {
            if (visited[i]) ans++;
        }

        System.out.println(ans);
    }
}