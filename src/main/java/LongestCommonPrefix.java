/**
 * Created by Prasada Rao on 11/10/21 12:39 PM
 *
 * <a href="https://leetcode.com/problems/longest-common-prefix/">14. Longest Common Prefix</a>
 **/
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {

            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefix1(String[] strs) {
        int smallestArrayLength = Integer.MAX_VALUE;
        for (String str : strs) {
            smallestArrayLength = Math.min(smallestArrayLength, str.length());
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < smallestArrayLength; i++) {

            Character c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return result.toString();
                }
            }

            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
