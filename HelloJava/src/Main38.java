// BOJ 10102
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main38 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        char[] vote = br.readLine().toCharArray();
        int A = 0;
        int B = 0;

        for(int i = 0; i < V; i++) {
            if(vote[i] == 'A') A++;
            else B++;
        }

        if(A > B) System.out.println('A');
        else if(A < B) System.out.println('B');
        else System.out.println("Tie");
    }
}
