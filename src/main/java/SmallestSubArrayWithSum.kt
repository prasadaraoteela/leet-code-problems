import kotlin.math.min

/**
 * Created by Prasada Rao on 05/10/21 6:51 PM
 **/
class SmallestSubArrayWithSum {

    fun findSmallestSubArray(array: Array<Int>, sumThreshold: Int): Array<Int> {

        var i = 0
        var j = 0
        var smallestArrayLength = Int.MAX_VALUE
        var sum = 0
        while (i < array.size) {

            if (sum >= sumThreshold) {
                if (smallestArrayLength > (i - j)) {
                    smallestArrayLength = i - j
                    println(array.sliceArray(j until i).contentToString())
                }
                sum -= array[j++]
            } else {
                sum += array[i++]
            }
        }
        println(smallestArrayLength)
        return emptyArray()
    }

}

fun main() {
    println(SmallestSubArrayWithSum().findSmallestSubArray(arrayOf(4, 2, 2, 7, 8, 1, 2, 8, 1, 0), 15).contentToString())
}