package mac.DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ2178 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static int N, M;
    static Queue<int[]> q;

    static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowRow = now[0];
            int nowCol = now[1];
            for (int i = 0; i < 4; i++) {
                int r = nowRow + dr[i];
                int c = nowCol + dc[i];
                if (r < 0 || c < 0 || r >= N || c >= M) {
                    continue;
                }
                if (visited[r][c] || map[r][c] == 0) {
                    continue;
                }
                q.add(new int[] {r,c});
                map[r][c] = map[nowRow][nowCol] + 1;
                visited[r][c] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }

		visited[0][0] = true;
        bfs(0,0);
        System.out.println(map[N-1][M-1]);
    }
}