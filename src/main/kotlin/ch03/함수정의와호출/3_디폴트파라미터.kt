package ch03.함수정의와호출

import java.lang.StringBuilder

/**
 * 자바의 문제점
 * 자바에서는 일부 클래스에서 오버로딩한 메서드가 너무 많아진다는 문제가 있다.
 * java.lang.Thread
 * - Thread()
 * - Thread(Runnable target)
 * - Thread(Runnable target, String name)
 * - Thread(String name)
 * - Thread(ThreadGroup group, Runnable target)
 * - Thread(ThreadGroup group, Runnable target, String name, long stackSize)
 * - Thread(ThreadGroup group, String name)
 * API 사용자에게 편의를 더하기 위해 인자 중 일부를 생략한 메서드를 만들게 된다.
 * 파라미터 이름과 타입이 계속 반복되며, 모든 오버로딩 함수에 대해 설명을 반복해 달아야 한다.
 *
 * 학습 목표
 * 디폴트 파라미터 값을 지정하여 중복되는 오버로드를 개선해보자.
 */
fun main() {
    val list = listOf(1, 5, 63)

    println(joinToStringWithDefaultParam(list, ", ", "", ""))

    // 일반 호출 문법을 사용하여 함수의 인자 순서로 값을 지정할 수 있다.
    println(joinToStringWithDefaultParam(list, "; "))

    // 이름 붙인 인자를 사용하여 인자 목록의 중간에 있는 인자를 생략하고, 지정하고 싶은 인자의 값을 지정할 수 있다.
    println(joinToStringWithDefaultParam(list, prefix = "# "))
}

fun <T> joinToStringWithDefaultParam(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
