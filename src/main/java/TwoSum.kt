/**
 * Created by Prasada Rao on 30/09/21 7:47 PM
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 **/
class TwoSum {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for ((i, num) in nums.withIndex()) {
            println("$i: $num")
            map[num] = i
        }
        val intArray = IntArray(2)
        for ((i, num) in nums.withIndex()) {
            val sub = target - num
            if (map.containsKey(sub) && i != map[sub]) {
                intArray[0] = i
                intArray[1] = map[sub]!!
                return intArray
            }
        }
        return intArray
    }

}

fun main() {
    println(TwoSum().twoSum(intArrayOf(3, 2, 4), 6).contentToString())
}