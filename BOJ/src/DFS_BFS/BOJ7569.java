package DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ7569 {
    static int M, N, H;
    static int period = 0;
    static int[][][] tomato;
    static boolean flag = false, flag2 = true;
    static int[] dm = {-1,1,0,0,0,0};
    static int[] dn = {0,0,-1,1,0,0};
    static int[] dh = {0,0,0,0,-1,1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[M][N][H];

        for (int k = 0; k < H; k++) {
            for (int j = 0; j < N; j++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                for (int i = 0; i < M; i++) {
                    int value = Integer.parseInt(stk.nextToken());
                    tomato[i][j][k] = value;
                    if (value == 1) {
                        flag = true;
                        q.add(new int[] {i, j, k});
                    } else if (value == 0) {
                        flag2 = false;
                    }
                }
            }
        }

        if (!flag) {
            System.out.println(-1);
            return;
        } else if (flag2) {
            System.out.println(0);
            return;
        }

        bfs();
        
        boolean flag3 = true;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < H; k++) {
                    period = tomato[i][j][k] > period ? tomato[i][j][k] :period;
                    if (tomato[i][j][k] == 0) {
                        flag3 = false;
                        break;
                    }
                }
            }
        }

        if (flag3) {
            System.out.println(period-1);
        } else {
            System.out.println(-1);
        }
        
        br.close();
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] cord = q.poll();
            for (int i = 0; i < 6; i++) {
                int nowM = cord[0] + dm[i];
                int nowN = cord[1] + dn[i];
                int nowH = cord[2] + dh[i];
                if (nowM < 0 || nowN < 0 || nowH < 0) continue;
                if (nowM >= M || nowN >= N || nowH >= H) continue;
                if (tomato[nowM][nowN][nowH] != 0) continue;
                tomato[nowM][nowN][nowH] = tomato[cord[0]][cord[1]][cord[2]] + 1;
                q.add(new int[] {nowM, nowN, nowH});
            }
        }
    }
}
