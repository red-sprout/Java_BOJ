package Backtracking;
import java.io.*;
import java.util.*;

public class BOJ1182 {
    static int result;
    static int ans;

    static void dfs(int[] arr, int S, int idx, int n) {
        if (result == S && idx == n) {
            ans++;
            return;
        } else {
            for (int i = idx; i < n; i++) {
                result += arr[i];
                dfs(arr, S, i+1, n);
                result -= arr[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int S = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st2.nextToken());
        for(int i = 1; i <= N; i++) {
            dfs(arr, S, 0, i);
        }
        System.out.println(ans);
        br.close();
    }
}
