package step2

class Calculator(val input: String = "") {
    fun result(): Int {
        val list = input.split(" ").toMutableList()
        require(list.size >= 3) { "입력 값이 올바르지 않습니다." }
        require(list.size % 2 != 0) { "입력 값이 올바르지 않습니다." }

        fun removeCalculatedValue(list: MutableList<String>) {
            list.removeAt(1)
            list.removeAt(1)
            list.removeAt(1)
        }

        while (list.size != 1) {
            list.add(0, calculate(getNumeric(list[0]), getNumeric(list[2]), list[1]).toString())
            removeCalculatedValue(list)
        }

        return list[0].toInt()
    }

    private fun calculate(x: Int, y: Int, operator: String): Int {
        return when (operator) {
            "+" -> x + y
            "-" -> x - y
            "*" -> x * y
            "/" -> {
                require(y != 0) { "0으로 나눌 수 없습니다." }
                x / y
            }
            else -> throw IllegalArgumentException("지원하지 않는 연산자입니다.")
        }
    }

    private fun getNumeric(input: String): Int {
        require(input.toIntOrNull() != null) { "숫자가 아닙니다." }
        return input.toInt()
    }
}
