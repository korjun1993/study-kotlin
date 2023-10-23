package ch03.함수정의와호출

import java.lang.StringBuilder

/**
 * 학습 목표
 * 이름 붙인 인자에 대해 알아본다.
 */
fun main() {
    val list = listOf(1, 2, 3)

    // joinToString 함수를 호출할 때마다 인자로 전달한 각 문자열이 어떤 역할을 하는지 구분하기 어렵다.
    println(joinToString(list, "; ", "(", ")"))

    // 코틀린으로 작성한 함수를 호출할 때는 함수에 전달하는 인자 중 일부의 이름을 명시할 수 있다.
    // 인자 중 어느 하나라도 이름을 명시하고 나면 그 뒤에 오는 모든 인자는 이름을 꼭 명시해야 한다.
    println(joinToString(collection = list, separator = "; ", prefix = "(", postfix = ")"))
}

fun <T> joinToString(collection: Collection<T>, separator: String, prefix: String, postfix: String): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
