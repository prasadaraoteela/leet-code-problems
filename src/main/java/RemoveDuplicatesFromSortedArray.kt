/**
 * Created by Prasada Rao on 05/10/21 11:11 PM
 **/
class RemoveDuplicatesFromSortedArray {

    fun removeDuplicates(nums: IntArray): Int {
        var unique = 1
        var i = 1

        while (i < nums.size) {
            if (nums[i] != nums[i - 1]) {
                nums[unique++] = nums[i]
            }
            i++
        }
        println(nums.contentToString())
        return unique
    }

    fun removeDuplicates2(nums: IntArray): Int {
        var i = 1
        var unique = 1
        var lastDuplicatedIndex = 0
        while (i < nums.size) {
            val nextUniqueIndex = nextUniqueIndex(nums, lastDuplicatedIndex)
            if (nextUniqueIndex != -1) {
                nums[unique++] = nums[nextUniqueIndex]
                lastDuplicatedIndex = nextUniqueIndex
            }
            i++
        }
        return unique
    }

    private fun nextUniqueIndex(nums: IntArray, lastDuplicatedIndex: Int): Int {
        for (i in lastDuplicatedIndex + 1 until nums.size) {
            if (nums[lastDuplicatedIndex] != nums[i]) return i
        }
        return -1
    }

    private fun swap(nums: IntArray, left: Int, right: Int) {
        val temp = nums[left]
        nums[left] = nums[right]
        nums[right] = temp
    }

    fun removeDuplicates1(nums: IntArray): Int {

        var i = 0
        var count = 1
        while (i < nums.size - 1) {
            if (nums[i] xor nums[i + 1] == 0) {
                nums[i] = -1
                count--
            }
            count++
            i++
        }
        i = 0
        var j = 0
        while (i < nums.size - 1) {
            if (nums[i] != -1) {
                val temp = nums[j]
                nums[j] = nums[i]
                nums[i] = temp
                j++
            } else {
                i++
            }
        }
        println(nums.contentToString())
        return count
    }
}

fun main() {
    println(RemoveDuplicatesFromSortedArray().removeDuplicates(intArrayOf(1, 1, 2)))
    println(RemoveDuplicatesFromSortedArray().removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
}