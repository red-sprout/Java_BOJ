package DnC;

import java.io.*;
import java.util.*;

public class BOJ2630 {
    static int N;
    static int[] ans = new int[2];
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        traversal(0, 0, N);
        System.out.println(ans[0]);
        System.out.println(ans[1]);

        br.close();
    }
    private static void traversal(int row, int col, int size) {
        int color = paper[row][col];
        if(colorCheck(row, col, size)) {
            ans[color] += 1;
            return;
        }
        int newSize = size / 2;
        traversal(row, col, newSize);
		traversal(row, col + newSize, newSize);
		traversal(row + newSize, col, newSize);
		traversal(row + newSize, col + newSize, newSize);
    }
    private static boolean colorCheck(int row, int col, int size) {
        int color = paper[row][col];

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(color != paper[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}