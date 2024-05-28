import java.util.regex.Pattern
import java.util.*
import kotlin.collections.HashSet

class VeniclePass(val name: String,val series: String, val number: String, val issueDate: String): Comparable<VeniclePass> {
    fun write() {
        println("Паспорт транспортного средства\n" +
                "Владелец : $name\n" +
                "Серия : $series\n" +
                "Номер : $number\n" +
                "Дата: $issueDate\n"
        )
    }
    init {
        require(validateSeriesNumber(series, number)) { "Invalid series or number format" }
        require(validateDate(issueDate)) { "Invalid date format" }
    }

    //Функция equals проверяет равенство объектов VeniclePass по значениям их свойств series, number и issueDate.
    override fun equals(other: Any?): Boolean = if (other is VeniclePass) {
        (series == other.series) &&
        (number == other.number) &&
        (issueDate == other.issueDate)
    } else false

    //Функция compareTo используется для сравнения двух объектов VeniclePass: name, series, number и issueDate.
    override fun compareTo(other: VeniclePass): Int {
        return compareValuesBy(
            this, other,
            VeniclePass::name, VeniclePass::series, VeniclePass::number, VeniclePass::issueDate
        )
    }

    override fun hashCode(): Int {
        var result = series.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + number.hashCode()
        result = 31 * result + issueDate.hashCode()
        return result
    }

    companion object {
        private const val Number = "[A-Z]{2}\\d{6}"
        private const val date = "\\d{2}\\.\\d{2}\\.\\d{4}"

        private fun validateSeriesNumber(series: String, number: String): Boolean {
            val Num_Pat = Pattern.compile(Number)
            return Num_Pat.matcher(series + number).matches()
        }

        private fun validateDate(date: String): Boolean {
            val dat_Pat = Pattern.compile(date)
            return dat_Pat.matcher(date).matches()
        }
    }
}

fun main() {

    val m: MutableList<VeniclePass> = mutableListOf()
    val u1=VeniclePass("John","AG","897609","14.05.2020")
    val u2=VeniclePass("Vanya","FK","125456","01.12.2021")
    val u3=VeniclePass("Max","BN","124905","30.06.2020")
    val u4=VeniclePass("Tailer","QA","567842","01.01.2020")
    val u5=VeniclePass("Jho","QA","567842","01.01.2020")
    m.add(u1)
    m.add(u2)
    m.add(u3)
    m.add(u4)
    for (i in m)i.write()
    println("Сортировка:")
    m.sort()
    for (i in m)i.write()
    println("HashSet:")
    val h: HashSet<VeniclePass> = hashSetOf()
    h.add(u1)
    h.add(u2)
    h.add(u3)
    h.add(u4)
    h.add(u5)
    for (i in h)i.write()

    println(h.contains(VeniclePass("Smite","AB", "123456", "01.01.2020")))
    println(h.contains(VeniclePass("Kling","EF", "789012", "01.01.2021")))

    val Date = TreeSet<VeniclePass>(compareBy { it.issueDate })
    Date.addAll(m)
    println("Сортировка по дате:")
    for (i in Date) {
        i.write()
    }

    val Series_Number = TreeSet<VeniclePass>(compareBy({ it.series }, { it.number }))
    println("Сортировка по серии и номеру:")
    Series_Number.addAll(m)
    for (i in Series_Number) {
        i.write()
    }
}