// BOJ 2754
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main34 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Double> hm = new HashMap<String, Double>();

        hm.put("A+", 4.3);
        hm.put("A0", 4.0);
        hm.put("A-", 3.7);

        hm.put("B+", 3.3);
        hm.put("B0", 3.0);
        hm.put("B-", 2.7);

        hm.put("C+", 2.3);
        hm.put("C0", 2.0);
        hm.put("C-", 1.7);

        hm.put("D+", 1.3);
        hm.put("D0", 1.0);
        hm.put("D-", 0.7);

        hm.put("F", 0.0);

        String score = br.readLine();
        System.out.println(hm.get(score));
    }
}
