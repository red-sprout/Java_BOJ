package mac.graph;

import java.io.*;
import java.util.*;

public class BOJ1012 {
    static int M, N, K;
    static boolean[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int cnt = 0;
            map = new boolean[M][N];

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = true;
            }

            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    if(!map[i][j]) continue;
                    cnt++;
                    dfs(i, j); 
                }
            }

            System.out.println(cnt);
        }
    }

    private static void dfs(int x, int y) {
        map[x][y] = false;
        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX < 0 || newX >= M) continue;
            if(newY < 0 || newY >= N) continue;
            if(map[newX][newY]) {
                dfs(newX, newY);
            }
        }
    }
}
