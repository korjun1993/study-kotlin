package ch11.DSL


fun buildString1(builderAction: (StringBuilder) -> Unit): String {
    val sb = StringBuilder()
    builderAction(sb)
    return sb.toString()
}

val s = buildString1 {
    it.append("Hello, ") // it는 수신객체(StringBuilder) 인스턴스를 가리킨다.
    it.append("World!")
}

/**
 * 수신 객체 지정 람다를 사용해 다시 정의해보자.
 */
fun buildString2(builderAction: StringBuilder.() -> Unit): String { // 파라미터(builderAction): 수신객체가 StringBuilder 인 함수 타입
    val sb = StringBuilder()
    sb.builderAction()
    return sb.toString()
}

val s2 = buildString2 {
    this.append("Hello, ")// this 키워드는 StringBuilder 인스턴스를 가리킨다.
    append("World!") // this 를 생략해도 묵시적으로 StringBuilder 인스턴스가 수신 객체로 취급된다. 더 이상 it 를 사용하지 않아도 된다.
}

/**
 * apply 를 적용해보자.
 * apply, with 모두 자신이 제공받은 수신 객체로 확장 함수 타입의 람다를 호출한다.
 * apply -> 수신 객체에 대한 확장 함수로 선언되어 있고, 수신 객체를 반환함 ex) StringBuilder().apply(block)
 * with -> 수신 객체를 첫 번째 파라미터로 받고, 람다의 결과를 반환함 ex) with(StringBuilder(), block)
 */

fun buildString3(builderAction: StringBuilder.() -> Unit): String {
    return StringBuilder().apply(builderAction).toString()
}

val s3 = buildString3 {
    this.append("Hello, ")
    append("World!")
}

fun main() {
    println(s)
    println(s2)
    println(s3)
    val map = mutableMapOf(1 to "one")
    map.apply { this[2] = "two" } // apply 반환값: Map<Int,String>
    with(map) { this[3] = "three" } // with 반환값: 람다의 반환타입
}
