package DnC;

import java.io.*;
import java.util.*;

public class BOJ1780 {
    static int N;
    static int[][] PAPER;
    static int MINUSONES, ZEROS, ONES;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PAPER = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                PAPER[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);
        
        System.out.println(MINUSONES);
        System.out.println(ZEROS);
        System.out.println(ONES);

        br.close();
    }
    private static void partition(int row, int col, int size) {
        int check = PAPER[row][col];
        int newSize = size/3;
        if(checkNum(check, row, col, size)) {
            switch (check) {
                case 1: ONES++;
                    break;
                case 0: ZEROS++;
                    break;
                default: MINUSONES++;
                    break;
            }
        } else {
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    partition(row + i * newSize, col + j * newSize, newSize);
                }
            }
        }
    }
    private static boolean checkNum(int check, int row, int col, int size) {
        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(check != PAPER[i][j]) return false;
            }
        }

        return true;
    }
}
