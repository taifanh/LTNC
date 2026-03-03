public class Solution {
    public boolean isPrime(int n) {
        for(int i = 2; i < n; ++i)
            if(n % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Solution Main = new Solution();
        System.out.println(Main.isPrime(7));
    }
}
