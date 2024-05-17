import java.lang.System.`in`
import java.util.*

class Main {
    //максимальная цифра числа
    fun maxx(x: Int, a: Int): Int = if(x%10 == 0) if(a < x) x else a else if (x%10 < a) maxx(x/10, a) else  maxx(x/10, x%10)
    fun max(x: Int): Int = maxx(x, 0)

    //сумма цифр числа делящихся на 3
    fun sum3(n: Int): Int = if (n % 10 == 0) 0 else if ((n%10) % 3 == 0) n%10 + sum3(n/10) else sum3(n/10)

    //кол-во делителей числа
    fun numbNumb(n: Int, k: Int, x: Int): Int = if (n == x) k+1 else if (n % x == 0) numbNumb(n, k+1, x+1) else numbNumb(n, k, x+1)
    fun numb(n: Int): Int = numbNumb(n,0, 1)
}