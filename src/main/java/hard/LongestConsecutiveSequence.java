package hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Prasada Rao on 18/10/21 12:42 PM
 *
 * <a href="https://leetcode.com/problems/longest-consecutive-sequence/">128. Longest Consecutive Sequence</a>
 **/
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        final Set<Integer> numbers = new HashSet<>();

        for (int num : nums) {
            numbers.add(num);
        }
        int longestStreak = 0;

        for (int num : nums) {
            if (numbers.contains(num - 1)) {
                continue;
            }

            int currentStreak = 0;
            int currentNumber = num;
            while (numbers.contains(currentNumber)) {
                currentStreak++;
                currentNumber++;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{102, 4, 100, 1, 101, 3, 2}));
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{5, 4, 3, 2, 1}));
    }
}
