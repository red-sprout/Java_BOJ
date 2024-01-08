package DP;

import java.io.*;
import java.util.*;

public class BOJ1520 {
    static int INF = 10001;

    static int M, N;
    static int[][] map;
    static int[][] dp;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static int dfs(int x, int y) {
        if (x == M & y == N) {
            return 1;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int r = x + dr[i];
            int c = y + dc[i];
            if (map[r][c] < map[x][y]){
                dp[x][y] += dfs(r, c);
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st1.nextToken());
        N = Integer.parseInt(st1.nextToken());
        map = new int[M+2][N+2];
        dp = new int[M+2][N+2];

        for (int i = 0; i < M+2; i++) {
            map[i][0] = INF;
            map[i][N+1] = INF;
        }

        for (int j = 0; j < N+2; j++) {
            map[0][j] = INF;
            map[M+1][j] = INF;
        }

        for (int i = 1; i < M+1; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(1,1));
        br.close();
    }
}
