/**
 * Created by Prasada Rao on 06/10/21 8:12 PM
 **/
object PalindromeNumber {

    private fun isPalindrome(x: Int): Boolean {
        return isPalindrome(x.toString())
    }

    private fun isPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1

        while (l < r) {
            if (s[l] != s[r]) {
                return false
            }
            l++
            r--
        }
        return true
    }

    private fun isPalindrome1(x: Int): Boolean {
        var number = x
        var newNumber = 0
        while (number != 0) {
            newNumber = newNumber.times(10) + number.rem(10)
            number = number.div(10)
        }
        return x == newNumber
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(isPalindrome(121))
        println(isPalindrome(-121))
    }
}