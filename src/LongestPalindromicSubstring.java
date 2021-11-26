public class LongestPalindromicSubstring {
    public static void main(String[] args) {

        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindrome("dabbaad"));
        System.out.println(l.longestPalindrome("acbbdc"));
        System.out.println(l.longestPalindrome("babad"));
        System.out.println(l.longestPalindrome("ccc"));

    }


    public String longestPalindrome(String s) {
        String longest = "";
        for(int i = 0 ; i < s.length(); i++) {

            String even = longestPalindrome(s, i, true);
            String odd = longestPalindrome(s, i, false);

            String longer = even.length() > odd.length()
                    ? even
                    : odd;

            if(longer.length() > longest.length()) {
                longest = longer;
            }
        }

        return longest;

    }

    public String longestPalindrome(String s, int middle, boolean even) {
        int left, right;
        String longestPalindrome;

        if(!even) {
            left = middle;
            right = middle;

            while(s.charAt(left) == s.charAt(right)) {
                if(left > 0 && right < s.length() - 1) {
                    left--;
                    right++;
                } else {
                    left--;
                    right++;
                    break;
                }
            }
        } else {
            if(middle == s.length() - 1) {
                return s.substring(middle);
            }

            left = middle;
            right = middle + 1;

            while (s.charAt(left) == s.charAt(right)) {
                if(left > 0 && right < s.length() - 1) {
                    left--;
                    right++;
                } else {
                    left--;
                    right++;
                    break;
                }

            }
        }
        return s.substring(Integer.min(left + 1, right), right);
    }



    
}
