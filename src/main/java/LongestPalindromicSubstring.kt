import kotlin.math.max

/**
 * Created by Prasada Rao on 06/10/21 10:55 AM
 **/
class LongestPalindromicSubstring {

    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""

        if (s.length == 1) return s

        var low: Int
        var high: Int
        var start = 0
        var longestPalindromeLength = 1
        for (i in 1 until s.length) {

            // Find the longest even length palindrome with center points as i-1 and i.
            low = i - 1
            high = i

            while (low >= 0 && high < s.length && s[low] == s[high]) {
                low--
                high++
            }

            // Move back to the last possible valid palindrome substring
            // as that will anyway be the longest from above loop
            ++low
            --high
            if (s[low] == s[high] && high - low + 1 > longestPalindromeLength) {
                start = low
                longestPalindromeLength = high - low + 1
            }

            // Find the longest odd length palindrome with center point as i

            low = i - 1
            high = i + 1

            while (low >= 0 && high < s.length && s[low] == s[high]) {
                low--
                high++
            }


            // Move back to the last possible valid palindrome substring
            // as that will anyway be the longest from above loop
            ++low
            --high
            if (s[low] == s[high] && high - low + 1 > longestPalindromeLength) {
                start = low
                longestPalindromeLength = high - low + 1
            }
        }

        return s.substring(start, start + longestPalindromeLength)
    }

    private fun isPalindrome(s: String): Boolean {
        return isPalindrome(s, 0, s.length - 1)
    }

    private fun generateAllCombinations(s: String) {
        permute(s.toCharArray(), 0, s.length)
    }

    private fun permute(s: CharArray, l: Int, r: Int) {
        if (l == r) {
            println(s)
            return
        }
        for (i in l..r) {
            swap(s, l, i)
            permute(s, l + 1, r)
            swap(s, l, i)
        }
    }

    private fun swap(s: CharArray, l: Int, r: Int) {
        val temp: Char = s[l]
        s[l] = s[r]
        s[r] = temp
    }

    private fun isPalindrome(s: String, start: Int, end: Int): Boolean {
        if (start == end) return true
        if (start == end - 1 && s[start] == s[end]) return true

        if (s[start] == s[end]) {
            return isPalindrome(s, start + 1, end - 1)
        }
        return false
    }
}

fun main() {
    println(LongestPalindromicSubstring().longestPalindrome("babad"))
    println(LongestPalindromicSubstring().longestPalindrome("cbbd"))
    println(LongestPalindromicSubstring().longestPalindrome("a"))
    println(LongestPalindromicSubstring().longestPalindrome("ac"))
    println(LongestPalindromicSubstring().longestPalindrome("abcba"))
//    println(LongestPalindromicSubstring().longestPalindrome("abc"))
}