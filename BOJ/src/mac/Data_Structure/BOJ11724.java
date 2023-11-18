package mac.Data_Structure;

import java.io.*;
import java.util.*;

public class BOJ11724 {
    static int N, M;

    static boolean[] visited;
    static boolean[][] graph;

    static void dfs(int start) {
        visited[start] = true;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[start][i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        graph = new boolean[N+1][N+1];
        int ans = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            graph[u][v] = true;
            graph[v][u] = true;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                ans++;
            }
        }
        System.out.println(ans);
        br.close();
    }
}