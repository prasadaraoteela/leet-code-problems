package easy;

/**
 * Created by Prasada Rao on 11/10/21 4:44 PM
 *
 * <a href="https://leetcode.com/problems/implement-strstr/">28. Implement indexOf()</a>
 **/
public class ImplementIndexOf {

    public int strStr(String haystack, String needle) {

        if (needle.isEmpty()) return 0;
        if (haystack.isEmpty()) return -1;

        for (int i = 0; i < haystack.length(); i++) {
            if (i > haystack.length() - needle.length()) return -1;
            if (haystack.startsWith(needle, i)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new ImplementIndexOf().strStr("hello", "ll"));
        System.out.println(new ImplementIndexOf().strStr("aaaaa", "bba"));
        System.out.println(new ImplementIndexOf().strStr("", ""));
        System.out.println(new ImplementIndexOf().strStr("arrow", "ro"));
    }
}
