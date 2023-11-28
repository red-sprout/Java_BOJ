package mac.DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ2573 {
    static int N, K, year;
    static int startRow, startCol;
    static int[][] map, tmp;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][K];

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        while (true) {
            boolean flag = true;
            tmp = new int[N][K];
            visit = new boolean[N][K];
            flag = search(flag);

            if (flag) {
                System.out.println(0);
                break;
            }

            bfs();

            boolean flag2 = check();

            if (flag2) {
                System.out.println(year);
                break;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < K; j++) {
                    map[i][j] = tmp[i][j];
                }
            }

            year++;
        }
        
        br.close();
    }
    
    static boolean search(boolean flag) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                tmp[i][j] = map[i][j];

                if (map[i][j] != 0) {
                    flag = false;
                    visit[i][j] = true;
                    int cnt = 0;

                    for (int k = 0; k < 4; k++) {
                        if (map[i + dr[k]][j + dc[k]] == 0) cnt++;
                    }

                    tmp[i][j] = map[i][j] - cnt > 0 ? map[i][j] - cnt : 0;

                    startRow = i;
                    startCol = j;
                }
            }
        }
        return flag;
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {startRow, startCol});
        visit[startRow][startCol] = false;

        while (!q.isEmpty()) {
            int[] cord = q.poll();
            int pastRow = cord[0];
            int pastCol = cord[1];

            for (int i = 0; i < 4; i++) {
                int nowRow = pastRow + dr[i];
                int nowCol = pastCol + dc[i];

                if (!visit[nowRow][nowCol]) continue;
                
                q.add(new int[] {nowRow, nowCol});
                visit[nowRow][nowCol] = false;
            }
        }
    }

    static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                if (visit[i][j]) return true;
            }
        }
        return false;
    }
}
