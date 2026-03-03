public class Solution {
    public int sumOfDigits(int n) {
        int SumDig = 0;
        while(n > 0) {
            SumDig += n % 10;
            n /= 10;
        }
        return SumDig;
    }

    public static void main(String[] args) {
        Solution Main = new Solution();
        System.out.println(Main.sumOfDigits(234));
    }
}
