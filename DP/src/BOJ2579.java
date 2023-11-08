import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ2579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n+1];
        int[] dp = new int[n+1];
        stair[0] = 0;
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (i == 1) dp[i] = stair[i];
            else if (i == 2) dp[i] = dp[i-1] + stair[i];
            else if (i == 3) {
                int tmp1 = stair[i] + stair[i-2];
                int tmp2 = stair[i] + stair[i-1];
                dp[i] = tmp1 > tmp2 ? tmp1 : tmp2;
            } else {
                int tmp1 = stair[i] + dp[i-2];
                int tmp2 = stair[i] + stair[i-1] + dp[i-3];
                dp[i] = tmp1 > tmp2 ? tmp1 : tmp2;
            }
        }

        System.out.println(dp[n]);
    }
}
