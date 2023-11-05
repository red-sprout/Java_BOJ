// BOJ 10988
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main40 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
        int length = ch.length;

        for(int i = 0; i <= length/2; i++){
            if(ch[i] != ch[length - i - 1]) {
                System.out.println(0);
                System.exit(0);
            }
        }

        System.out.println(1);
    }
}
