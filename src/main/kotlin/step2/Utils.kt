package step2

object Utils {

    fun getValidateInput(input: String?): String {
        require(!input.isNullOrEmpty()) { "Input must not be null or empty" }
        return input
    }

    fun getValidateInputArrayList(input: MutableList<String>): MutableList<String> {
        require(isDouble(input.first())) { "Input must start with number" }
        require(isDouble(input.last())) { "Input must end with number" }
        return input
    }

    fun splitStringIntoArrayList(input: String): MutableList<String> {
        return input.split(" ").toMutableList()
    }

    private fun isDouble(input: String): Boolean {
        return input.toDoubleOrNull() != null
    }
}
