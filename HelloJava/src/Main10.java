// BOJ 3046
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main10 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int R1 = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        System.out.println(2*S - R1);
    }
}
