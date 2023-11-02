// BOJ 2675
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main20 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int R = Integer.parseInt(st.nextToken());
            char[] S = st.nextToken().toCharArray();
            for(char c : S){
                for(int j = 0; j < R; j++){
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}
