package ch02.코틀린기초

class 클래스와프로퍼티2(
    val name: String, // 읽기 전용 프로퍼티로, 코틀린은 (비공개) 필드와 필드를 읽는 단순한 (공개) 게터를 만들어낸다.
    var isMarried: Boolean // 쓸 수 있는 프로퍼티로, 코틀린은 (비공개) 필드, (공개) 게터, (공개) 세터를 만들어낸다.
)

/**
 * 코틀린에서 클래스 사용하기
 */
fun main(args: Array<String>) {
    val clazz = 클래스와프로퍼티2("Bob", true); // new 키워드를 사용하지 않고 생성자를 호출한다.
    println(clazz.name) // 프로퍼티 이름을 직접 사용해도 코틀린이 자동으로 게터를 호출해준다.
    println(clazz.isMarried)
}
