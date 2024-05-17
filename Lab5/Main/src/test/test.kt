import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class Test {
    @Test
    fun max() {
        val main = Main()
        val expected = 5
        assertEquals(expected, main.max(522))
        val expected1 = 1
        assertEquals(expected1, main.max(1111111))
    }

    @Test
    fun sum3() {
        val main = Main()
        val expected = 15
        assertEquals(expected, main.sum3(1234566))
        val expected1 = 0
        assertEquals(expected1, main.sum3(11114442))
    }

    @Test
    fun numb() {
        val main = Main()
        val expected = 8
        assertEquals(expected, main.numb(24))
        val expected1 = 2
        assertEquals(expected1, main.numb(2))
    }

    @Test
    fun maxDown() {
        val main = Main()
        val expected = 7
        assertEquals(expected, main.maxDown(471742))
        val expected1 = 1
        assertEquals(expected1, main.maxDown(1111101))
    }

    @Test
    fun maxUp() {
        val main = Main()
        val expected = 7
        assertEquals(expected, main.maxUp(471742))
        val expected1 = 1
        assertEquals(expected1, main.maxUp(1111101))
    }

    @Test
    fun sum3Up() {
        val main = Main()
        val expected = 15
        assertEquals(expected, main.sum3Up(1234566))
        val expected1 = 12
        assertEquals(expected1, main.sum3Up(3333))
    }

    @Test
    fun sum3Down() {
        val main = Main()
        val expected = 15
        assertEquals(expected, main.sum3Down(1234566))
        val expected1 = 12
        assertEquals(expected1, main.sum3Down(11166111))
    }

    @Test
    fun numbDown() {
        val main = Main()
        val expected = 8
        assertEquals(expected, main.numbDown(24))
        val expected1 = 4
        assertEquals(expected1, main.numbDown(15))
    }

    @Test
    fun numbUp() {
        val main = Main()
        val expected = 8
        assertEquals(expected, main.numbUp(24))
        val expected1 = 4
        assertEquals(expected1, main.numbUp(15))
    }

    @Test
    fun maxd() {
        val main = Main()
        val expected = 9
        assertEquals(expected, main.maxd(923745))
        val expected1 = 2
        assertEquals(expected1, main.maxd(1010120102))
    }

    @Test
    fun sum3d() {
        val main = Main()
        val expected = 18
        assertEquals(expected, main.sum3d(32345686))
        val expected1 = 0
        assertEquals(expected1, main.sum3d(0))
    }

    @Test
    fun numbd() {
        val main = Main()
        val expected = 1
        assertEquals(expected, main.numbd(1))
        val expected1 = 4
        assertEquals(expected1, main.numbd(15))
    }

    @Test
    fun countCoprimes() {
        val main = Main()
        val expected = 10
        assertEquals(expected, main.countCoprimes(5))
        val expected1 = 55
        assertEquals(expected1, main.countCoprimes(11))
    }

    @Test
    fun maxCopDiv() {
        val main = Main()
        val expected = 11
        assertEquals(expected, main.maxCopDiv(44))
        val expected1 = 1
        assertEquals(expected1, main.maxCopDiv(9))
    }

    @Test
    fun main() {
        val main = Main()
        main.main()
    }
}