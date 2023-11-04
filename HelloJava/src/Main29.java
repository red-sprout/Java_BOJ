// BOJ 2480
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main29 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dice = {0,0,0,0,0,0,0};
        int ans = 0;
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            dice[Integer.parseInt(st.nextToken())] += 1;
        }

        for(int i = 1; i <= 6; i++){
            if(dice[i] >= max) {
                ans = i;
                max = dice[i];
            }
        }

        switch (max) {
            case 3:
                ans = 10000 + ans * 1000;
                break;
            case 2:
                ans = 1000 + ans * 100;
                break;
            default:
                ans = ans * 100;
                break;
        }

        System.out.println(ans);
    }
}
