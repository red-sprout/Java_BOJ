package mac.DnC;

import java.io.*;

public class BOJ1992 {
    static int N;
    static int[][] video;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        video = new int[N][N];

        for(int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                video[i][j] = tmp[j] - '0';
            }
        }

        partition(0, 0, N);
        System.out.println(sb);

        br.close();
    }
    private static void partition(int row, int col, int size){
        int check = video[row][col];
        int newSize = size / 2;

        if(checkBW(row, col, size)) {
            sb.append(String.valueOf(check));
        } else {
            sb.append("(");
            partition(row, col, newSize);
            partition(row, col + newSize , newSize);
            partition(row + newSize, col, newSize);
            partition(row + newSize, col + newSize, newSize);
            sb.append(")");
        }
    }
    private static boolean checkBW(int row, int col, int size){
        int check = video[row][col];

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(check != video[i][j]) return false;
            }
        }

        return true;
    }
}
