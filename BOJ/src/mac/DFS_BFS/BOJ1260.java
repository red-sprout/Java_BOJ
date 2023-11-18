package mac.DFS_BFS;
// DFS & BFS 가장 기초!
import java.io.*;
import java.util.*;

public class BOJ1260 {
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q = new LinkedList<>();

    static boolean[] visited;
    static boolean[][] arr;
    static int N, M, V;

    static void dfs(int node) {
        visited[node] = true;
        sb.append(node + " ");
        for (int i = 1; i <= N; i++) {
            if (arr[node][i] && !visited[i]) {
                dfs(i);
            }
        }
    }
    static void bfs(int node) {
        visited[node] = true;
        q.add(node);
        while(!q.isEmpty()) {
            node = q.poll();
            for (int i = 1; i <= N; i++) {
                if (arr[node][i] && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
            sb.append(node + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());

            arr[x][y] = true;
            arr[y][x] = true;
        }

        dfs(V);
        sb.append('\n');
        visited = new boolean[N+1];
        bfs(V);

        System.out.println(sb);
    }
}
