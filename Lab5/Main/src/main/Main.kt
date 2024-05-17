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

    //максимальная цифра числа рекурсией вниз
    fun maxxDown(x: Int, a: Int): Int = if(x%10 == 0) if(a < x) x else a else if (x%10 < a) maxx(x/10, a) else  maxx(x/10, x%10)
    fun maxDown(x: Int): Int = maxxDown(x, 0)

    //максимальная цифра числа рекурсией вверх
    fun maxUp(x: Int): Int = if (x < 10) x else if (maxUp(x/10) > x%10) maxUp(x/10) else x%10

    //сумма цифр числа делящихся на 3 рекурсией вверх
    fun sum3Up(n: Int): Int = if (n % 10 == 0) 0 else if ((n%10) % 3 == 0) n%10 + sum3Up(n/10) else sum3Up(n/10)

    //сумма цифр числа делящихся на 3 рекурсией вниз
    fun sum33Down(n: Int, k: Int): Int = if (n % 10 == 0) k else if ((n%10) % 3 == 0) sum33Down(n/10, k+(n%10)) else sum33Down(n/10, k)
    fun sum3Down(n: Int): Int = sum33Down(n, 0)

    //кол-во делителей числа рекурсией вниз
    fun numbDownn(n: Int, k: Int, x: Int): Int = if (n == x) k+1 else if (n % x == 0) numbDownn(n, k+1, x+1) else numbDownn(n, k, x+1)
    fun numbDown(n: Int): Int = numbDownn(n,0, 1)

    //кол-во делителей числа рекурсией вверх
    fun numbUpp(x: Int, k: Int): Int = if (k > x) 0 else (if (x % k == 0) 1 + numbUpp(x, k+1) else 0 + numbUpp(x, k+1))
    fun numbUp(x: Int): Int = numbUpp(x,1)
}