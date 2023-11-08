import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ2294 {
    static int INF = 100001;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= k; j++) {
                if (i == 0) {
                    dp[i][j] = INF;
                    continue;
                } else if (j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                int c = coins[i-1];
                if (c > j) dp[i][j] = dp[i-1][j];
                else {
                    int tmp1 = dp[i-1][j];
                    int tmp2 = dp[i][j-c]+1;
                    dp[i][j] = tmp1 > tmp2 ? tmp2 : tmp1;
                }
            }
        }

        int ans = dp[n][k] == INF ? -1 : dp[n][k];
        System.out.println(ans);
    }
}
