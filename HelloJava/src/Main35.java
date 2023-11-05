// BOJ 2884
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main35 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(M < 45) {
            M = M + 15;
            H = H - 1 >= 0 ? H - 1 : H + 23;
        } else M = M - 45;

        System.out.printf("%d %d\n", H, M);
    }
}
