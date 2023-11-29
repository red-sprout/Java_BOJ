package mac.DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ2644 {
    static int n, chons;
    static int start, end;
    static boolean flag;
    static boolean[] visited;
    static boolean[][] family;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        family = new boolean[n+1][n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m ; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            family[x][y] = family[y][x] = true;
        }

        visited[start] = true;
        dfs(start, 0);

        int ans = flag ? chons : -1;
        System.out.println(ans);
    }

    static void dfs(int node, int cnt) {
        if (node == end) {
            flag = true;
            chons = cnt;
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && family[node][i]) {
                    visited[i] = true;
                    dfs(i, cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
