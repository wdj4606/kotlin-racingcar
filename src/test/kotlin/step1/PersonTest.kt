package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `Person should be able to say hello`() {
        val person = Person(name = "John", age = 30, nickname = "JD")
        assertThat(person.name).isEqualTo("John")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("JD")
    }

    @Test
    fun `null type`() {
        val person = Person(name = "John", age = 30, nickname = null)
        assertThat(person.name).isEqualTo("John")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `base value type`() {
        val person = Person(name = "John", age = 30)
        assertThat(person.name).isEqualTo("John")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("John")
    }

    @Test
    fun `동등성 비교`() {
        val person1 = Person(name = "John", age = 30)
        val person2 = Person(name = "John", age = 30)
        assertThat(person1).isEqualTo(person2)
//        assertThat(person1).usingRecursiveComparison().isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person1 = Person(name = "John", age = 30)
//        val person2 = person1.copy()
//        assertThat(person1).isEqualTo(person2)

        val person2 = person1.copy(nickname = "Jane")
        assertThat(person2.nickname).isEqualTo("Jane")
    }
}
