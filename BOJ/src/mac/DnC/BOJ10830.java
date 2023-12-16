package mac.DnC;

import java.io.*;
import java.util.*;

public class BOJ10830 {
    static int N;
    static int MAX = 1000;

    static long B;
    static long[][] A, ANSWER;

    static StringTokenizer row;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        A = new long[N][N];

        for(int i = 0; i < N; i++) {
            row = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                A[i][j] = Long.parseLong(row.nextToken());
            }
        }

        ANSWER = pow(B);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(ANSWER[i][j] + " ");
            }
            System.out.println();
        }

        br.close();
    }

    private static long[][] pow(long exponent) {
        if(exponent == 1) {
            return multiply(A);
        } else {
            long[][] tmp = pow(exponent / 2);
            if(exponent % 2 == 1) {
                return multiply(multiply(tmp, tmp), A);
            } else {
                return multiply(tmp, tmp);
            }
        }
    }

    private static long[][] multiply(long[][] FRONT) {
        long[][] ANS = new long[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                ANS[i][j] = FRONT[i][j] % MAX;
            }
        }
        return ANS;
    }

    private static long[][] multiply(long[][] FRONT, long[][] BACK) {
        long[][] ANS = new long[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    ANS[i][j] += FRONT[i][k] * BACK[k][j] % MAX;
                }
                ANS[i][j] = ANS[i][j] % MAX;
            }
        }
        return ANS;
    }
}
