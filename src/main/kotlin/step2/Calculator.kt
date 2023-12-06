package step2

object Calculator {

    private val arrayDeque: ArrayDeque<String> = ArrayDeque()

    private fun init(calculateValues: String) {
        require(!calculateValues.isNullOrBlank()) { "계산식이 비어있습니다." }
        arrayDeque.addAll(calculateValues.split(" "))
    }

    private fun convertNumber(number: String): Int {
        return number.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다.")
    }

    fun calculate(calculateValues: String): Int {
        init(calculateValues)

        while (arrayDeque.size >= 3) {
            var first: Int = convertNumber(arrayDeque.removeFirst())
            val operator: String = arrayDeque.removeFirst()
            val second: Int = convertNumber(arrayDeque.removeFirst())
            Operator.from(operator).op.apply { arrayDeque.addFirst(this(first, second).toString()) }
        }
        require(arrayDeque.size == 1) { "계산식이 잘못되었습니다." }
        return convertNumber(arrayDeque.removeFirst())
    }
}
