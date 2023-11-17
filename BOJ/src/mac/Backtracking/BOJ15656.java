package mac.Backtracking;

import java.io.*;
import java.util.*;

public class BOJ15656 {
    static int[] tmp = new int[7];
    static StringBuilder sb = new StringBuilder();

    static void dfs(int[] arr, int cnt, int M) {
        if (cnt == M) {
            for(int i=0; i<M; i++) {
				sb.append(tmp[i] + " ");
			}
			sb.append("\n");
            return;
        } else {
            for (int i = 0; i < arr.length; i++) {
                tmp[cnt] = arr[i];
                dfs(arr, cnt+1, M);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        while(st2.hasMoreTokens()) arr[idx++] = Integer.parseInt(st2.nextToken());
        Arrays.sort(arr);

        dfs(arr, 0, M);
        System.out.println(sb);
    }
}
