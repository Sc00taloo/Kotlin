import java.lang.System.`in`
import java.util.*
import kotlin.math.sqrt

class Main{
    //2.1
    fun countSquares(num: List<Int>): Int {
        val squares = num.map { it * it }
        return num.count { it in squares }
    }

    //2.2
    fun createTupleList(list1: List<Int>, list2: List<Int>, list3: List<Int>): List<Triple<Int, Int, Int>> {
        val sortedList1 = list1.sorted().reversed()
        val sortedList2 = sum(list2).sorted()
        val sortedList3 = count(list3).sorted().reversed()

        return sortedList1.mapIndexed { index, a ->
            Triple(a, sortedList2[index], sortedList3[index])
        }
    }
    //суммы цифр элемент второго списка
    fun sum(list: List<Int>): List<Int> {
        return list.map{summ(it)}
    }
    fun summ(num: Int): Int{
        return if (num < 10) {
            num
        } else {
            num % 10 + sumOfDigits(num / 10)
        }
    }
    fun sumOfDigits(num: Int): Int {
        return num.toString().sumOf { it.digitToInt() }
    }

    //количества делителей элемент третьего списка
    fun count(list: List<Int>): List<Int> {
        return list.map{count2(it)}
    }
    fun count2(num: Int, count: Int = 1, z: Int = 0): Int {
        return if (count >= num) {
            z + if (num % count == 0) 1 else 0
        } else {
            count2(num, count + 1, z + if (num % count == 0) 1 else 0)
        }
    }

    fun main() {
        val list = listOf(1, 4, 9, 16, 20, 25, 30)
        val count = countSquares(list)
        println(count)

        val ai = listOf(1, 3, 9, 1, 6, 11, 4)
        val bi = listOf(3,6,1,3,8,10,9)
        val ci = listOf(6,1,8,2,11,2,7)
        val result = createTupleList(ai, bi, ci)
        println(result)
    }

}
fun main() = Main().main()