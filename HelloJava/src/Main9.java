// BOJ 2588
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main9 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        String B = br.readLine();
        char[] b = B.toCharArray();

        for (int i = 2; i >= 0; i--){
            System.out.println(A * (b[i] - '0'));
        }
        System.out.println(A * Integer.parseInt(B));
    }
}
