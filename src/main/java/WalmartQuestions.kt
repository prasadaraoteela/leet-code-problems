/**
 * Created by Prasada Rao on 07/10/21 1:36 PM
 **/
// 1. Given an array of elements of length N, ranging from 0
// to N-1. All elements may not be present in the array. If
// the element is not present then there will be -1 present
// in the array. Rearrange the array such that A[i] = i and if
// i is not present, display -1 at the place.
// Input arr = [ -1, -1, 6, 1, 9, 3, 2, -1, 4, -1]
// Output arr = [ -1, 1, 2, 3, 4, -1, 6, -1, -1, 9]
object Question1 {

    private fun solution(array: IntArray): IntArray {
        val output = IntArray(array.size) { -1 }
        array.filter { i -> i != -1 }.forEach { i ->
            output[i] = i
        }
        return output
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(solution(intArrayOf(-1, -1, 6, 1, 9, 3, 2, -1, 4, -1)).contentToString())
    }
}

/**
 * Write code to link Left nodes of the binary tree
 * to its immediate Right sibling
 */
object Question2 {

}