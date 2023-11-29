import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "신현수", 32, nickname = "피터")
        assertThat(actual.name).isEqualTo("신현수")
        assertThat(actual.age).isEqualTo(32)
        assertThat(actual.nickname).isEqualTo("피터")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "신현수", age = 32, nickname = null)
        assertThat(actual.name).isEqualTo("신현수")
        assertThat(actual.age).isEqualTo(32)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person("신현수", 32)
        assertThat(actual.name).isEqualTo("신현수")
        assertThat(actual.age).isEqualTo(32)
        assertThat(actual.nickname).isEqualTo("신현수")
    }

    @Test
    fun `동등성 비교`() {
        val person1 = Person("신현수", 32)
        val person2 = Person("신현수", 32)

        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person = Person("신현수", 32)
        val actual = person.copy(nickname = "피터")

        assertThat(actual.name).isEqualTo("신현수")
        assertThat(actual.age).isEqualTo(32)
        assertThat(actual.nickname).isEqualTo("피터")
    }
}
