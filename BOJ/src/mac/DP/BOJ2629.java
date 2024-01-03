package mac.DP;

import java.io.*;
import java.util.*;

public class BOJ2629 {
    static int MAX = 80001;
    static int ZERO = MAX / 2;
    // idx == real + 40000
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int numberOfWeights = Integer.parseInt(br.readLine());

        int[] weights = new int[numberOfWeights];
        boolean[][] dp = new boolean[numberOfWeights + 1][MAX + 1];
        dp[0][ZERO] = true;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= numberOfWeights; i++) {
            int weight = Integer.parseInt(st.nextToken());
            weights[i - 1] = weight;

            dp[i][ZERO] = true;
            for(int j = 0; j <= MAX; j++) {
                if(!dp[i - 1][j]) continue;

                dp[i][j] = true;

                if(j - weight >= 0) dp[i][j - weight] = true;
                if(j + weight <= MAX) dp[i][j + weight] = true;
            }
        }


        int numberOfBalls = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < numberOfBalls; i++) {
            String isPossible = null;
            int value = Integer.parseInt(st.nextToken());

            if(dp[numberOfWeights][value + ZERO]) isPossible = "Y";
            else isPossible = "N";

            sb.append(isPossible + " ");
        }

        System.out.println(sb);
        br.close();
    }
}