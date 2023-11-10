import java.io.*;
import java.util.*;

public class BOJ1520 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];

        for (int i = 0; i < M; i++){
            StringTokenizer arr = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(arr.nextToken());
            }
        }
        //code

        br.close();
    }
}
