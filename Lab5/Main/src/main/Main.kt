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
    fun maxxDown(x: Int, a: Int): Int = if(x < 10) if(a < x) x else a else if (x%10 < a) maxxDown(x/10, a) else  maxxDown(x/10, x%10)
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

    //функция высшего порядка принимает функцию
    tailrec fun digits(x: Int, a: Int, f: (Int, Int) -> Int): Int =
        if (x % 10 == 0) a else digits(x / 10, f(a, x % 10), f)

    //функция для подсчета максимальной цифры числа
    fun maxd(n: Int): Int = digits(n,0) {a, b -> if (a>b) a else b}
    //функция для подсчета суммы цифр числа делящихся на 3
    fun sum3d(n: Int): Int = digits(n,0) {a,b -> if (b%3 == 0) a+b else a}

    //функция высшего порядка принимает функцию
    tailrec fun countDivisors(n: Int, x: Int, a: Int, f: (Int, Int) -> Int): Int =
        if (x > n) a else countDivisors(n, x + 1, f(a, x), f)

    //функция для подсчета кол-во делителей числа
    fun numbd(n: Int): Int = countDivisors(n, 1, 0) { a, b -> if (n % b == 0) a + 1 else a }



    //НОД - проверяет на взаимную простоту
    fun nod(a: Int, b: Int): Int = if (b == 0) a else nod(b, a%b)
    //находти количество чисел, взаимно простых с заданным.
    fun areCompire(n: Int, x: Int, k: Int, f: (Int, Int) -> Int): Int = if (n < x) k else if (nod(n,x) == 1) areCompire(n,x+1,f(k,x), f) else areCompire(n,x+1,k, f)
    fun countCoprimes(n: Int): Int = areCompire(n,1, 0) {a,b -> a+b}

    fun digits(x: Int): List<Int> = if (x < 10) listOf(x) else digits(x / 10) + (x % 10)
    //находит делитель числа, являющийся взаимно простым с наибольшим количеством цифр данного числа
    fun maxCopDivv(n: Int, i: Int, best: Int, maxc: Int): Int = if (n < i) best else if (n % i == 0 && digits(i).count { nod(n, it) == 1 } > maxc) maxCopDivv(n,i+1, i, digits(i).count { nod(n, it) == 1 }) else maxCopDivv(n,i+1, best, maxc)
    fun maxCopDiv(n: Int): Int = maxCopDivv(n,1,1, 0)
}