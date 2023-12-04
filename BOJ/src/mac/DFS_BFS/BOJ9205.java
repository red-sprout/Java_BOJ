package mac.DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ9205 {
    static int n;
    static int[][] cord;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            cord = new int[n+2][2];
            visited = new boolean[n+2];

            for(int j = 0; j < n + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                cord[j][0] = Integer.parseInt(st.nextToken());
                cord[j][1] = Integer.parseInt(st.nextToken());
            }

            bfs();
            String message = visited[n+1] ? "happy" : "sad";
            System.out.println(message);
        }
        br.close();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()) {
            int idx = q.poll();
            int pastX = cord[idx][0];
            int pastY = cord[idx][1];
            for(int i = 0; i < n+2; i++) {
                int nowX = cord[i][0];
                int nowY = cord[i][1];
                if(visited[i]) continue;
                if(distance(pastX, pastY, nowX, nowY) > 1000) continue;
                q.add(i);
                visited[i] = true;
            }
        }
    }

    private static int distance(int pastX, int pastY, int nowX, int nowY) {
        return Math.abs(nowX-pastX) + Math.abs(nowY-pastY);
    }
}
