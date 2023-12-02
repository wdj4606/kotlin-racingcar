package step2

object Calculator {
    fun calculate(data: String?): String {
        val checkedData = Checker.checkData(data)

        val calcItems: MutableList<String> = checkedData.split(" ").toMutableList()
        val calcCount = (calcItems.size - 1) / 2

        for (i in 0 until calcCount) {
            val number1 = calcItems.first().toInt()
            calcItems.removeFirst()

            val operator = calcItems.first()
            calcItems.removeFirst()

            val number2 = calcItems.first().toInt()

            calcItems[0] = calcData(number1, number2, operator).toString()
        }

        return calcItems[0]
    }

    fun calcData(number1: Int, number2: Int, operator: String): Int {
        if (operator == Opt.ADD.opt) {
            return add(number1, number2)
        } else if (operator == Opt.SUBTRACT.opt) {
            return subtract(number1, number2)
        } else if (operator == Opt.MULTIPLY.opt) {
            return multiply(number1, number2)
        }

        return divide(number1, number2)
    }

    fun add(number1: Int, number2: Int): Int {
        return number1 + number2
    }

    fun subtract(number1: Int, number2: Int): Int {
        return number1 - number2
    }

    fun multiply(number1: Int, number2: Int): Int {
        return number1 * number2
    }

    fun divide(number1: Int, number2: Int): Int {
        return number1 / number2
    }
}
