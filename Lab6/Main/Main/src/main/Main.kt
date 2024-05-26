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

    //3.2
    fun minIndex(array: IntArray): Int = minIndexx(array, array.first(), 0, 0)
    fun minIndexx(array: IntArray, a: Int, ind: Int, currentInd: Int): Int =
        if ((array.size) == currentInd) ind
        else if (a > array[currentInd]) minIndexx(array, array[currentInd], currentInd, currentInd + 1)
        else minIndexx(array, a, ind, currentInd + 1)

    //3.11
    fun uniq(array: IntArray): Int {
        val grouped = array.groupBy { it }
        val uniqueElement = grouped.entries.find { it.value.size == 1 }?.key
        return uniqueElement ?: throw IllegalArgumentException("Нет уникальных")
    }

    //3.23
    fun twoMin(array: IntArray): Pair<Int, Int> = twoMinn(array, Int.MAX_VALUE, Int.MAX_VALUE, 0)
    fun twoMinn(array: IntArray, min1: Int, min2: Int, index: Int): Pair<Int, Int> =
        if ((array.size) == index) Pair(min1, min2)
        else if (array[index] < min1) twoMinn(array, array[index], min1, index+1)
        else if (array[index] < min2) twoMinn(array, min1, array[index], index+1)
        else twoMinn(array, min1, min2, index+1)

    //3.17
    fun minMaxSwap(array: IntArray): IntArray{
        val min = array.min()
        val max = array.max()
        val minIndex = array.indexOfFirst { it == min }
        val maxIndex = array.indexOfFirst { it == max }
        array[minIndex] = max
        array[maxIndex] = min
        return array
    }

    //3.31
    fun chetEl(array: IntArray): Int = chetEll(array, 0)
    fun chetEll(array: IntArray, index: Int): Int =
        if ((array.size) == index) 0
        else if (array[index] % 2 == 0) 1 + chetEll(array, index+1)
        else chetEll(array, index+1)

    //3.28
    fun betweenMax(array: IntArray): List<Int> {
        val max = array.max()
        val firstMaxIndex = array.indexOfFirst { it == max }
        val lastMaxIndex = array.indexOfLast { it == max }

        return if (firstMaxIndex == lastMaxIndex) {
            emptyList()
        } else {
            array.slice((firstMaxIndex + 1) until lastMaxIndex)
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

        val test = intArrayOf(4,1,2,6,3,1,2)
        val result1 = minIndex(test)
        println(result1)

        val test2 = intArrayOf(1,1,2,6,2,1,2)
        val result2 = uniq(test2)
        println(result2)

        val test3 = intArrayOf(6,7,8,4,3,2,7,1,3,8,3,1)
        val result3 = twoMin(test3)
        println(result3)

        val test4 = intArrayOf(4,3,1,5,6,3,6,9,6,3)
        val result4 = minMaxSwap(test4)
        println(result4.joinToString())

        val test5 = intArrayOf(1,2,3,4,5,6,7,8,9)
        val result5 = chetEl(test5)
        println(result5)

        val test6 = intArrayOf(2,3,9,4,1,3,6,9,1,4,2)
        val result6 = betweenMax(test6)
        println(result6)
    }

}
fun main() = Main().main()