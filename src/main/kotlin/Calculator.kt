object Calculator {

    // 인자는 정수로 가정한다.
    enum class Operation(val char: Char) {
        ADD('+'),
        SUBTRACT('-'),
        MULTIPLY('*'),
        DIVIDE('/')
    }

    fun calculate(input: String?): Int {
        require(!input.isNullOrBlank())

        val elements = input.split(' ')
        var result = elements[0].toInt()
        var operation: Operation? = null

        for (element in elements.subList(1, elements.size)) {
            val op = Operation.values().firstOrNull { it.char == element[0] }
            if (op != null) {
                operation = op
                continue
            }
            result = calculate(result, element.toInt(), operation ?: throw IllegalArgumentException())
        }

        return result
    }

    private fun calculate(a: Int, b: Int, op: Operation): Int {
        return when (op) {
            Operation.ADD -> a + b
            Operation.SUBTRACT -> a - b
            Operation.MULTIPLY -> a * b
            Operation.DIVIDE -> a / b
        }
    }
}
