package algo.easy;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
    }

    private static boolean isPalindrome(int x) {
        if(x < 0) return false;

        int orgX = x;
        int revX = 0;
        while(x>0) {
            revX = revX*10 + x%10;
            x = x/10;
        }

        return orgX==revX;
    }
}
