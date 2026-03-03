public class Solution {
    public long fibonacci(long n) {
        if(n < 0) return -1;
        if(n == 0) return 0;
        if(n == 1) return 1;

        long F0 = 0, F1 = 1;
        for(int i = 2; i <= n; ++i) {
            if(F0 >= Long.MAX_VALUE - F1)
                return Long.MAX_VALUE;

            Long F2 = F0 + F1;
            F0 = F1;
            F1 = F2;
        }
        return F1;
    }
    public static void main(String[] args) {
        Solution Main = new Solution();
        System.out.println(Main.fibonacci(100));
    }
}
