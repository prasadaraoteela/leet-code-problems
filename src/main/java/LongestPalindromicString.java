/**
 * Created by Prasada Rao on 08/10/21 10:07 PM
 **/
public class LongestPalindromicString {

    public String longestPalindrome(String s) {

        int start;
        int end;
        int startIndexOfPalindrome = 0;
        int maxLength = 1;
        for (int i = 1; i < s.length(); i++) {

            start = i - 1;
            end = i;
            // Find even palindrome which starts from i
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }

            // Reset the position back to previous state
            ++start;
            --end;

            if (s.charAt(start) == s.charAt(end) && end - start + 1 > maxLength) {
                startIndexOfPalindrome = start;
                maxLength = Math.max(maxLength, end - start + 1);
            }

            // find the longest odd palindrome
            start = i - 1;
            end = i + 1;

            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }

            ++start;
            --end;

            if (s.charAt(start) == s.charAt(end) && end - start + 1 > maxLength) {
                startIndexOfPalindrome = start;
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }

        return s.substring(startIndexOfPalindrome, startIndexOfPalindrome + maxLength);
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicString().longestPalindrome("babad"));
        System.out.println(new LongestPalindromicString().longestPalindrome("cbbd"));
        System.out.println(new LongestPalindromicString().longestPalindrome("a"));
        System.out.println(new LongestPalindromicString().longestPalindrome("ac"));
        System.out.println(new LongestPalindromicString().longestPalindrome("abcba"));
    }
}
