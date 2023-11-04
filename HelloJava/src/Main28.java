// BOJ 1934
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main28 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int front = 0;
            int back = 0;

            if(A > B) {
                front = A;
                back = B;
            } else {
                front = B;
                back = A;
            }
            while(true){
                if(front % back == 0) break;
                int tmp = front;
                front = back;
                back = tmp % back;
            }

            System.out.println((A*B)/back);
        }
    }
}
