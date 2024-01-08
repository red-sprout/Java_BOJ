// 복습 필요
package graph;

import java.io.*;
import java.util.*;

public class BOJ2206 {
    static class Loc{
        int row;
        int col;
        int cnt;
        boolean destroyed;

        public Loc(int row, int col, int cnt, boolean destroyed) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.destroyed = destroyed;
        }
    }

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();
        br.close();
    }
    
    private static void bfs() {
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(0, 0, 1, false));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        boolean[][][] visited = new boolean[N][M][2];

        while (!q.isEmpty()) {
            Loc past = q.poll();

            if (past.row == N - 1 && past.col == M - 1) {
                System.out.println(past.cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nowRow = past.row + dr[i];
                int nowCol = past.col + dc[i];

                if(nowRow < 0 || nowRow >= N) continue;
                if(nowCol < 0 || nowCol >= M) continue;

                int nowCnt = past.cnt+1;

                if(map[nowRow][nowCol] == 0){
                    if(!past.destroyed && !visited[nowRow][nowCol][0]) {
                        q.add(new Loc(nowRow, nowCol , nowCnt, false));
                        visited[nowRow][nowCol][0] = true;
                    } else if(past.destroyed && !visited[nowRow][nowCol][1]){
                        q.add(new Loc(nowRow, nowCol , nowCnt, true));
                        visited[nowRow][nowCol][1] = true;
                    }
                    continue;
                }

                if(!past.destroyed){
                    q.add(new Loc(nowRow, nowCol , nowCnt, true));
                    visited[nowRow][nowCol][1] = true;
                }
            }
        }

        System.out.println(-1);
    }
}
