package mac.Backtracking;

import java.io.*;
import java.util.*;

public class BOJ15663 {
    static int N, M;
    static int MAX = 10001;
    static int[] ans;
    static int[] cand = new int[MAX];
    static boolean[] promising = new boolean[MAX];
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            promising[idx] = true;
            cand[idx]++;
        }

        dfs(0);

        System.out.print(sb);
        br.close();
    }

    private static void dfs(int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(String.valueOf(ans[i]) + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < MAX; i++) {
            if(promising[i]) {
                cand[i]--;
                ans[depth] = i;
                if(cand[i] == 0) promising[i] = false;
                dfs(depth + 1);
                promising[i] = true;
                cand[i]++;
            }
        }
    }
}
