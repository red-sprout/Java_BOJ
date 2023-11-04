// BOJ 10039
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main27 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;
        for(int i = 0; i < 5; i++) {
            int score = Integer.parseInt(br.readLine());
            if(score < 40) score = 40;
            ans += score;
        }
        System.out.println(ans/5);
    }
}