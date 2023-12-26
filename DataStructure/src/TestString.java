import java.util.HashMap;

public class TestString {
    public static void main(String[] args) {
        System.out.println(isUniqueUsingHashMap("abcdefgghijk"));
        System.out.println(isUniqueUsingHashMap("abcdefjhigk"));

        System.out.println(isUniqueUsingBit("abcdefgghijk"));
        System.out.println(isUniqueUsingBit("abcdefjhigk"));
    }

    private static boolean isUniqueUsingHashMap(String str) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (hashMap.containsKey(c)) {
                return false;
            }
            hashMap.put(c, true);
        }
        return true;
    }

    private static boolean isUniqueUsingBit(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}