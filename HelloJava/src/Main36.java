// BOJ 7567
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main36 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] dish = br.readLine().toCharArray();
        char tmp = dish[0];
        int ans = 10;
        int length = dish.length;

        for(int i = 1; i < length; i++) {
            ans += tmp == dish[i] ? 5 : 10;
            tmp = dish[i];
        }

        System.out.println(ans);
    }
}
