// BOJ 11653
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main24 {
    static int MAX = 10000001;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] p = new boolean[MAX];
        for(int i = 2; i < MAX; i++){
            p[i] = true;
        }

        for(int i = 2; i < MAX; i++){
            if(!p[i]) continue;
            for(int j = 2 * i; j < MAX; j = j+i) p[j] = false;
            while(true){
                if(N%i != 0) break;
                System.out.println(i);
                N = N/i;
            }
        }
    }
}
