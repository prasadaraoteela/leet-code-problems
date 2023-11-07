/**
 * Created by Prasada Rao on 07/10/21 8:30 PM
 **/
object PrintSubsequencesString {

    private fun subsequence(s: String) {
        subsequence(s, "")
    }

    private fun subsequence(s: String, result: String) {
        if (s.isEmpty()) {
            println(result)
            return
        }
        subsequence(s.substring(1), result + s[0])
        subsequence(s.substring(1), result)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        subsequence("abc")
    }
}