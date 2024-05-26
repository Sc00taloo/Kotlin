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

}