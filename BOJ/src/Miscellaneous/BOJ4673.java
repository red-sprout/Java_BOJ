package Miscellaneous;

public class BOJ4673 {
    static int MAX = 10001;
    static boolean[] notSelf = new boolean[MAX];
    public static void main(String[] args) {
        int idx = 1;
        while (idx < MAX) {
            int notSelfCand = d(idx); 
            while (notSelfCand < MAX) {
                notSelf[notSelfCand] = true;
                notSelfCand = d(notSelfCand);
            }
            idx++;
        }

        for (int i = 1; i < MAX; i++) {
            if (notSelf[i]) continue;
            System.out.println(i);
        }
    }

    private static int d(int n) {
        int cnt = 0;
        int ans = n;
        while(true) {
            if(n / (int)Math.pow((double)10, (double)cnt) == 0) break;
            else cnt++;
        }
        for (int i = cnt - 1; i >= 0; i--) {
            int tmp = (int)Math.pow((double)10, (double)i);
            ans += n / tmp;
            n -= (n / tmp) * tmp;
        }
        return ans;
    }
}
