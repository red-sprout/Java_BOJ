package Miscellaneous;

import java.io.*;
import java.util.*;

public class BOJ10986 {
    static int N, M;
    static long[] R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = new long[M];
        R[0] = 1;

        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for(int i = 1; i <= N; i++){
            sum = (sum + Long.parseLong(st.nextToken())) % M;
            R[(int)sum]++;
        }

        long ans = 0;
        for(int i = 0; i < M; i++) {
            ans += select(R[i]);
        }
        System.out.println(ans);

        br.close();
    }
    private static long select(long n) {
        if(n < 2) return 0;
        return n * (n - 1) / 2;
    }
}