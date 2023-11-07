/**
 * Created by Prasada Rao on 09/10/21 3:04 PM
 **/

fun sort(A: IntArray): Int {
    A.sort()
    if (A[A.size - 1] <= 0) return 1
    for (i in 1 until A.size) {
        if (A[i] - A[i - 1] > 1) {
            return A[i - 1] + 1
        }
    }

    return A[A.size - 1] + 1
}

fun main() {
    println(sort(intArrayOf(1, 3, 6, 4, 1, 2)))
}
