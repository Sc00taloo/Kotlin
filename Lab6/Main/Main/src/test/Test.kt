import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class Test {
    @Test
    fun countSquares() {
        val main = Main()
        val expected = 2
        val list = listOf(1, 4, 9, 16, 20, 25, 30)
        assertEquals(expected, main.countSquares(list))
    }

    @Test
    fun createTupleList() {
        val main = Main()
        val expected = listOf(
            Triple(9, 1, 4),
            Triple(3, 3, 4),
            Triple(1, 3, 2),
            Triple(1, 6, 1)
        )
        val ai = listOf(1,3,9,1)
        val bi = listOf(3,6,1,3)
        val ci = listOf(6,1,8,2)
        assertEquals(expected, main.createTupleList(ai, bi,ci))
    }

    @Test
    fun minIndex() {
        val main = Main()
        val expected = 2
        val test = intArrayOf(4,2,1,6,3,1,2)
        assertEquals(expected, main.minIndex(test))
    }

    @Test
    fun uniq() {
        val main = Main()
        val expected = 6
        val test = intArrayOf(1,1,2,6,2,1,2)
        assertEquals(expected, main.uniq(test))
    }

    @Test
    fun twoMin() {
        val main = Main()
        val expected = Pair(1,1)
        val test = intArrayOf(6,7,8,4,3,2,7,1,3,8,3,1)
        assertEquals(expected, main.twoMin(test))
    }

    @Test
    fun minMaxSwap() {
        val main = Main()
        val test = intArrayOf(4,3,1,5,6,3,6,9,6,3)
        val expected = main.minMaxSwap(test)
        assertEquals(expected, main.minMaxSwap(test))
    }

    @Test
    fun chetEl() {
        val main = Main()
        val expected = 4
        val test = intArrayOf(1,2,3,4,5,6,7,8,9)
        assertEquals(expected, main.chetEl(test))
    }

    @Test
    fun betweenMax() {
        val main = Main()
        val expected = listOf(4,1,3,6)
        val test = intArrayOf(2,3,9,4,1,3,6,9,1,4,2)
        assertEquals(expected, main.betweenMax(test))
    }
}