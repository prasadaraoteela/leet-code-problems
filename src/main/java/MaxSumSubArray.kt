import kotlin.math.max

/**
 * Created by Prasada Rao on 05/10/21 5:35 PM
 **/
class MaxSumSubArray {

    fun findMaxSumSubArray(array: Array<Int>, k: Int): Int {
        var i = 0
        var sum = 0
        var max = 0
        while (i < array.size) {
            sum += array[i]
            if (i >= k - 1) {
                max = max(max, sum)
                sum -= array[i - (k - 1)]
            }
            i++
        }
        return max
    }

    fun findMaxSumSubArray1(array: Array<Int>, k: Int): Int {
        var i = 0

        var max = 0
        while (i < array.size) {

            var ki = i
            var sum = 0
            while (ki < i + 3 && i < array.size - 3) {
                sum += array[ki]
                ki++
            }

            max = max(max, sum)

            i++
        }
        return max
    }

}

fun main() {
    println(MaxSumSubArray().findMaxSumSubArray(arrayOf(4, 2, 1, 7, 8, 1, 2, 8, 1, 0), 3))
}