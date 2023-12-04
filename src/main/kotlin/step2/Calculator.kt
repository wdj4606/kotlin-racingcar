package step2

object Calculator {

    fun calculate(calculateValues: String): Int {
        if (calculateValues.isNullOrBlank()) {
            throw IllegalArgumentException("계산식이 비어있습니다.")
        }

        val arrayDeque: ArrayDeque<String> = ArrayDeque(calculateValues.split(" "))

        var result: Int = arrayDeque.removeFirst().toInt()
        while (arrayDeque.size > 0) {
            val operator: String = arrayDeque.removeFirst()
            val second: Int = arrayDeque.removeFirst().toInt()

            result = Operator.from(operator).apply(result, second)
        }
        return result
    }
}
