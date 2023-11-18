package mac.Data_Structure;

import java.io.*;
import java.util.*;

public class BOJ13023 {
    static int result = 0;
    static boolean[] visited = new boolean[2000];

    static void dfs(int cnt, int start, int N , ArrayList<Integer>[] list) {
        if (cnt == 5) {
            System.out.println(1);
            System.exit(0);
        } else if (result == 0){
            for (int i = 0; i < list[start].size(); i++){
                int idx = list[start].get(i);
                if (!visited[idx]) {
                    visited[idx] = true;
                    dfs(cnt+1, idx, N, list);
                    visited[idx] = false;
                }
            }       
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        ArrayList<Integer>[] list = new ArrayList[N];
        for (int i = 0; i < N; i++){
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        for (int i = 0; i < N; i++) dfs(0, i, N, list);
        System.out.println(result);
    }
}
