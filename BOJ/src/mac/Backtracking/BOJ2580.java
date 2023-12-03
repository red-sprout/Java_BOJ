package mac.Backtracking;

import java.util.*;
import java.io.*;

public class BOJ2580 {
    static int[][] sudoku;
    static int[][] zeroCord;
    static int totalZero;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        sudoku = new int[9][9];
        zeroCord = new int[81][2];

        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                sudoku[i][j] = num;

                if(num == 0) {    
                    zeroCord[totalZero][0] = i;
                    zeroCord[totalZero][1] = j;
                    totalZero++;
                }
            }
        }

        dfs(0);
        br.close();
    }

    private static void dfs(int n){
        if (n == totalZero) {
            sb = new StringBuilder();

            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    sb.append(String.valueOf(sudoku[i][j]));
                    sb.append(" ");
                }
                sb.append("\n");
            }

            System.out.print(sb);
            System.exit(0);
        } else {
            int row = zeroCord[n][0];
            int col = zeroCord[n][1];

            for(int i = 1; i <= 9; i++) {
                if(check(row, col, i) && sudoku[row][col] == 0) {
                    sudoku[row][col] = i;
                    dfs(n+1);
                    sudoku[row][col] = 0;
                }
            }
        }
    }

    private static boolean check(int row, int col, int value) {
        boolean ans = true;
        int startPointRow = (row / 3) * 3;
        int startPointCol = (col / 3) * 3;

        for(int i = 0; i < 9; i++) {
            if(sudoku[row][i] == value) return false;
            if(sudoku[i][col] == value) return false;
        }

        for(int i = startPointRow; i < startPointRow + 3; i++) {
            for(int j = startPointCol; j < startPointCol + 3; j++) {
                if(i == row && j == col) continue;
                if(sudoku[i][j] == value) return false;
            }
        }

        return ans;
    }
}
