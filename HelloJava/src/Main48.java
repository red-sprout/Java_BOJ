// BOJ 10214
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main48 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int[] result = {0,0};
            for(int j = 0; j < 9; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                result[0] += Integer.parseInt(st.nextToken());
                result[1] += Integer.parseInt(st.nextToken());
            }
            String str;
            if(result[0] > result[1]) str = "Yonsei";
            else if(result[0] < result[1]) str = "Korea";
            else str = "Draw";

            System.out.println(str);
        }
    }
}
