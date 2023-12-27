package mac.PriorityQueue;

import java.io.*;
import java.util.*;

class SortRule implements Comparable<SortRule> {
    private int num;

    SortRule(int num) {
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(SortRule sortRule) {
        if(Math.abs(this.num) > Math.abs(sortRule.getNum())) {
            return 1;
        } else if(Math.abs(this.num) < Math.abs(sortRule.getNum())) {
            return -1;
        } else {
            return this.num - sortRule.getNum();
        }
    }
}

public class BOJ11298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<SortRule> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.add(new SortRule(x));
            } else if (pq.isEmpty()) {
                System.out.println(0);
            } else {
                SortRule sortRule = pq.poll();
                System.out.println(sortRule.getNum());
            }
        }

        br.close();
    }
}
