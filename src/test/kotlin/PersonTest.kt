import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(nickname = "Jean", name = "박홍진", age = 35)
        assertThat(person.nickname).isEqualTo("Jean")
        assertThat(person.name).isEqualTo("박홍진")
        assertThat(person.age).isEqualTo(35)
    }

    @Test
    fun `널 타입 인자`() {
        val person = Person(name = null, age = 35, nickname = null)
        assertThat(person.nickname).isNull()
        assertThat(person.name).isNull()
        assertThat(person.age).isEqualTo(35)
    }

    @Test
    fun `기본 인자`() {
        val person = Person("박홍진", 35)
        assertThat(person.nickname).isEqualTo("진")
        assertThat(person.name).isEqualTo("박홍진")
        assertThat(person.age).isEqualTo(35)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(nickname = "Jean", name = "박홍진", age = 35)
        val person2 = Person(nickname = "Jean", name = "박홍진", age = 35)

        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `데이터 클래스 복사`() {
        val person1 = Person(nickname = "Jean", name = "박홍진", age = 35)
        val person2 = person1.copy(name = "원동재")

        assertThat(person2).isEqualTo("원동재")
    }
}
