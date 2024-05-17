import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class Test {

    @Test
    fun max() {
        val main = Main()
        val expected = 5
        assertEquals(expected, main.max(522))
    }

    @Test
    fun sum3() {
        val main = Main()
        val expected = 15
        assertEquals(expected, main.sum3(1234566))
    }

    @Test
    fun numb() {
        val main = Main()
        val expected = 8
        assertEquals(expected, main.numb(24))
    }
}