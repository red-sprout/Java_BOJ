package Backtracking;

import java.io.*;
import java.util.*;

public class BOJ18290 {
    static int max = -40001;
    static int[][] cord = new int[4][2];
    static boolean[][] visited = new boolean[12][12];

    static void dfs(int N, int M, int K, int cnt, int[][] board) {
        if (K == cnt) {
            int sum = 0;
            for (int i = 0; i < K; i++) {
                sum += board[cord[i][0]][cord[i][1]];
            }
            max = max < sum ? sum : max;
            return;
        } else {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    boolean flag = true;
                    if (visited[i-1][j]) flag = false;
                    else if (visited[i+1][j]) flag = false;
                    else if (visited[i][j+1]) flag = false;
                    else if (visited[i][j-1]) flag = false;
                    if (!visited[i][j] && flag) {
                        cord[cnt][0] = i-1;
                        cord[cnt][1] = j-1;
                        visited[i][j] = true;
                        dfs(N, M, K, cnt+1, board);
                        visited[i][j] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        dfs(N, M, K, 0, board);
        System.out.println(max);
    }
}
