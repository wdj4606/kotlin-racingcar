package step2

data class Calculator(val input: String = "") {
    fun result(): Int {
        val list = input.split(" ").toMutableList()
        if (list.size < 3) {
            throw IllegalArgumentException("입력 값이 올바르지 않습니다.")
        }

        if (list.size % 2 == 0) {
            throw IllegalArgumentException("입력 값이 올바르지 않습니다.")
        }

        while (list.size != 1) {
            list.add(0, calculate(list[0], list[2], list[1]))
            list.removeAt(1)
            list.removeAt(1)
            list.removeAt(1)
        }

        return list[0].toInt()
    }

    private fun calculate(x: String, y: String, operator: String): String {
        if (!isNumeric(x) || !isNumeric(y)) {
            throw IllegalArgumentException("숫자가 아닙니다.")
        }

        return when (operator) {
            "+" -> add(x, y)
            "-" -> subtract(x, y)
            "*" -> multiply(x, y)
            "/" -> divide(x, y)
            else -> throw IllegalArgumentException("지원하지 않는 연산자입니다.")
        }
    }

    private fun add(x: String, y: String): String {
        return (x.toInt() + y.toInt()).toString()
    }

    private fun subtract(x: String, y: String): String {
        return (x.toInt() - y.toInt()).toString()
    }

    private fun multiply(x: String, y: String): String {
        return (x.toInt() * y.toInt()).toString()
    }

    private fun divide(x: String, y: String): String {
        if (y.toInt() == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }

        return (x.toInt() / y.toInt()).toString()
    }

    private fun isNumeric(input: String): Boolean {
        return input.toIntOrNull() != null
    }
}
