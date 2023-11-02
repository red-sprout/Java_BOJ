// BOJ 5355
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main19 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            float A = Float.parseFloat(st.nextToken());
            while(st.hasMoreTokens()){
                String c = st.nextToken();
                if(c.equals("@")){
                    A = A * 3;
                } else if(c.equals("%")){
                    A = A + 5;
                } else {
                    A = A - 7;
                }
            }
            System.out.printf("%.2f\n",A);
        }
    }
}
