package ch03.함수정의와호출

import java.lang.StringBuilder

fun main() {
    val list = listOf(1, 2, 3)
    println(list.joinToString(separator = "; ", prefix = "(", postfix = ")"))
}

fun <T> Collection<T>.joinToString( // Collection<T>에 대한 확장 함수를 선언한다.
    separator: String = ", ", // 파라미터 디폴트 값을 지정한다.
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
