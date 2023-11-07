/**
 * Created by Prasada Rao on 05/10/21 8:49 PM
 **/
class Fibonacci {

    fun fibonacci(number: Int): Int {

        if (number < 2) return number

        return fibonacci(number - 1) + fibonacci(number - 2)
    }

    fun fibonacciUsingMemoization(n: Int): Int {
        return fibonacciUsingMemoizationRecursion(Array(n + 1) { -1 }, n)
    }

    fun fibonacciUsingMemoizationRecursion(F: Array<Int>, n: Int): Int {

        if (n <= 1) return n

        if (F[n] > 0) return F[n]

        F[n] = fibonacci(n - 1) + fibonacci(n - 2)
        return F[n]
    }

}

fun main() {
    println(Fibonacci().fibonacciUsingMemoization(9))
}