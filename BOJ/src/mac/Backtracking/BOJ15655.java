package mac.Backtracking;
import java.io.*;
import java.util.*;

public class BOJ15655 {
    static int[] tmp = new int[8];
    static boolean[] visited = new boolean[8];
    static StringBuilder sb = new StringBuilder();

    static void dfs(int[] arr, int start, int cnt, int M) {
        if (cnt == M) {
            for(int i=0; i<M; i++) {
				sb.append(tmp[i] + " ");
			}
			sb.append("\n");
            return;
        } else {
            for (int i = start; i < arr.length; i++) {
                if (!visited[i]) {
                    tmp[cnt] = arr[i];
                    visited[i] = true;
                    dfs(arr, i+1, cnt+1, M);
                    visited[i] = false;
                }
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

        dfs(arr, 0, 0, M);
        System.out.println(sb);
    }
}