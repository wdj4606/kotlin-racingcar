package step2

object Calculator {
    fun calculate(input: String?): Double {
        val validatedInputString = Utils.getValidateInput(input)
        val inputList = Utils.splitStringIntoArrayList(validatedInputString)
        val validatedInputArrayList = Utils.getValidateInputArrayList(inputList)

        var result: Double = validatedInputArrayList.first().toDouble()
        validatedInputArrayList.removeFirst()

        while (validatedInputArrayList.size != 0) {
            val opt = validatedInputArrayList.first()
            validatedInputArrayList.removeFirst()
            val nextData = validatedInputArrayList.first().toDouble()
            validatedInputArrayList.removeFirst()

            result = Operators.operate(result, nextData, opt)
        }
        return result
    }
}
