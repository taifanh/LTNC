public class Solution {
    public int reverse(int n) {
        int m = 0;
        while(n > 0) {
            m = m * 10 + n % 10;
            n /= 10;
        }
        return m;
    }

    public static void main(String[] args) {
        Solution Main = new Solution();
        System.out.println(Main.reverse(452452));
    }
}
