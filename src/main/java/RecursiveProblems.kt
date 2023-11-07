/**
 * Created by Prasada Rao on 06/10/21 4:25 PM
 **/
object FindPath {

    private fun findNumberOfPaths(n: Int, m: Int): Int {
        if (n == 1 || m == 1) return 1

        return findNumberOfPaths(n, m - 1) + findNumberOfPaths(n - 1, m)
    }

    private fun findPartitions(n: Int, m: Int): Int {
        if (n <= 0) return 1
        if (m <= 0) return 0
        return findPartitions(n - m, m) + findPartitions(n, m - 1)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(findPartitions(5, 3))
    }
}

object Permutations {

    private fun permutation(s: String) {
        permutation(s, "")
    }

    private fun permutation(s: String, prefix: String) {
        if (s.isEmpty()) {
            println(prefix)
            return
        }
        for (i in s.indices) {
            val rem = s.substring(0, i) + s.substring(i + 1)
            permutation(rem, prefix + s[i])
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        permutation("abc")
    }
}