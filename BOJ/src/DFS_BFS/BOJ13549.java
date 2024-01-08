package DFS_BFS;

import java.util.*;

public class BOJ13549 {
    static int N, K;
    static int MAX = 200000;
    static int[] map = new int[MAX + 1];
    static boolean[] visited = new boolean[MAX + 1];
    static int[] move = {-1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        bfs();
        System.out.println(map[K]);
        sc.close();
    }
    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = true;
        while(!q.isEmpty()) {
            int pastPos = q.poll();
            int nowPos = 0;
            for(int i = -1; i < 2; i++) {
                if(i == -1) {
                    nowPos = 2 * pastPos;
                    if(nowPos < 0 || nowPos > MAX) continue;
                    if(visited[nowPos]) continue;

                    map[nowPos] = map[pastPos];
                    visited[nowPos] = true;
                    q.add(nowPos);
                    continue;
                } else {
                    nowPos = pastPos + move[i];
                }

                if(nowPos < 0 || nowPos > MAX) continue;
                if(visited[nowPos]) continue;

                map[nowPos] = map[pastPos] + 1;
                visited[nowPos] = true;
                q.add(nowPos);
            }
        }
    }
}