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

    @Test
    fun maxDown() {
        val main = Main()
        val expected = 7
        assertEquals(expected, main.maxDown(471742))
    }

    @Test
    fun maxUp() {
        val main = Main()
        val expected = 7
        assertEquals(expected, main.maxUp(471742))
    }

    @Test
    fun sum3Up() {
        val main = Main()
        val expected = 15
        assertEquals(expected, main.sum3Up(1234566))
    }

    @Test
    fun sum3Down() {
        val main = Main()
        val expected = 15
        assertEquals(expected, main.sum3Down(1234566))
    }

    @Test
    fun numbDown() {
        val main = Main()
        val expected = 8
        assertEquals(expected, main.numbDown(24))
    }

    @Test
    fun numbUp() {
        val main = Main()
        val expected = 8
        assertEquals(expected, main.numbUp(24))
    }

    @Test
    fun maxd() {
        val main = Main()
        val expected = 9
        assertEquals(expected, main.maxd(923745))
    }

    @Test
    fun sum3d() {
        val main = Main()
        val expected = 18
        assertEquals(expected, main.sum3d(32345686))
    }

    @Test
    fun numbd() {
        val main = Main()
        val expected = 1
        assertEquals(expected, main.numbd(1))
    }
}