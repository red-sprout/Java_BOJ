package mac.graph;

import java.io.*;
import java.util.*;

public class BOJ7562 {
    static int l;
    static int startRow, startCol, endRow, endCol;
    static int[] dr = {-2, 2, -2, 2, -1, 1, -1, 1};
    static int[] dc = {1, -1, -1, 1, 2, -2, -2, 2};
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase; i++) {
            l = Integer.parseInt(br.readLine());
            board = new int[l][l];

            st = new StringTokenizer(br.readLine());
            startRow = Integer.parseInt(st.nextToken());
            startCol = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endRow = Integer.parseInt(st.nextToken());
            endCol = Integer.parseInt(st.nextToken());

            bfs();
            System.out.println(board[endRow][endCol]);
        }
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {startRow, startCol});

        while(true) {
            int[] nowPos = q.poll();
            int nowRow = nowPos[0];
            int nowCol = nowPos[1];

            if(nowRow == endRow && nowCol == endCol) break;

            for(int i = 0; i < 8; i++) {
                int nextRow = nowRow + dr[i];
                int nextCol = nowCol + dc[i];

                if(nextRow < 0 || nextRow >= l) continue;
                if(nextCol < 0 || nextCol >= l) continue;
                if(board[nextRow][nextCol] != 0) continue;

                board[nextRow][nextCol] = board[nowRow][nowCol] + 1;
                q.add(new int[] {nextRow, nextCol});
            }
        }
    }
}
