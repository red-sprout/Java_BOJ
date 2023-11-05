// BOJ 11557
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main49 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String str = " ";
            int max = 0;
            for(int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str_tmp = st.nextToken();
                int int_tmp = Integer.parseInt(st.nextToken());
                if(max < int_tmp) {
                    max = int_tmp;
                    str = str_tmp;
                }
            }

            System.out.println(str);
        }
    }
}
