package DnC;

import java.util.*;

public class BOJ11444 {
    static long N;
    static int MAX = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextLong();
        long[][] ANS = new long[2][1];
        long[][] A = {{1, 1}, {1, 0}};
        long[][] F0 = {{1}, {0}};

        ANS = multiply(pow(A, N), F0, 2, 2, 1);
        System.out.println(ANS[1][0]);

        sc.close();
    }

    private static long[][] pow(long[][] A, long exp) {
        if(exp == 1) {
            return A;
        } else {
            long[][] tmp = pow(A, exp / 2);
            if(exp % 2 == 1) {
                return multiply(multiply(tmp, tmp, 2, 2, 2), A, 2, 2, 2);
            } else {
                return multiply(tmp, tmp, 2, 2, 2);
            }
        }
    }

    private static long[][] multiply(long[][] FRONT, long[][] BACK, int ansRow, int tmp, int ansCol) {
        long[][] ANS = new long[ansRow][ansCol];
        for(int i = 0; i < ansRow; i++) {
            for(int j = 0; j < ansCol; j++) {
                for(int k = 0; k < tmp; k++) {
                    ANS[i][j] += FRONT[i][k] * BACK[k][j] % MAX;
                }
                ANS[i][j] = ANS[i][j] % MAX;
            }
        }
        return ANS;
    }
}
