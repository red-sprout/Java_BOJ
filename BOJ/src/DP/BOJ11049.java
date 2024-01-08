package DP;

import java.util.*;
import java.io.*;

class Matrix {
    private int row = 0;
    private int col = 0;
    private int value = 0;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public int getValue() {
        return this.value;
    }

    public void setRow(int row) {
        this.row = row;
    }
    
    public void setCol(int col) {
        this.col = col;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class BOJ11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Matrix[] matrixs = new Matrix[N + 1];
        Matrix[][] dp = new Matrix[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            matrixs[i] = new Matrix(row, col);
        }

        for(int first = 1; first <= N; first++) {
            for(int last = 1; last <= N; last++) {
                dp[first][last] = new Matrix(matrixs[first].getRow(), matrixs[last].getCol());
            }
        }

        for(int length = 1; length < N; length++) {
            for(int first = 1; first + length <= N; first++) {
                int last = first + length;
                dp[first][last].setValue(Integer.MAX_VALUE);
                for(int i = first; i < last; i++) {
                    int n = dp[first][i].getRow();
                    int m = dp[first][i].getCol();
                    int k = dp[i + 1][last].getCol();
                    int tmp = dp[first][i].getValue() + dp[i + 1][last].getValue() + n * m * k;
                    
                    dp[first][last].setValue(Math.min(dp[first][last].getValue(), tmp));
                }
            }
        }

        System.out.println(dp[1][N].getValue());
        br.close();
    }
}