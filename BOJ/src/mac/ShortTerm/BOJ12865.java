// GOLD 5
// 평범한 배낭
package mac.ShortTerm;

import java.io.*;
import java.util.*;

public class BOJ12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] items = new int[N][2];
        int[][] dp = new int[N+1][K+1];

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(stk.nextToken());
            items[i][1] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                int weight = items[i-1][0];
                int value = items[i-1][1];
                if (weight > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    int tmp1 = dp[i-1][j-weight] + value;
                    int tmp2 = dp[i-1][j];
                    dp[i][j] = tmp1 > tmp2 ? tmp1 : tmp2;
                }
            }
        }
        
        System.out.println(dp[N][K]);
        br.close();
    }
}