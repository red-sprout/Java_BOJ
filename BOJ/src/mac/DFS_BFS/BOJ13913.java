package mac.DFS_BFS;

import java.util.*;

public class BOJ13913 {
    static int N, K;
    static int MAX;
    static int[] cnt;
    static int[] direction = {-1,1};
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        MAX = N < K ? 2*K+1 : 2*N+1;
        cnt = new int[MAX];
        visited = new boolean[MAX];
        bfs();
        int ans = cnt[K];
        System.out.println(ans);
        search(K, ans);
        System.out.println(sb);
        sc.close();
    }
    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        int past, present;
        visited[N] = true;
        while (!queue.isEmpty()) {
            past = queue.poll();

            for (int i = 0; i < 3; i++) {
                if (i == 2) present = past * 2;
                else present = past + direction[i];

                if (present < 0 || present >= MAX) continue;
                if (visited[present]) continue;

                queue.add(present);
                cnt[present] = cnt[past] + 1;
                visited[present] = true;
            }
        }
    }
    static void search(int num, int idx) {
        stack.push(num);
        if (idx == 0) {
            while (!stack.isEmpty()) {
                sb.append(String.valueOf(stack.pop()));
                sb.append(" ");
            }
            return;
        } else {
            if (num % 2 == 1) {
                if (cnt[num+1] == idx-1) {
                    search(num+1, idx-1);
                } else {
                    search(num-1, idx-1);
                }
            } else {
                if (cnt[num+1] == idx-1) {
                    search(num+1, idx-1);
                } else if (cnt[num-1] == idx-1) {
                    search(num-1, idx-1);
                } else {
                    search(num/2, idx-1);
                }
            }
        }
    }
}
