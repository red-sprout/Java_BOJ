// BOJ 9506
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main45 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == -1) break;
            String str = " = 1";
            int sum = 1;

            for(int i = 2; i < n; i++) {
                if(n%i == 0) {
                    str += " + " + i;
                    sum += i;
                }
            }
            str = sum == n ? str : " is NOT perfect.";
            System.out.println(n + str);
        }
    }
}
