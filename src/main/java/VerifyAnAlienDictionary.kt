/**
 * Created by Prasada Rao on 08/10/21 2:01 PM
 **/
object VerifyAnAlienDictionary {

    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val orderMap = HashMap<Char, Int>()

        order.forEachIndexed { index, c ->
            orderMap[c] = index + 1
        }

        for (i in 0 until words.size - 1) {
            val word1 = words[i]
            val word2 = words[i + 1]

            if (!isSorted(word1, word2, orderMap)) {
                return false
            }
        }
        return true
    }

    private fun isSorted(word1: String, word2: String, orderMap: HashMap<Char, Int>): Boolean {
        var i = 0
        var j = 0
        while (i < word1.length || j < word2.length) {
            val c1 = word1.getOrElse(i) { ' ' }
            val c2 = word2.getOrElse(j) { ' ' }
            if (c1 != c2) {
                return orderMap.getOrElse(c1) { 0 } < orderMap.getOrElse(c2) { 0 }
            }
            i++
            j++
        }
        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
//        println(isAlienSorted(arrayOf("hello", "leetcode"), "hlabcdefgijkmnopqrstuvwxyz"))
        println(isAlienSorted(arrayOf("apple", "app"), "abcdefghijklmnopqrstuvwxyz"))
    }

}