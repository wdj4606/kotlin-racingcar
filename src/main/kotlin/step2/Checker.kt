package step2

object Checker {
    fun checkData(data: String?): String {
        require(!data.isNullOrBlank()) {
            throw IllegalArgumentException()
        }

        val calcItems = data.split(" ")
        for ((index, calcItem) in calcItems.withIndex()) {
            checkItem(index, calcItem)
        }

        return data
    }

    fun checkItem(index: Int, calcItem: String) {
        if (index % 2 == 0) {
            isNumeric(calcItem)
            return
        }

        isOperator(calcItem)
    }

    fun isNumeric(s: String) {
        try {
            s.toInt()
        } catch (e: NumberFormatException) {
            throw e
        }
    }

    fun isOperator(operatorItem: String) {
        val operator = Opt.values().find { item -> item.opt == operatorItem }

        require(operator != null) {
            throw IllegalArgumentException()
        }
    }
}
