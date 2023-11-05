// BOJ 10886
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main39 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int vote = 0;

        for(int i = 0; i < N; i++){
            int op = Integer.parseInt(br.readLine());
            vote += op;
        }

        String ans = vote > (N/2) ? "cute!" : "not cute!";
        System.out.println("Junhee is " + ans);
    }
}
