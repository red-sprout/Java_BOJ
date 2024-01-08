package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ12865 {
    public static void main(String[] args) throws IOException{
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][K + 1];
        int[][] bag = new int[N + 1][2];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            bag[i][0] = Integer.parseInt(st.nextToken());
            bag[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i <= N; i++) {
            int w = bag[i][0];
            int v = bag[i][1];

            for(int j = 1; j <= K; j++) {
                if(w > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                }
            }
        }

        System.out.println(dp[N][K]);
        br.close();
    }
}