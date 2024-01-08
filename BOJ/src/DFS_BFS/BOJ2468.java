package DFS_BFS;

import java.util.*;
import java.io.*;

public class BOJ2468 {
    static int N;
    static int maxHeight = 0;
    static int minHeight = 101;
    static int maxRegion = 1;
    static int[][] region;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        region = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int ele = Integer.parseInt(st.nextToken());
                maxHeight = maxHeight < ele ? ele : maxHeight;
                minHeight = minHeight > ele ? ele : minHeight;
                region[i][j] = ele;
            }
        }

        for (int h = minHeight; h < maxHeight; h++) {
            visited = new boolean[N][N];
            int tmpRegion = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (region[i][j] <= h) visited[i][j] = true;
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        tmpRegion++;
                        dfs(i, j);
                    }
                }
            }
            maxRegion = maxRegion < tmpRegion ? tmpRegion : maxRegion;
        }

        System.out.println(maxRegion);
        br.close();
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nowRow = row + dr[i];
            int nowCol = col + dc[i];
            if (nowRow < 0 || nowRow >= N) continue;
            if (nowCol < 0 || nowCol >= N) continue;
            if (visited[nowRow][nowCol]) continue;
            dfs(nowRow, nowCol);
        }
    }
}