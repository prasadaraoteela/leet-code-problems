/**
 * Created by Prasada Rao on 05/10/21 10:22 PM
 **/
class MedianOfTwoSortedArrays {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

        val result = IntArray(nums1.size + nums2.size)
        var i1 = 0
        var i2 = 0
        var i = 0
        while (i1 < nums1.size || i2 < nums2.size) {

            if (i2 >= nums2.size || nums1[i1] < nums2[i2]) {
                result[i] = nums1[i1]
                i1++
            } else {
                result[i] = nums2[i2]
                i2++
            }
            i++
        }

        println(result.contentToString())
        val div = result.size.div(2)
        if (result.size.rem(2) == 0) {
            return (result[div] + result[div - 1]) / 2.0
        }
        return result[div].toDouble()
    }

}

fun main() {
    println(MedianOfTwoSortedArrays().findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
    println(MedianOfTwoSortedArrays().findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
    println(MedianOfTwoSortedArrays().findMedianSortedArrays(intArrayOf(0, 0), intArrayOf(0, 0)))
    println(MedianOfTwoSortedArrays().findMedianSortedArrays(intArrayOf(), intArrayOf(1)))
}