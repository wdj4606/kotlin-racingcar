package step2

class Calculator(private val utils: Utils) {

    fun calculate(input: String?): Double {
        utils.validateInput(input)
        val inputList = utils.splitStringIntoArrayList(input!!)
        utils.validateInputArrayList(inputList)

        var result: Double = inputList.first().toDouble()
        inputList.removeFirst()

        while (inputList.size != 0) {
            val opt = inputList.first()
            inputList.removeFirst()
            val nextData = inputList.first().toDouble()
            inputList.removeFirst()

            result = Operators.operate(result, nextData, opt)
        }
        return result
    }
}
