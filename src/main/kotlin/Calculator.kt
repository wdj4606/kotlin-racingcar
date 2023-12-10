object Calculator {

    // 인자는 정수로 가정한다.

    fun calculate(input: String?): Int {
        input ?: throw IllegalArgumentException()

        if (input.isEmpty()) {
            throw IllegalArgumentException()
        }

        val elements = input.split(' ')
        var result = elements[0].toInt()
        var operation: Char? = null

        for (element in elements.subList(1, elements.size)) {
            if (element[0] in listOf('+', '-', '*', '/')) {
                operation = element[0]
                continue
            }
            result = calculate(result, element.toInt(), operation ?: throw IllegalArgumentException())
        }

        return result
    }

    fun calculate(a: Int, b: Int, op: Char): Int {
        return when (op) {
            '+' -> add(a, b)
            '-' -> subtract(a, b)
            '*' -> multiply(a, b)
            '/' -> divide(a, b)
            else -> 0
        }
    }

    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    fun divide(a: Int, b: Int): Int {
        return a / b
    }
}
