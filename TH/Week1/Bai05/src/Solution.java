public class Solution {
    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution Main = new Solution();
        System.out.println(Main.gcd(5, 3));
    }
}
