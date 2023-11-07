import kotlin.math.pow

/**
 * Created by Prasada Rao on 01/10/21 10:07 AM
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 **/
class AddTwoNumbers {

    fun addTwoNumbersArithmetic(l1: ListNode?, l2: ListNode?): ListNode? {
        val number1 = getNumberFromNode(l1)
        val number2 = getNumberFromNode(l2)
        val sum = number1 + number2
        var quotient = sum.div(10)
        var remainder = sum.rem(10)

        val sumNode = ListNode(0)
        var current: ListNode? = sumNode
        while (quotient > 0 || remainder > 0) {
            current?.next = ListNode(remainder)
            current = current?.next
            remainder = quotient.rem(10)
            quotient = quotient.div(10)
        }
        return sumNode.next
    }

    private fun getNumberFromNode(node: ListNode?): Int {
        var current = node
        var power = 0
        var number = 0
        while (current != null) {
            number += 10f.pow(power).toInt().times(current.`val`)
            power++
            current = current.next
        }
        return number
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var root: ListNode? = null
        var n1: ListNode? = l1
        var n2: ListNode? = l2
        var sumNode: ListNode? = null
        var carry = 0
        while (n1 != null || n2 != null) {
            val v1 = n1?.`val` ?: 0
            val v2 = n2?.`val` ?: 0
            val sum = carry + v1 + v2
            carry = sum.div(10)
            val remainder = sum.rem(10)

            if (sumNode == null) {
                sumNode = ListNode(remainder)
                root = sumNode
            } else {
                sumNode.next = ListNode(remainder)
                sumNode = sumNode.next
            }
            n1 = n1?.next
            n2 = n2?.next
        }
        if (carry > 0) {
            sumNode?.next = ListNode(carry)
        }
        return root
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null

        override fun toString(): String {
            return "$`val`"
        }
    }
}

fun main() {
    val l11 = AddTwoNumbers.ListNode(2)
    val l12 = AddTwoNumbers.ListNode(4)
    val l13 = AddTwoNumbers.ListNode(9)
    l12.next = l13
    l11.next = l12

    val l21 = AddTwoNumbers.ListNode(5)
    val l22 = AddTwoNumbers.ListNode(6)
    val l23 = AddTwoNumbers.ListNode(4)
    val l24 = AddTwoNumbers.ListNode(9)
    l23.next = l24
    l22.next = l23
    l21.next = l22

//    AddTwoNumbers().addTwoNumbersArithmetic(l11, l21)
    val sum = AddTwoNumbers().addTwoNumbersArithmetic(l11, l21)
    var current = sum
    while (current != null) {
        println(current.`val`)
        current = current.next
    }
}