package mac.DFS_BFS;

import java.util.*;

public class BOJ5014 {
    static int F, S, G, U, D;
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();
        visited = new int[F+1];
        for (int i = 0; i <= F; i++) {
            visited[i] = -1;
        }

        bfs();

        int ans = visited[G];
        if (ans == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(ans);
        }
        sc.close();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        visited[S] = 0;
        while(!q.isEmpty()) {
            int floor = q.poll();
            int nowfloor = 0;
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    nowfloor = floor + U;
                } else if (i == 1) {
                    nowfloor = floor - D;
                }
                if (nowfloor < 1 || nowfloor > F) continue;
                if (visited[nowfloor] != -1) continue;
                visited[nowfloor] = visited[floor] + 1;
                q.add(nowfloor);
            }
        }
    }
}
