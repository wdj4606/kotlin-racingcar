import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        var person = Person("박찬석", 32, "막토")
        assertThat(person.name).isEqualTo("박찬석")
        assertThat(person.age).isEqualTo(32)
        assertThat(person.nickname).isEqualTo("막토")
    }

    @Test
    fun `널 타입 인자`() {
        var person = Person(name = null, age = 32, nickname = "막토")

        assertThat(person.name).isNull()
    }

    @Test
    fun `기본 인자`() {
        val aa = "12"

        var person = Person(name = aa, 33)

        assertThat(person.name).isNotNull()
    }

    @Test
    fun `데이터 클래스`() {
        var person1 = Person(name = "박찬석", 32, "막토")
        var person2 = person1

        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `데이터 클래스 복사`() {
        var person1 = Person(name = "박찬석", 33)
        var person2 = Person(name = "박찬석", 33)

        assertThat(person1).isEqualTo(person2)
    }
}
