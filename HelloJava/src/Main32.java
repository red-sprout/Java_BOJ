// BOJ 3009
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main32 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] x = new int[3];
        int[] y = new int[3];
        for(int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(x);
        Arrays.sort(y);

        int x_final = x[1] == x[2] ? x[0] : x[2];
        int y_final = y[1] == y[2] ? y[0] : y[2];

        System.out.printf("%d %d\n",x_final,y_final);
    }
}
