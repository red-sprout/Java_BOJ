// BOJ 8958
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main44 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            char[] result = br.readLine().toCharArray();
            int score = 0;
            int tmp = 1;
            for(int j = 0; j < result.length; j++) {
                if(result[j] == 'O') score += tmp;
                else tmp = 0;
                tmp++;
            }

            System.out.println(score);
        }
    }
}
