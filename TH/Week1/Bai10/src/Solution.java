public class Solution {
    public int secondLargest(int[] arr) {
        int Large1 = Integer.MIN_VALUE, Large2 = Integer.MIN_VALUE;
        for(int x : arr) {
            if(x > Large1) {
                Large2 = Large1;
                Large1 = x;
            }
            else if(x < Large1 && x > Large2)
                Large2 = x;
        }
        if(Large2 == Integer.MIN_VALUE)
            return -1;
        return Large2;
    }

    public static void main(String[] args) {
        Solution Main = new Solution();
        System.out.println(Main.secondLargest(new int[]{-2, 3, -3}));
    }
}
