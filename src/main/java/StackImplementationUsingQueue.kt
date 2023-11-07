import java.util.*

/**
 * Created by Prasada Rao on 08/10/21 5:58 PM
 **/
class StackImplementationUsingQueue {


    private val queue: Queue<Int> = ArrayDeque(10)

    fun push(element: Int) {
        queue.add(element)
    }

    fun pop() {
        if (queue.size == 0) return
        queue.remove(queue.elementAt(queue.size - 1))
    }

    override fun toString(): String {
        return queue.toString()
    }
}

fun main() {
    val stack = StackImplementationUsingQueue()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.pop()
    stack.push(4)
    stack.pop()
    stack.push(5)
    stack.pop()
    stack.push(6)
    stack.pop()
    println(stack)
}