package Brute_Force;
import java.util.*;
import java.io.*;

public class BOJ14500 {
    static int sum;
    static void flip_top(int[][] paper, int N, int M) {
        for (int i = 0 ; i < N / 2; i++) {
            for (int j = 0; j < M; j++) {
                int tmp = paper[i][j];
                paper[i][j] = paper[N-i-1][j];
                paper[N-i-1][j] = tmp;
            }
        }
    }
    static void flip_left(int[][] paper, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int tmp = paper[i][j];
                paper[i][j] = paper[i][M-j-1];
                paper[i][M-j-1] = tmp;
            }
        }
    }
    static void rotation(int[][] paper, int[][] rot, int N, int M) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                rot[i][j] = paper[N-j-1][i];
            }
        }
    }
    static void case_1(int[][] paper, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M - 3; j++) {
                int tmp = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i][j+3];
                if (sum < tmp) sum = tmp;
            }
        }
    }
    static void case_2(int[][] paper, int N, int M) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                int tmp = paper[i][j] + paper[i][j+1] + paper[i+1][j] + paper[i+1][j+1];
                if (sum < tmp) sum = tmp;
            }
        }
    }
    static void case_3(int[][] paper, int N, int M) {
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                int tmp = paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+2][j+1];
                if (sum < tmp) sum = tmp;
            }
        }
    }
    static void case_4(int[][] paper, int N, int M) {
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                int tmp = paper[i][j] + paper[i+1][j] + paper[i+1][j+1] + paper[i+2][j+1];
                if (sum < tmp) sum = tmp;
            }
        }
    }
    static void case_5(int[][] paper, int N, int M) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                int tmp = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j+1];
                if (sum < tmp) sum = tmp;
            }
        }
    }
    static void tetromino(int[][] paper, int N, int M) {
        case_1(paper, N, M);
        case_2(paper, N, M);
        case_3(paper, N, M);
        case_4(paper, N, M);
        case_5(paper, N, M);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int[][] paper = new int[N][M];
        int[][] rot = new int[M][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) paper[i][j] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                tetromino(paper, N, M);
                flip_left(paper, N, M);
                tetromino(paper, N, M);
                flip_left(paper, N, M);
                flip_top(paper, N, M);
                tetromino(paper, N, M);
                flip_top(paper, N, M);
                rotation(paper, rot, N, M);
            } else {
                tetromino(rot, M, N);
                flip_left(rot, M, N);
                tetromino(rot, M, N);
                flip_left(rot, M, N);
                flip_top(rot, M, N);
                tetromino(rot, M, N);
                flip_top(rot, M, N);
                rotation(rot, paper, M, N);
            }
        }
        System.out.println(sum);
        br.close();
    }
}
