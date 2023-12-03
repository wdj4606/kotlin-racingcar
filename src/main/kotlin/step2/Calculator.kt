package step2

object Calculator {

    fun calculate(calculateValues: String): Int {
        if (calculateValues.isNullOrBlank()) {
            throw IllegalArgumentException("계산식이 비어있습니다.")
        }

        val arrayDeque = ArrayDeque<Any>()
        arrayDeque.addAll(calculateValues.split(" "))

        var result: Int = arrayDeque.removeFirst().toString().toInt()
        while (arrayDeque.size > 0) {
            val operator = arrayDeque.removeFirstOrNull().toString()
            val second = arrayDeque.removeFirst().toString().toInt()

            result = Operator.from(operator).apply(result, second)
        }
        return result
    }
}
