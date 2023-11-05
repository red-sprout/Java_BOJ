// BOJ 2476
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main33 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;
        int max_dice = 0;
        int max_score = 0;
        int N = Integer.parseInt(br.readLine());
        for(int j = 0; j < N ; j++){
            int[] dice = {0,0,0,0,0,0,0};

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()){
                dice[Integer.parseInt(st.nextToken())] += 1;
            }

            for(int i = 1; i <= 6; i++){
                if(dice[i] >= max_dice) {
                    ans = i;
                    max_dice = dice[i];
                }
            }

            switch (max_dice) {
                case 3:
                    max_score = max_score > 10000 + ans * 1000 ? max_score : 10000 + ans * 1000;
                    break;
                case 2:
                    max_score = max_score > 1000 + ans * 100 ? max_score : 1000 + ans * 100;
                    break;
                default:
                    max_score = max_score > ans * 100 ? max_score : ans * 100;
                    break;
            }
        }

        System.out.println(max_score);
    }
}
