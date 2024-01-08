package DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ14503 {
    static int N, M;
    static int initRow, initCol, initTo;
    static int[][] map;
    static int ans;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    // 방향: 0 - 북쪽, 1 - 동쪽, 2 - 남쪽, 3 - 서쪽
    // map: 0 - 청소해야 될 빈칸 1 - 벽
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        map = new int[N][M];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        initRow = Integer.parseInt(st2.nextToken());
        initCol = Integer.parseInt(st2.nextToken());
        initTo = Integer.parseInt(st2.nextToken());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int row = initRow;
        int col = initCol;
        int toward = initTo;

        while(true) {
            if(map[row][col] == 1) {
                break;
            }
            else if(map[row][col] == 0) {
                map[row][col] = -1;
                ans++;
            }

            boolean flag = true;
            for(int i = toward + 3; i >= toward; i--) {
                int checkRow = row + dr[i % 4];
                int checkCol = col + dc[i % 4];
                if(map[checkRow][checkCol] == 0) {
                    row = checkRow;
                    col = checkCol;
                    toward = i % 4;
                    flag = false;
                    break;
                }
            }
            if(flag) {
                row = row - dr[toward];
                col = col - dc[toward];
            }

        }

        System.out.println(ans);
        br.close();
    }
}
