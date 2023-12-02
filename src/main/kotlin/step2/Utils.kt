package step2

class Utils {

    // string이 null 이거나 빈 문자열이면 exception을 던진다.
    fun validateInput(input: String?) {
        if (input.isNullOrEmpty()) {
            throw IllegalArgumentException("Input is null or empty")
        }
    }
    fun validateInputArrayList(input: ArrayList<String>) {
        if (!isDouble(input.first())) {
            throw IllegalArgumentException("Input must start with number")
        }
        if (!isDouble(input.last())) {
            throw IllegalArgumentException("Input must end with number")
        }
    }

    // string을 공백을 기준으로 split 하여 arraylist로 반환한다.
    fun splitStringIntoArrayList(input: String): ArrayList<String> {
        return ArrayList(input.split(" "))
    }

    fun isDouble(input: String): Boolean {
        return try {
            input.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
}
