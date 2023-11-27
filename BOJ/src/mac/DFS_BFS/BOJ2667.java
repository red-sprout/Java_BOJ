package mac.DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ2667 {
    static int N, cntSection, cntHouse;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+2][N+2];
        visited = new boolean[N+2][N+2];

        for (int i = 1; i <= N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 1; j <= N; j++) {
                map[i][j] = tmp[j-1] - '0';
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    cntSection++;
                    list.add(cntHouse);
                    cntHouse = 0;
                }
            }
        }

        System.out.println(cntSection);
        list.sort(Comparator.naturalOrder());
        for (int i = 0; i < cntSection; i++) {
            System.out.println(list.get(i));
        }
        br.close();
    }

    private static void dfs(int row, int col) {
        cntHouse++;
        int cord = map[row][col];
        visited[row][col] = true;
        if (cord == 0) return;
        else {
            for (int i = 0; i < 4; i++) {
                int nowRow = row + dr[i];
                int nowCol = col + dc[i];
                if (map[nowRow][nowCol] != 0 && !visited[nowRow][nowCol]) {
                    visited[nowRow][nowCol] = true;
                    dfs(nowRow, nowCol);
                }
            }
        }
    }
}
