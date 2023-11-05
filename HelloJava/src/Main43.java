// BOJ 9610
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main43 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] Q = {0,0,0,0,0}; // 0: AXIS / Others: Q1, Q2, Q3, Q4

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(x*y == 0) Q[0]++;
            else if(x > 0 && y > 0) Q[1]++;
            else if(x < 0 && y > 0) Q[2]++;
            else if(x < 0 && y < 0) Q[3]++;
            else Q[4]++;
        }

        System.out.printf("Q1: %d\nQ2: %d\nQ3: %d\nQ4: %d\nAXIS: %d\n",Q[1],Q[2],Q[3],Q[4],Q[0]);
    }
}
