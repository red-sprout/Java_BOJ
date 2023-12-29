package mac.DP;

import java.io.*;
import java.util.*;

public class BOJ11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int tmp = 0;
            int K = Integer.parseInt(br.readLine());
            int[] sumArray = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= K; i++) {
                tmp += Integer.parseInt(st.nextToken());
                sumArray[i] = tmp;
            }

            for (int i = 1; i <= K; i++) {
                for (int j = 1; i + j <= K; j++) {
                    dp[j][i + j] = Integer.MAX_VALUE;
                    for (int k = j; k < i + j; k++) {
                        dp[j][i + j] = Math.min(dp[j][i + j], dp[j][k] + dp[k + 1][i + j] + sumArray[i + j] - sumArray[j - 1]);
                    }
                }
            }

            System.out.println(dp[1][K]);
        }
    }
}