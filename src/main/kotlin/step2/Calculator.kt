package step2

fun calculate(data: String?): String {
    checkData(data)

    val calcItems = ArrayList<String>(data!!.split(" "))
    val calcCount = (calcItems.size - 1) / 2

    for (i in 0 until calcCount) {
        val number1 = calcItems.first().toDouble()
        calcItems.removeFirst()

        val operator = calcItems.first()
        calcItems.removeFirst()

        val number2 = calcItems.first().toDouble()

        calcItems[0] = calcData(number1, number2, operator).toString()
    }

    return calcItems[0]
}

fun calcData(number1: Double, number2: Double, operator: String): Double {
    if (operator == "+") {
        return add(number1, number2)
    } else if (operator == "-") {
        return subtract(number1, number2)
    } else if (operator == "*") {
        return multiply(number1, number2)
    }

    return divide(number1, number2)
}

fun checkData(data: String?): Boolean {
    if (data === null || data == "")
        throw IllegalArgumentException()

    val calcItems = data.split(" ")
    for ((index, calcItem) in calcItems.withIndex()) {
        checkItem(index, calcItem)
    }

    return true
}

fun checkItem(index: Int, calcItem: String): Boolean {
    if (index % 2 == 0) {
        return isNumeric(calcItem)
    }

    return isOperator(calcItem)
}

fun isNumeric(s: String): Boolean {
    return try {
        s.toDouble()
        true
    } catch (e: NumberFormatException) {
        throw e
    }
}

fun isOperator(operatorItem: String): Boolean {
    val operators: Array<String> = arrayOf("+", "-", "*", "/")

    if (operators.contains(operatorItem))
        return true

    throw IllegalArgumentException()
}

fun add(number1: Double, number2: Double): Double {
    return number1 + number2
}

fun subtract(number1: Double, number2: Double): Double {
    return number1 - number2
}

fun multiply(number1: Double, number2: Double): Double {
    return number1 * number2
}

fun divide(number1: Double, number2: Double): Double {
    return number1 / number2
}
