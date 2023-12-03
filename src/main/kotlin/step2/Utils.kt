package step2

object Utils {

    fun getValidateInput(input: String?): String {
        require(!input.isNullOrEmpty()) { "Input must not be null or empty" }
        return input
    }

    fun getValidateInputArrayList(input: List<String>): List<String> {
        require(isDouble(input.first())) { "Input must start with number" }
        require(isDouble(input.last())) { "Input must end with number" }
        return input
    }

    fun splitStringIntoArrayList(input: String): List<String> {
        return List(input.split(" "))
    }

    private fun isDouble(input: String): Boolean {
        return try {
            input.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
}
