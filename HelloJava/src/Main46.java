// BOJ 10162
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main46 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] btn = {0,0,0};
        while(T>=10) {
            if(T >= 300){
                T -= 300;
                btn[0]++;
            } else if(T >= 60){
                T -= 60;
                btn[1]++;
            } else {
                T -= 10;
                btn[2]++;
            }
        }
        String str = T > 0 ? "-1" : btn[0] + " " + btn[1] + " " + btn[2];
        System.out.println(str);
    }
}
