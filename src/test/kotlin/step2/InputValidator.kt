package step2

object InputValidator {
    fun requireNotNullOrBlank(value: String?, message: String = "Input must not be null or blank."): String {
        return value?.takeIf { it.isNotBlank() }
            ?: throw IllegalArgumentException(message)
    }
}
