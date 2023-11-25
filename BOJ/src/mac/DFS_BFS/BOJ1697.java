package mac.DFS_BFS;

import java.util.*;

public class BOJ1697 {
    static int N, K;
    static int[] walk = {-1,1};
    static int run = 2;
    static int MAX;
    static boolean[] visited;
    static int[] position;

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        while (!q.isEmpty()) {
            int past = q.poll();
            int present;
            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    present = past * run;
                } else {
                    present = past + walk[i];
                }
                if (present < 0 || present >= MAX) continue;
                if (visited[present]) continue;
                q.add(present);
                position[present] = position[past] + 1;
                visited[present] = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        MAX = K > N ? 2 * K + 1 : 2 * N + 1;
        visited = new boolean[MAX];
        position = new int[MAX];
        if (N == K) {
            System.out.println(0);
            System.exit(0);
        }
        bfs();
        System.out.println(position[K]);
        sc.close();
    }
}
