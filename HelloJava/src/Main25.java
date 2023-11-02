// BOJ 1789
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main25 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());
        long sum = 0;
        int N = 0;
        
        for(int i = 1; ; i++){
            if(sum > S) break;
            sum += i;
            N++;
        }

        System.out.println(N-1);
    }
}
