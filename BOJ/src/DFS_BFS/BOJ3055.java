package DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ3055 {
    static int R,C;
    static boolean completed = false;
    static char[][] map;
    static int[][] movement;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] start = {0, 0};
    static int[] destination = {0, 0};
    static Queue<int[]> q1 = new LinkedList<>();
    static Queue<int[]> q2 = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        movement = new int[R][C];

        for(int i = 0; i < R; i++) {
            String row = br.readLine();
            for(int j = 0; j < C; j++) {
                char tmp = row.charAt(j);
                map[i][j] = tmp;
                if(tmp == '*') {
                    movement[i][j] = -1;
                } else if(tmp == 'D') {
                    destination[0] = i;
                    destination[1] = j;
                } else if(tmp == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        int cnt = 0;
        q1.add(start);

        while(!completed && cnt < (R * C)) {
            cnt++;

            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    mapUpdate(i, j);
                }
            }

            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if(movement[i][j] == -1) {
                        map[i][j] = '*';
                    }
                }
            }

            while(!q1.isEmpty()) {
                bfs(cnt);
            }

            while(!q2.isEmpty()) {
                q1.add(q2.poll());
            }
        }

        if(!completed) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(cnt);
        }

        br.close();
    }

    private static void bfs(int distance) {
        int[] cord = q1.poll();
        int row = cord[0];
        int col = cord[1];
        for(int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];
            if(newRow < 0 || newCol < 0) continue;
            if(newRow >= R || newCol >= C) continue;
            if(movement[newRow][newCol] != 0) continue;
            if(map[newRow][newCol] == 'X') continue;
            movement[newRow][newCol] = distance;
            q2.add(new int[] {newRow, newCol});
            if(map[newRow][newCol] == 'D') {
                completed = true;
                return;
            }
        }
    }

    private static void mapUpdate(int row, int col) {
        if(map[row][col] == '*') {
            for(int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];
                if(newRow < 0 || newCol < 0) continue;
                if(newRow >= R || newCol >= C) continue;
                if(map[newRow][newCol] == 'D' || map[newRow][newCol] == 'X') continue;
                movement[newRow][newCol] = -1;
            }
        }
    }
}