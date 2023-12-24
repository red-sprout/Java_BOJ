package mac.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int x, y, cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class BOJ1261 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[][] maze = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        int result = dijkstra(maze, N, M);
        System.out.println(result);
    }

    static int dijkstra(int[][] maze, int N, int M) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][] distance = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        pq.add(new Node(0, 0, 0));
        distance[0][0] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    int newCost = current.cost + maze[nx][ny];

                    if (newCost < distance[nx][ny]) {
                        distance[nx][ny] = newCost;
                        pq.add(new Node(nx, ny, newCost));
                    }
                }
            }
        }

        return distance[N - 1][M - 1];
    }
}