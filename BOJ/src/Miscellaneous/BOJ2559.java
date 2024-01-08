package Miscellaneous;

import java.io.*;
import java.util.*;

public class BOJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int sum = 0;
        int ans = 0;

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            sum += Integer.parseInt(stk.nextToken());
            arr[i] = sum;
            if(i == K) {
                ans = arr[K] - arr[i-K];
            }
            else if(i > K) {
                ans = Math.max(ans, arr[i]-arr[i-K]);
            }
        }

        System.out.println(ans);
        br.close();
    }
}
