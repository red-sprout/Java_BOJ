package mac.Miscellaneous;

import java.io.*;
import java.util.*;

public class BOJ2740 {
    static int N, M, K;
    static int[][] A, B, ANS;
    static StringTokenizer st, row;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];

        for(int i = 0; i < N; i++) {
            row = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(row.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = new int[M][K];
        ANS = new int[N][K];

        for(int i = 0; i < M; i++) {
            row = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(row.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K; j++) {
                for(int k = 0; k < M; k++) {
                    ANS[i][j] += A[i][k] * B[k][j];
                }
                sb.append(String.valueOf(ANS[i][j]));
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}