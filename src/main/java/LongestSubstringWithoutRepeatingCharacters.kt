import kotlin.math.max

/**
 * Created by Prasada Rao on 02/10/21 12:19 AM
 **/
class LongestSubstringWithoutRepeatingCharacters {

    fun lengthOfLongestSubstring(s: String): Int {
        var addPointer = 0
        var removePointer = 0
        var longestSubstring = 0
        val set = HashSet<Char>()
        while (addPointer < s.length) {

            val char = s[addPointer]
            if (set.contains(char)) {
                set.remove(s[removePointer])
                removePointer++
            } else {
                set.add(char)
                longestSubstring = max(set.size, longestSubstring)
                addPointer++
            }
            println(set)
        }

        return longestSubstring
    }

    fun lengthOfLongestSubstring2(s: String): Int {
        var longestSubstring = 0

        var i = 0
        while (i < s.length) {
            var j = i
            val set = HashSet<Char>()

            while (j < s.length) {
                val char = s[j]
                if (set.contains(char)) {
                    break
                }
                set.add(char)
                j++
            }
            if (longestSubstring < set.size) {
                longestSubstring = set.size
            }
            i++
        }
        return longestSubstring
    }

    fun lengthOfLongestSubstring1(s: String): Int {
        val map = HashMap<Char, HashSet<Char>>()

        val charArray = s.toCharArray()
        var longestSubstring = 0

        charArray.forEachIndexed { index, char ->
            var set = map.getOrPut(char) {
                HashSet()
            }
            val temp = HashSet<Char>()
            for (j in index until charArray.size) {
                if (temp.contains(charArray[j])) {
                    break
                }
                temp.add(charArray[j])
            }
            if (temp.size > set.size) {
                map[char] = temp
            }
            set = map.getOrDefault(char, HashSet())
            if (longestSubstring < set.size) {
                longestSubstring = set.size
            }
        }
        return longestSubstring
    }
}

fun main() {
    println(LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("umvejcmmk"))
    println(LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("aab"))
    println(LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"))
}