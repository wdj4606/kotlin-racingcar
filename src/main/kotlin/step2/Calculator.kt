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
        return when (operator) {
            Opt.ADD.opt -> return number1 + number2
            Opt.SUBTRACT.opt -> return number1 - number2
            Opt.MULTIPLY.opt -> return number1 * number2
            Opt.DIVIDE.opt -> return number1 / number2
            else -> throw IllegalArgumentException()
        }
    }
}
