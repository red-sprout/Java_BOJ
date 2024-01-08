package Backtracking;

import java.util.Scanner;

public class Nqueen {
    static int N, ANS;
    static int[] column;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        column = new int[N];
        visited = new boolean[N];

        dfs(0);

        System.out.println(ANS);

        sc.close();
    }

    private static void dfs(int row) {
        if(row == N) {
            ANS++;
            return;
        }

        for(int col = 0; col < N; col++) {
            if(isValid(row, col)) {
                column[row] = col;
                visited[col] = true;
                dfs(row + 1);
                visited[col] = false;
            }
        }
    }

    private static boolean isValid(int row, int col) {
        if(visited[col]) return false;

        for(int oldRow = 0; oldRow < row; oldRow++) {
            int oldCol = column[oldRow];
            if(Math.abs(row - oldRow) == Math.abs(col - oldCol)) return false;
        }

        return true;
    }
}
