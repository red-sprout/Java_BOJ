import java.util.*;

public class BOJ1520 {
    static int INF = 10001;
    public static void dfs(int[][] map, int[][] dp) {
        Stack<int[]> stack = new Stack<int[]>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        int i = 1;
        int j = 1;
        visited[i][j] = true;
        int[] tmp = {1,1};
        stack.push(tmp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] map = new int[M+2][N+2];
        int[][] dp = new int[M+2][N+2];
        dp[1][1] = 1;

        for (int i = 0; i <= M+1; i++) {
            for (int j = 0; j <= N+1; j++) {
                if (i*j == 0 || i == M+1 || j == N+1) {
                    map[i][j] = INF;
                    continue;
                }
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i-1][j] += map[i-1][j] < map[i][j] ? dp[i][j] : 0;
                dp[i+1][j] += map[i+1][j] < map[i][j] ? dp[i][j] : 0;
                dp[i][j-1] += map[i][j-1] < map[i][j] ? dp[i][j] : 0;
                dp[i][j+1] += map[i][j+1] < map[i][j] ? dp[i][j] : 0;
            }
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        sc.close();
    }
}
